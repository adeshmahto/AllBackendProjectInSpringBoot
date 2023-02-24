package com.adesh.coding30min;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class Coding30minApplication {

	public static void main(String[] args) {
		SpringApplication.run(Coding30minApplication.class, args);
	}
	
	@Bean
	public ModelMapper modelmapper() {
		
		return new ModelMapper();
		
	}
 

}
