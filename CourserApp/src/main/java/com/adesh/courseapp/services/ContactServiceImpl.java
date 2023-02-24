package com.adesh.courseapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adesh.courseapp.dao.ContactDao;
import com.adesh.courseapp.entities.Contact;
import com.adesh.courseapp.exception.ResourceNotFoundException;

@Service
public class ContactServiceImpl implements ContactService{
	
	
	@Autowired
	private ContactDao contactDao;

	@Override
	public List<Contact> getAllContact() {
		
		return this.contactDao.findAll();
	}

	@Override
	public Contact createContact(Contact contact) {
		
		return this.contactDao.save(contact);
	}

	@Override
	public void deleteContact(Integer ContactId) {
	    
	Contact contact=this.contactDao.findById(ContactId).orElseThrow(()->new ResourceNotFoundException("contact","Id",ContactId));
		
	}

}
