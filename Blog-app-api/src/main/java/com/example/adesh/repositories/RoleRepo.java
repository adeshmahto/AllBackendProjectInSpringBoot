package com.example.adesh.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.adesh.entities.Role;

public interface RoleRepo extends JpaRepository<Role,Integer> {
	
	

}
