package com.adesh.reservation.service.exception;

public class ResourceNotFoundException extends RuntimeException {
	
	public ResourceNotFoundException() {
		super("resouce not found exceptin");
	}
	public ResourceNotFoundException(String message) {
		super(message);
	}

}
