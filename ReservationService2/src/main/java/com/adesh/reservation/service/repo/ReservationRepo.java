package com.adesh.reservation.service.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adesh.reservation.service.entities.Reservation;

public interface ReservationRepo extends JpaRepository<Reservation, Integer> {

}
