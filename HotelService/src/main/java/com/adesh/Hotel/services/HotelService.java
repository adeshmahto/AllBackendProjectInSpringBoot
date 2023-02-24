package com.adesh.Hotel.services;

import java.util.List;

import com.adesh.Hotel.entities.Hotel;

public interface HotelService {
	
	Hotel saveHotel(Hotel hotel);
	
	List<Hotel> getAllHotel();
	
	Hotel getHotel(String hotelId);

}
