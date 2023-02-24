package com.adesh.ratings.serviceImpl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adesh.ratings.entities.Rating;
import com.adesh.ratings.repositories.RatingRepository;
import com.adesh.ratings.services.RatingService;

@Service
public class RatingServiceImpl implements RatingService {

	@Autowired
	private RatingRepository ratingRepository;
	
	@Override
	public Rating create(Rating rating) {
		String randId=UUID.randomUUID().toString();
		rating.setRatingId(randId);
		return this.ratingRepository.save(rating);
		
		
	}

	@Override
	public List<Rating> getAll() {
		return this.ratingRepository.findAll();
	}

	@Override
	public List<Rating> getRatingByUserId(String userId) {
		// TODO Auto-generated method stub
		return this.ratingRepository.findByUserId(userId);
	}

	@Override
	public List<Rating> getRatingByHotelId(String hotelId) {
		// TODO Auto-generated method stub
		return this.ratingRepository.findByHotelId(hotelId);
	}

}
