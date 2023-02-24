package com.adesh.courseapp.services;

import java.util.List;

import com.adesh.courseapp.Dto.OrderDto;

public interface OrderService {
	
	
	OrderDto createOrder(OrderDto orderDto,Integer userId,Integer productId);
	
	OrderDto updateOrder(OrderDto orderDto,Integer orderId);
	
	OrderDto getByOrder(Integer orderId);
	
	List<OrderDto> getAllOrder();
	
	void deleteOrder(Integer orderId);
	
	//get all order by user
	
	List<OrderDto> getOrderByUser(Integer userId);
	
	//get all order by product
	
	List<OrderDto> getOrderByProduct(Integer productId);

}
