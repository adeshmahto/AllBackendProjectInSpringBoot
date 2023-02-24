package com.adesh.courseapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.adesh.courseapp.entities.Contact;
import com.adesh.courseapp.services.ContactService;

@RestController
public class ContactController {
	
	@Autowired
	private ContactService contactService;
	@PostMapping("/contact")
	ResponseEntity<Contact> creatContact(@RequestBody Contact contact){
		
		return new ResponseEntity<Contact>(this.contactService.createContact(contact),HttpStatus.CREATED);
		
	}
	@GetMapping("/contacts")
	ResponseEntity<List<Contact>> getAllContact(){
		
	return new ResponseEntity<List<Contact>> (this.contactService.getAllContact(),HttpStatus.OK);
		
		
	}
	@DeleteMapping("/contact/{contactId}")
	ResponseEntity<HttpStatus> deleteContact(@PathVariable Integer contactId){
		
		try {
			this.contactService.deleteContact(contactId);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

}
