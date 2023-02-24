package com.adesh.Hotel.controller;

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

import com.adesh.Hotel.entities.Hotel;
import com.adesh.Hotel.services.HotelService;

@RestController
@RequestMapping("/hotels")
public class HotelController {
	
	@Autowired
	private HotelService hotelService;
	
	@PostMapping
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
		Hotel hot=this.hotelService.saveHotel(hotel);
      return new ResponseEntity<Hotel>(hot, HttpStatus.CREATED);
		
	}
	@GetMapping("/{hotelId}")
	public ResponseEntity<Hotel>getById(@PathVariable String hotelId){
		Hotel hot =this.hotelService.getHotel(hotelId);
		return new ResponseEntity<Hotel>(hot,HttpStatus.OK);
	}
	@GetMapping
	public ResponseEntity<List<Hotel>> getAll(){
		
		List<Hotel>list=this.hotelService.getAllHotel();
		
		return ResponseEntity.ok(list);
		
	}

}
