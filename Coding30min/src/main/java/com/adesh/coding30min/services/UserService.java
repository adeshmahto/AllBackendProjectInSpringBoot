package com.adesh.coding30min.services;

import java.util.List;

import com.adesh.coding30min.Dto.UserDto;

public interface UserService {
	 
	UserDto createUser(UserDto user);
	
	UserDto updateUser(UserDto user,Integer userId);
	
	void deleteUser(Integer userId);
	
	UserDto getUserById(Integer userId);
	
	List<UserDto> getAllUsers();
	

}
