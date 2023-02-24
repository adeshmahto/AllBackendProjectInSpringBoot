package com.adesh.UserService.services;

import java.util.List;

import com.adesh.UserService.entities.User;

public interface UserService  {
	
	//create
	User saveUser(User user);
	//get all
	
	List<User>getAllUser();
	
	//get single user of given userId
	
	User getUser(String userId);
	
	
	
	
	

}
