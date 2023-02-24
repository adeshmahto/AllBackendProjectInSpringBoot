package com.adesh.courseapp.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adesh.courseapp.Dto.UserDto;
import com.adesh.courseapp.dao.UserDao;
import com.adesh.courseapp.entities.User;
import com.adesh.courseapp.exception.ResourceNotFoundException;
import com.adesh.courseapp.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private ModelMapper modelMapper;
	
	

	@Override
	public UserDto createUser(UserDto userDto) {
		
		User user=this.modelMapper.map(userDto, User.class);
		
		 User entity=this.userDao.save(user);
		
		return this.modelMapper.map(entity, UserDto.class);
	}

	@Override
	public UserDto updateUser(Integer userId, UserDto userDto) {
	  User user=this.userDao.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","Id",userId));
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		User entity=this.userDao.save(user);
		return this.modelMapper.map(entity, UserDto.class);
		
	}

	@Override
	public List<UserDto> getAllUser() {
		List<User> users=this.userDao.findAll();
		List<UserDto> userDto=users.stream().map(entity->this.modelMapper.map(entity, UserDto.class)).collect(Collectors.toList());
		
		return userDto;
	}

	@Override
	public UserDto getUserById(Integer userId) {
		
		User user=this.userDao.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","id",userId));
		
		
		return this.modelMapper.map(user, UserDto.class);
	}

	@Override
	public void deleteUser(Integer userId) {
		User user=this.userDao.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","id",userId));
		
		this.userDao.delete(user);
	}

	
	
}
