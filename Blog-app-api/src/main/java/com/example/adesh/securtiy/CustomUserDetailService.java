package com.example.adesh.securtiy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.adesh.entities.User;
import com.example.adesh.exception.ResourceNotFoundException;
import com.example.adesh.repositories.UserRepo;

@Service
public class CustomUserDetailService implements UserDetailsService {
     
	@Autowired
	private UserRepo userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//loading user from database by username
		
		User user=this.userRepo.findByEmail(username).orElseThrow(()->new ResourceNotFoundException("User","username",0));
		return user;
	}

	
}
