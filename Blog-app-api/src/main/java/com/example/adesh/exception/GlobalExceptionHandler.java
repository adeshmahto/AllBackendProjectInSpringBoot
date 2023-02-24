package com.example.adesh.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.validation.*;

import com.example.adesh.payloads.ApiResponse;


import org.springframework.*;

@ResponseBody
@RestControllerAdvice // it will check the all the exception in controller
public class GlobalExceptionHandler {
	@ExceptionHandler(ResourceNotFoundException.class) //custom exception// whenever this resource come below method will run
	public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(ResourceNotFoundException ex){
		String message=ex.getMessage();
		ApiResponse apiResponse=new ApiResponse(message,false);
		
		return new ResponseEntity<>(apiResponse,HttpStatus.NOT_FOUND);
		
	}
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String,String>> handleMethodArgsNotValidException(MethodArgumentNotValidException ex){
		//map store the error messages of each field
		Map<String,String> resp=new HashMap<>();
		//foreachloop iterate the each error one by one
		ex.getBindingResult().getAllErrors().forEach((error)->{
			String fieldName=((FieldError)error).getField();
			String message=error.getDefaultMessage();
			resp.put(fieldName, message);
			
		});
		return new ResponseEntity<Map<String, String>>(resp,HttpStatus.BAD_REQUEST);
		
	}
	@ExceptionHandler(ApiException.class) //custom exception// whenever this resource come below method will run
	public ResponseEntity<ApiResponse> handleApiException(ApiException ex){
		String message=ex.getMessage();
		ApiResponse apiResponse=new ApiResponse(message,false);
		
		return new ResponseEntity<>(apiResponse,HttpStatus.NOT_FOUND);
		
	}

}
