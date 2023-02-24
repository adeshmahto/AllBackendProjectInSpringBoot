package com.adesh.payment.service.exceptions;


public class ResourceNotFoundException extends RuntimeException {
	
	public ResourceNotFoundException() {
		super("resouce not found exceptin");
	}
	public ResourceNotFoundException(String message) {
		super(message);
	}

}