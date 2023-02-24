package com.adesh.courseapp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.adesh.courseapp.dao.UserDao;
import com.adesh.courseapp.entities.User;
import com.adesh.courseapp.exception.ResourceNotFoundException;

@Service
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	private UserDao userRepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	// loading user from database by username
		
			User user=this.userRepo.findByEmail(username).orElseThrow(()->new ResourceNotFoundException("User", "email :"+username, 0));
	
			return user;
			
	}
	
	

}
