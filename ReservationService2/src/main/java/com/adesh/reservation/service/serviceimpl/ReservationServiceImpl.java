package com.adesh.reservation.service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adesh.reservation.service.entities.Reservation;
import com.adesh.reservation.service.exception.ResourceNotFoundException;
import com.adesh.reservation.service.repo.ReservationRepo;
import com.adesh.reservation.service.services.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService {
	
	@Autowired
	private ReservationRepo reservationRepo;

	@Override
	public Reservation createReservation(Reservation reserv) {
		
		return this.reservationRepo.save(reserv);
	}

	@Override
	public void deleteReservation(Integer reservId) {
		
		Reservation r=this.reservationRepo.findById(reservId).orElseThrow(()->new ResourceNotFoundException());
		
		this.reservationRepo.delete(r);
		
	}

	@Override
	public List<Reservation> getAll() {
	
		return this.reservationRepo.findAll();
	}

	@Override
	public Reservation getById(Integer reserId) {
	
		return this.reservationRepo.findById(reserId).orElseThrow(()->new ResourceNotFoundException("Id is not found exception"));
	}

}
