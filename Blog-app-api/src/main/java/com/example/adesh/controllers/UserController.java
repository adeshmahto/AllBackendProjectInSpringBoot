package com.example.adesh.controllers;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.adesh.payloads.ApiResponse;
import com.example.adesh.payloads.UserDto;

import com.example.adesh.services.UserService;

// User-Api->
@RestController
@RequestMapping("/api/users")
public class UserController {
	@Autowired
	 private UserService userService;
	
	
	//post-Create user
	@PostMapping("/")// when u call '/' this method will be executed
	
	public ResponseEntity <UserDto> createUser(@Valid @RequestBody UserDto userDto){
		
		//we calling our method which is implemented "createUser methode"
		
	UserDto createUserDto =	this.userService.createUser(userDto);
		return new ResponseEntity<>(createUserDto,HttpStatus.CREATED);
		
	}
	
	//put-update user
	@PutMapping("/{userId}") // this is responsible for the updation
	
	//when u want to return anything then use ResponseEntity otherwise void
	
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto,@PathVariable("userId") Integer uid){
		UserDto updateUserDto=this.userService.updateUser(userDto,uid);
		return ResponseEntity.ok(updateUserDto);          //ok will give the status that it is working fine
	}
	
	//Delete user
	@PreAuthorize("hasRole('ADMIN')")   // ONLY ADMIN CAN DELETE IT
	@DeleteMapping("/{userId}") 
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") Integer uid){
		this.userService.deleteUser(uid);
		return new ResponseEntity<ApiResponse>(new ApiResponse("User deleted Successfully",true),HttpStatus.OK);
		
	}
	
	//Get-user get
	@GetMapping("/")     //only '/' can call it this methode
	public ResponseEntity<List<UserDto>> getAllUser(){
		return ResponseEntity.ok(this.userService.getAllUsers());
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getSingleUser(@PathVariable Integer userId){
		return ResponseEntity.ok(this.userService.getUserById(userId));
	}
	
	
	
	
	

}
;