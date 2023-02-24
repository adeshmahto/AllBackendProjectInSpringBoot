package com.adesh.courseapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adesh.courseapp.entities.Product;

public interface ProductDao extends JpaRepository<Product, Integer>{
	
	

}
