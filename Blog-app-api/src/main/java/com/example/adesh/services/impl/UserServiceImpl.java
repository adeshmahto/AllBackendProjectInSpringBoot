       package com.example.adesh.services.impl;


import java.util.List;
import java.util.stream.Collectors;

import com.example.adesh.exception.*;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.adesh.entities.User;
import com.example.adesh.payloads.UserDto;
import com.example.adesh.repositories.RoleRepo;
import com.example.adesh.repositories.UserRepo;
import com.example.adesh.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired      //object of the class   //-> we need this userrepo in  terface but we cannot make objects so we just call this from here
	private UserRepo userRepo;
	
    @Autowired                              
	private ModelMapper modelMapper;
    @Autowired 
    private PasswordEncoder passwordEncoder;
    
	@Autowired
	private RoleRepo roleRepo;
    
	@Override
	public UserDto createUser(UserDto userDto) {
		User user = this.dtoUser(userDto);

		User savedUser = this.userRepo.save(user); // will get saved user // userrepo provid many function like sorting
													// also saved data

		return this.userToDto(savedUser);
	}
	
	
// userDto is has the new data of the user
	public UserDto updateUser(UserDto userDto, Integer userId) {

		// if user is not found then throw the exception

		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", " id ", userId));
		// getter and setter
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
		// it will update the user
		User updatedUser = this.userRepo.save(user);
		UserDto userDto1 = this.userToDto(updatedUser);     //change to dto then return
		return userDto1;
	}

	@Override
	public UserDto getUserById(Integer userId) {

		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", " id ", userId));

		return this.userToDto(user);
	}

	public List<UserDto> getAllUsers() {
		
		List<User> users=this.userRepo.findAll();
		//Lambda function
		List<UserDto> userDtos= users.stream().map(user->this.userToDto(user)).collect(Collectors.toList()); // all the user store in the form of list

		return userDtos;
	}

	public void deleteUser(Integer userId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", " id ", userId));
		this.userRepo.delete(user);// delete the user
		
	}

	// it will change UserDto to user entity

	public User dtoUser(UserDto userDto) {
		User user = this.modelMapper.map(userDto, User.class);
//		user.setId(userDto.getId());
//		user.setName(userDto.getName());
//		user.setEmail(userDto.getEmail());
//		user.setAbout(userDto.getAbout());
//		user.setPassword(userDto.getPassword());
		return user;

	}
	// reverse of that method

	public UserDto userToDto(User user) {
		UserDto userDto =this.modelMapper.map(user, UserDto.class);
		
//		userDto.setId(user.getId());
//		userDto.setName(user.getName());
//		userDto.setEmail(user.getEmail());
//		userDto.setAbout(user.getAbout());
//		userDto.setPassword(user.getPassword());
		return userDto;

	}


	@Override
	public UserDto registerNewUser(UserDto userDto) {
	User user=this.modelMapper.map(userDto, User.class);
	user.setPassword(this.passwordEncoder.encode(user.getPassword()));
	
	//roles
	

	
	
		
		return null;
	}

}
