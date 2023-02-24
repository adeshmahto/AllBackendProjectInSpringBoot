package com.example.adesh.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.adesh.entities.User;

//jparepository provide many functionalty like sorting and paging and save data

public interface UserRepo extends JpaRepository<User,Integer> {
	
	Optional<User> findByEmail(String email);
	

}
