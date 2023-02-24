package com.adesh.courseapp.services;

import java.util.List;

import com.adesh.courseapp.entities.Contact;

public interface ContactService {
	
	List<Contact> getAllContact();
	
	public Contact createContact(Contact contact);
	
	void deleteContact(Integer ContactId);
	
	

}
