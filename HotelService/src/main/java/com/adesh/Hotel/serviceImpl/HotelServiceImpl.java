package com.adesh.Hotel.serviceImpl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adesh.Hotel.entities.Hotel;
import com.adesh.Hotel.exceptions.ResourceNotFoundException;
import com.adesh.Hotel.repositories.HotelRepository;
import com.adesh.Hotel.services.HotelService;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	private HotelRepository hotelRepository;
	@Override
	public Hotel saveHotel(Hotel hotel) {
     String ranId=UUID.randomUUID().toString();
     hotel.setId(ranId);	
		return this.hotelRepository.save(hotel);
	}

	@Override
	public List<Hotel> getAllHotel() {
		
		return this.hotelRepository.findAll();
	}

	@Override
	public Hotel getHotel(String hotelId) {
		
		return this.hotelRepository.findById(hotelId).orElseThrow(()->new ResourceNotFoundException("hotel id not found!!"));
	}

	
}
