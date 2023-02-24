package com.adesh.Hotel.exceptions;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
// it is act as centralise exception which handle all exception in this service
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)//whenever RNFE exception come this exception will work
	public ResponseEntity<Map<String,Object>>handleResourceNotFoundException(ResourceNotFoundException ex){
		
	 Map<String,Object> map=new HashMap<>();
	 map.put("message", ex.getMessage());
	 map.put("succes", false);
	 map.put("status", HttpStatus.NOT_FOUND);
	 return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
		
		

	}

}
