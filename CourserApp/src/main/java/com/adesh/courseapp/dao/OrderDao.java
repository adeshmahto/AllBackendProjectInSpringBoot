package com.adesh.courseapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adesh.courseapp.entities.Order;
import com.adesh.courseapp.entities.Product;
import com.adesh.courseapp.entities.User;

public interface OrderDao extends JpaRepository<Order, Integer> {
	
	//custom method 
	List<Order> findByUser(User user);
	List<Order> findByProduct(Product product);

}
