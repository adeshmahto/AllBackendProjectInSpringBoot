package com.adesh.UserService.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.adesh.UserService.payload.ApiResponse;

@RestControllerAdvice
// it is act as centralise exception which handle all exception in this service
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)//whenever RNFE exception come this exception will work
	public ResponseEntity<ApiResponse>handleResourceNotFoundException(ResourceNotFoundException ex){
		
		String message=ex.getMessage();
	ApiResponse response=ApiResponse.builder().message(message).success(true).status(HttpStatus.NOT_FOUND).build();
		//builder is used to create a object in one line
		
		return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
	}

}
