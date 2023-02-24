package com.adesh.courseapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adesh.courseapp.entities.Contact;

public interface ContactDao extends JpaRepository<Contact, Integer> {

}
