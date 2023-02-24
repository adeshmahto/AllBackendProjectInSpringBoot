package com.adesh.courseapp.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adesh.courseapp.entities.User;

public interface UserDao extends JpaRepository<User, Integer>{
	
	Optional<User> findByEmail(String email);

}
