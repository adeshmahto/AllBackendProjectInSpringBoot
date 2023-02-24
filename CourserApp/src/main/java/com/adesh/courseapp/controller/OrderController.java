package com.adesh.courseapp.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.adesh.courseapp.Dto.OrderDto;
import com.adesh.courseapp.services.OrderService;

@RestController
public class OrderController {
	
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping("/order/{userId}/{productId}")
	ResponseEntity<OrderDto> createOrder(@RequestBody OrderDto orderDto,@PathVariable Integer userId,@PathVariable Integer productId){	
		return new ResponseEntity<OrderDto>(this.orderService.createOrder(orderDto, userId, productId),HttpStatus.CREATED);
		
	}
	
	@PutMapping("/order/{orderId}")
	ResponseEntity<OrderDto> updateOrder(@RequestBody OrderDto orderDto,@PathVariable Integer orderId){	
		return new ResponseEntity<OrderDto>(this.orderService.updateOrder(orderDto, orderId),HttpStatus.OK);
		
	}
	
	@GetMapping("/order/{orderId}")
	ResponseEntity<OrderDto> getById(@PathVariable Integer orderId){
		
		return new ResponseEntity<OrderDto>(this.orderService.getByOrder(orderId),HttpStatus.OK);
		
	}
	
	@GetMapping("/orders")
	
	ResponseEntity<List<OrderDto>> getAllOrder(){
		
		return new ResponseEntity<List<OrderDto>>(this.orderService.getAllOrder(),HttpStatus.OK);
		
		
	}
	
	@DeleteMapping("/order/{orderId}")
	
	ResponseEntity<HttpStatus> deleteOrder(@PathVariable Integer orderId){
	try {
		 this.orderService.deleteOrder(orderId);
		 return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}catch(Exception e) {
		return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	}
	
	@GetMapping("/orders/user/{userId}")
	
	ResponseEntity<List<OrderDto>> getByUser(@PathVariable Integer userId ){
		return new ResponseEntity<List<OrderDto>>(this.orderService.getOrderByUser(userId),HttpStatus.OK);	
	}
	
	@GetMapping("/orders/product/{productId}")
	
	ResponseEntity<List<OrderDto>> getByProduct(@PathVariable Integer productId ){
		return new ResponseEntity<List<OrderDto>>(this.orderService.getOrderByProduct(productId),HttpStatus.OK);	
	}
	
	
	
	
	
	

}
