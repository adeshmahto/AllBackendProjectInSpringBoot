package com.adesh.reservation.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;

import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;




@SpringBootApplication
@EnableDiscoveryClient
public class ReservationService2Application {
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
		
	}

	public static void main(String[] args) throws RestClientException {
		SpringApplication.run(ReservationService2Application.class, args);
		
		
	
	}

}
