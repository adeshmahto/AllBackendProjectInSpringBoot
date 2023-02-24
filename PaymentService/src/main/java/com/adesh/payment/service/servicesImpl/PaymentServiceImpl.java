package com.adesh.payment.service.servicesImpl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adesh.payment.service.entities.Payment;
import com.adesh.payment.service.exceptions.ResourceNotFoundException;
import com.adesh.payment.service.repo.PaymentRepo;
import com.adesh.payment.service.services.PaymentService;


@Service
public class PaymentServiceImpl implements PaymentService {
	
	@Autowired
	private PaymentRepo reservationRepo;

	@Override
	public Payment createReservation(Payment reserv) {
		
//		String ran=UUID.randomUUID().toString();
//		reserv.setId(ran);
		return this.reservationRepo.save(reserv);
	}

	@Override
	public void deleteReservation(Integer reservId) {
		
		Payment  r=this.reservationRepo.findById(reservId).orElseThrow(()->new ResourceNotFoundException());
		
		this.reservationRepo.delete(r);
		
	}

	@Override
	public List<Payment > getAll() {
	
		return this.reservationRepo.findAll();
	}

	@Override
	public Payment  getById(Integer reserId) {
	
		return this.reservationRepo.findById(reserId).orElseThrow(()->new ResourceNotFoundException("Id is not found exception"));
	}

}
