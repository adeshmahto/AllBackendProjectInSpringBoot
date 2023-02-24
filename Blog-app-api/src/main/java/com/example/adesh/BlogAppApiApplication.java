package com.example.adesh;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication //-> this annotation giving the facility of configuration
public class BlogAppApiApplication implements CommandLineRunner {
	
	@Autowired 
	private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
	SpringApplication.run(BlogAppApiApplication.class, args);
	}
	
	@Bean // this bean use to create object where we use through this Autowired
	public ModelMapper modelMapper() {
		
		return new ModelMapper();
		
		
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(this.passwordEncoder.encode("att"));// it will give encodedpassword which has to be stored in database to access the other data
		
	}

}
