package com.adesh.ratings.services;

import java.util.List;

import com.adesh.ratings.entities.Rating;

public interface RatingService {
	
	//create
	Rating create(Rating rating);
	
	// get all rating
	List<Rating> getAll();
	
	// getalll by userid
	
	List<Rating>getRatingByUserId(String userId);
	
	
	
	//get all by hotel
	List<Rating>getRatingByHotelId(String hotelId);
	

}
