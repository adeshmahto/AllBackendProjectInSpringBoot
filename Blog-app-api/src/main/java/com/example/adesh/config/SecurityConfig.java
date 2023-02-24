package com.example.adesh.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.adesh.securtiy.CustomUserDetailService;
import com.example.adesh.securtiy.JwtAuthenticationEntryPoint;
import com.example.adesh.securtiy.JwtAuthenticationFilter;

         
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
	private CustomUserDetailService customUserDetailService;
    
    @Autowired
    private JwtAuthenticationEntryPoint jwtAuthenticationEnryPoint;
    
    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;
	
	@Override
	//javascript pass and username taking coming
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable().authorizeHttpRequests().antMatchers("/api/v1/auth/login").permitAll()
		.antMatchers(HttpMethod.GET).permitAll()
		.anyRequest()
        .authenticated().and()
		.exceptionHandling().authenticationEntryPoint(this.jwtAuthenticationEnryPoint)
		.and()
		.sessionManagement()
		
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		http.addFilterBefore(this.jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(this.customUserDetailService).passwordEncoder(passwordEncoder());
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		
		return new BCryptPasswordEncoder();
		
	}
     
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManagerBean();
	}
	
	
	
	
	

}
