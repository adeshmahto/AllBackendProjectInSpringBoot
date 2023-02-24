package com.adesh.reservation.service.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adesh.reservation.service.entities.Reservation;
import com.adesh.reservation.service.services.ReservationService;

@RestController
@RequestMapping("/reserves")
public class ReservationController {
	
	@Autowired
	private ReservationService reservationService;
	
	@PostMapping
	public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reserv){	
		return new ResponseEntity<Reservation>(this.reservationService.createReservation(reserv),HttpStatus.CREATED);
		
	}
	@GetMapping("{reservId}")
	public ResponseEntity<Reservation>getById(@PathVariable Integer reservId){
		
		return new ResponseEntity<Reservation>(this.reservationService.getById(reservId),HttpStatus.OK);
		
	}
	@DeleteMapping("{reservId}")
	public void DeleteReservation(@PathVariable Integer reservId) {
		this.reservationService.deleteReservation(reservId);
	}
	@GetMapping
	public ResponseEntity<List<Reservation>>getAll(){
		return new ResponseEntity<List<Reservation>>(this.reservationService.getAll(),HttpStatus.OK);
	}
	
	//create reservation with hotel name 

}
