package com.adesh.coding30min.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adesh.coding30min.entities.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
