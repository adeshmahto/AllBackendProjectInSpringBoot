package com.adesh.UserService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adesh.UserService.entities.User;

public interface UserRepository extends JpaRepository<User, String> {

}
