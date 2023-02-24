package com.adesh.Hotel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adesh.Hotel.entities.Hotel;

public interface HotelRepository extends JpaRepository<Hotel,String>{

}
