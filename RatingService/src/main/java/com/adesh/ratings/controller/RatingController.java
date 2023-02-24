package com.adesh.ratings.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adesh.ratings.entities.Rating;
import com.adesh.ratings.services.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {
	
	@Autowired
	private RatingService ratingService;
	
	//create
	@PostMapping
	public ResponseEntity<Rating>createRating(@RequestBody Rating rating){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(this.ratingService.create(rating));
		
	}
	
	@GetMapping
	public ResponseEntity<List<Rating>> getAll(){
		return new ResponseEntity<List<Rating>>(this.ratingService.getAll(),HttpStatus.OK);
			
	}
	@GetMapping("/users/{userId}")
	public ResponseEntity<List<Rating>> getByUserId(@PathVariable String userId){
		return new ResponseEntity<List<Rating>>(this.ratingService.getRatingByUserId(userId),HttpStatus.OK);
			
	}
	@GetMapping("/hotels/{hotelId}")
	public ResponseEntity<List<Rating>> getByHotelId(@PathVariable String hotelId){
		return new ResponseEntity<List<Rating>>(this.ratingService.getRatingByHotelId(hotelId),HttpStatus.OK);
			
	}

}
