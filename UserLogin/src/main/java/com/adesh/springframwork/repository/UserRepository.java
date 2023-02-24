package com.adesh.springframwork.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adesh.springframwork.entity.User;

public interface UserRepository extends JpaRepository<User,Integer>{
	

}
