package com.adesh.courseapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.adesh.courseapp.security.CustomUserDetailService;
import com.adesh.courseapp.security.JwtAuthenticationEntryPoint;
import com.adesh.courseapp.security.JwtAuthenticationFilter;


@Configuration
@EnableWebSecurity
// @SuppressWarnings("deprecation")
public class SecurityConfig {
	
	@Autowired
	private CustomUserDetailService customUserDetailService;
	
	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
	
	@Autowired
	private JwtAuthenticationFilter jwtAuthenticationFilter;

	/*
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	
		// after this we will get javascripte form prompt
		// now you can use postman to authenticate
		
		http.
		csrf().disable()
		.authorizeHttpRequests()
		.antMatchers("api/v1/auth/login").permitAll()
		.anyRequest()
		.authenticated()                                                                                                                    	
		.and()
		.exceptionHandling().authenticationEntryPoint(this.jwtAuthenticationEntryPoint)
		.and()
		.sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		
		http.addFilterBefore(this.jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
		
		
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
          auth.userDetailsService(this.customUserDetailService).passwordEncoder(passwordEncoder());
	}
	*/
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
		.csrf()
		.disable()
		.authorizeHttpRequests((authz) -> authz
				.anyRequest()
				.authenticated()
				.and())
		.httpBasic(withDefaults());
		return http.build();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	/*
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
	
		return super.authenticationManagerBean();
	}
	*/
}
