package com.adesh.payment.service.controller;

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

import com.adesh.payment.service.entities.Payment;
import com.adesh.payment.service.services.PaymentService;


@RestController
@RequestMapping("/payments")
public class PaymentController {
	
	@Autowired
	private PaymentService reservationService;
	
	@PostMapping
	public ResponseEntity<Payment> createReservation(@RequestBody Payment reserv){	
		return new ResponseEntity<Payment>(this.reservationService.createReservation(reserv),HttpStatus.CREATED);
		
	}
	@GetMapping("{paymentId}")
	public ResponseEntity<Payment>getById(@PathVariable Integer paymentId){
		
		return new ResponseEntity<Payment>(this.reservationService.getById(paymentId),HttpStatus.OK);
		
	}
	@DeleteMapping("{paymentId}")
	public void DeleteReservation(@PathVariable Integer paymentId) {
		this.reservationService.deleteReservation(paymentId);
	}
	@GetMapping
	public ResponseEntity<List<Payment>>getAll(){
		return new ResponseEntity<List<Payment>>(this.reservationService.getAll(),HttpStatus.OK);
	}
	
	//create reservation with hotel name 


}
