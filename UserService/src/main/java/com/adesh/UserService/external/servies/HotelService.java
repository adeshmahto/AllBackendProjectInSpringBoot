package com.adesh.UserService.external.servies;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.adesh.UserService.entities.Hotel;

@FeignClient(name="HOTEL-SERVICE")
public interface HotelService {
	
	
	//declarative approach
	@GetMapping("/hotels/{hotelId}")
	Hotel getHotel(@PathVariable("hotelId")  String hotelId);
 
}
