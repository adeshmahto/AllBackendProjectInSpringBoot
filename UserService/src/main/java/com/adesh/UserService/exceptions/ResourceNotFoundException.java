package com.adesh.UserService.exceptions;

public class ResourceNotFoundException extends RuntimeException{
	
	public  ResourceNotFoundException() {
		super("Resource not found on server!!");
	}
	public  ResourceNotFoundException(String messages) {
		super(messages);
	}

}
