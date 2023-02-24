package com.adesh.payment.service.services;

import java.util.List;

import com.adesh.payment.service.entities.Payment;


public interface PaymentService {
	//create reservation
		Payment createReservation(Payment reserv);
		//delete
		void deleteReservation(Integer reservId);
		//get all reservation
		List<Payment> getAll();
		//get  by id
		Payment getById(Integer reserId);

}
