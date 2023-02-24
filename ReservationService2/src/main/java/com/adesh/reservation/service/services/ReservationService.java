package com.adesh.reservation.service.services;

import java.util.List;

import com.adesh.reservation.service.entities.Reservation;

public interface ReservationService {
	
	//create reservation
	Reservation createReservation(Reservation reserv);
	//delete
	void deleteReservation(Integer reservId);
	//get all reservation
	List<Reservation> getAll();
	//get  by id
	Reservation getById(Integer reserId);

}
