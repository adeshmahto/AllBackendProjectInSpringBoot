package com.example.adesh.securtiy;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
	@Autowired
	private UserDetailsService userDetailservice;
	
	@Autowired
	private JwtTokenHelper jwtTokenHelper;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		//1.get token
		String requestToken=request.getHeader("Authorization");
		
	//request token-> like this->	//Bearer 23525233dfd   // actual token is from 7index 235..
		
		String username=null;
		String token=null;
		
		if(requestToken!=null && requestToken.startsWith("Bearer")) {
			token=requestToken.substring(7);
			
			try {
				username=this.jwtTokenHelper.getUsernameFromToken(token);
			}catch(IllegalArgumentException e) {
			     System.out.println("unable to get jwt token");
			}catch(ExpiredJwtException e) {
				System.out.println("Jwr token has expired");
			}catch(MalformedJwtException e) {
				System.out.println("invalid jwt");
			}
			
		}else {
			System.out.println("jwt token does not begin with Bearer");
		}
		//once we get the token , now validate
		
		if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null) {
			UserDetails userDetails=this.userDetailservice.loadUserByUsername(username);
			if(this.jwtTokenHelper.validateToken(token, userDetails)) {
				//all fine
				//now start authentication
				
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=
					new UsernamePasswordAuthenticationToken( userDetails,null,userDetails.getAuthorities());
				usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				
				SecurityContextHolder.getContext().setAuthentication(null);
			
				
			}else {
				System.out.println("invalid jwt token");
			}
		}else {
			System.out.println("username is null or context is not null");
		}
		
		
	 
		
	}
	
	

}
