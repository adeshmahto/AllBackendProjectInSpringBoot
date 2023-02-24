package com.adesh.courseapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.adesh.courseapp.Dto.UserDto;
import com.adesh.courseapp.services.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//create user
	
	@PostMapping("/user/")
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){		
		return new ResponseEntity<UserDto>(this.userService.createUser(userDto),HttpStatus.CREATED);
	}
	
	//update the user
	@PutMapping("/user/{userId}")
	public ResponseEntity<UserDto> updateUser(@PathVariable Integer userId,@RequestBody UserDto userDto){
		return new ResponseEntity<UserDto>(this.userService.updateUser(userId, userDto),HttpStatus.OK);
		
	}
	//get user by id
	@GetMapping("/user/{userId}")	
	public ResponseEntity<UserDto> getUserById(@PathVariable Integer userId){
		
		return new ResponseEntity<UserDto>(this.userService.getUserById(userId),HttpStatus.OK);
	
	}
	@GetMapping("/users")
	public ResponseEntity<List<UserDto>> getAllUser(){
		return new ResponseEntity<List<UserDto>>(this.userService.getAllUser(),HttpStatus.OK);
	}
	
	@DeleteMapping("/user/{userId}")
	public ResponseEntity<HttpStatus> DeleteUser(@PathVariable Integer userId){
		
		try {
			this.userService.deleteUser(userId);
		return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
	}

}
