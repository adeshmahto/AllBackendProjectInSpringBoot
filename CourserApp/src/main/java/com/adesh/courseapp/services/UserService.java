package com.adesh.courseapp.services;

import java.util.List;

import com.adesh.courseapp.Dto.UserDto;

public interface UserService {
	
	UserDto createUser(UserDto userDto);
	
	UserDto updateUser( Integer userId,UserDto userDto);
	
	List<UserDto> getAllUser();
	
	UserDto getUserById(Integer userId);
	
	void deleteUser(Integer userId);
	
	
}
