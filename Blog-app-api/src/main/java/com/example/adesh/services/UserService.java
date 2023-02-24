package com.example.adesh.services;

import java.util.List;

import com.example.adesh.payloads.UserDto;

public interface UserService {   
	
	UserDto registerNewUser(UserDto user);
	
	UserDto createUser(UserDto user);// return will be UserDto
	
	UserDto updateUser(UserDto user,Integer userId);
	
	UserDto getUserById(Integer userId);
	
	List<UserDto> getAllUsers();
	
	void deleteUser(Integer userId);
		
	

}
