package com.adesh.coding30min.servicesimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adesh.coding30min.Dto.UserDto;
import com.adesh.coding30min.entities.User;
import com.adesh.coding30min.exception.ResourceNotFoundException;
import com.adesh.coding30min.repositories.UserRepo;
import com.adesh.coding30min.services.UserService;
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDto createUser(UserDto userDto) {
		
		User user=this.modelMapper.map(userDto, User.class);
		
	  return this.modelMapper.map(this.userRepo.save(user), UserDto.class);

		
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		User user=this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","Id", userId));
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setEmail(userDto.getPassword());
		return this.modelMapper.map(this.userRepo.save(user), UserDto.class);
	}

	@Override
	public void deleteUser(Integer userId) {
		User user=this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","Id", userId));
		this.userRepo.delete(user);
	}

	@Override
	public UserDto getUserById(Integer userId) {
		User user=this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","Id", userId));
		return this.modelMapper.map(user, UserDto.class);
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User> users=this.userRepo.findAll();
		List<UserDto> Alluser=users.stream().map(entity->this.modelMapper.map(entity, UserDto.class)).collect(Collectors.toList() );
		return Alluser;
	}

}
