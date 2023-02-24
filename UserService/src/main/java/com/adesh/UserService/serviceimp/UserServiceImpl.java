package com.adesh.UserService.serviceimp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.adesh.UserService.entities.Hotel;
import com.adesh.UserService.entities.Rating;
import com.adesh.UserService.entities.User;
import com.adesh.UserService.exceptions.ResourceNotFoundException;
import com.adesh.UserService.external.servies.HotelService;
import com.adesh.UserService.repositories.UserRepository;
import com.adesh.UserService.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private HotelService hotelService;

	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public User saveUser(User user) {
		// to gen random id
		String randomUserId = UUID.randomUUID().toString();
		user.setUserId(randomUserId);
		return this.userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {

		return this.userRepository.findAll();
	}

	@Override
	public User getUser(String userId) {
		// get user from database with help of user repository
		User user = this.userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User with given id is not found!!" + userId));

		// fetch rating of the abover user from Rating service
		// http://localhost:8083/ratings/users/ae33b636-1443-422f-9c3d-bce4fb9a898a
		// user id we giving in static  way 
		Rating[] ratingofuser = this.restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+user.getUserId(), Rating[].class);
		
		List<Rating> ratings=Arrays.stream(ratingofuser).toList();
	  logger.info("{}",ratingofuser); // in the terminal the rating detail will be shown
	 
	List<Rating> ratingList=ratings.stream().map(rating->{ // ratingofUser has all the rating given by use
		  
		  //http://localhost:8082/hotels/f0db12d3-e826-46ef-9999-712a8227cb91
		  //api call to hotel service to get the hotel // so user has the hotel details also
		  //	ResponseEntity<Hotel> forEntity=this.restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(), Hotel.class);  //use entity if want to use fetch single entity
		  	Hotel hotel=hotelService.getHotel(rating.getHotelId());
		//  	logger.info("response status code:{}",forEntity.getStatusCode());
		  //set the hotel to rating
		  	rating.setHotel(hotel);
		  //return the rating given by user one by one
		  return rating;
		  
	  }).collect(Collectors.toList());
	  
	  
	 
	  //set the rating in the user
	  user.setRatings(ratingList);
	  
	  
		return user;

	}

}
