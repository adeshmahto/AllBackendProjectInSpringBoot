package com.adesh.courseapp.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.adesh.courseapp.Dto.OrderDto;
import com.adesh.courseapp.dao.OrderDao;
import com.adesh.courseapp.dao.ProductDao;
import com.adesh.courseapp.dao.UserDao;
import com.adesh.courseapp.entities.Order;
import com.adesh.courseapp.entities.Product;
import com.adesh.courseapp.entities.User;
import com.adesh.courseapp.exception.ResourceNotFoundException;
import com.adesh.courseapp.services.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	@Override
	public OrderDto createOrder(OrderDto orderDto, Integer userId, Integer productId) {
		User user=this.userDao.findById(userId).orElseThrow(()->new ResourceNotFoundException("user","id",userId));
		Product pro=this.productDao.findById(productId).orElseThrow(()->new ResourceNotFoundException("product","id",userId));
		
		Order order=this.modelMapper.map(orderDto,Order.class);
		
		order.setProduct(pro);
		
		order.setUser(user);
		
		return this.modelMapper.map(this.orderDao.save(order), OrderDto.class);
	}

	@Override
	public OrderDto updateOrder(OrderDto orderDto, Integer orderId) {
		Order order=this.orderDao.findById(orderId).orElseThrow(()->new ResourceNotFoundException("order","id",orderId));
		order.setCodeName(orderDto.getCodeName());
	    return this.modelMapper.map(this.orderDao.save(order), OrderDto.class);
		
  
	}

	@Override
	public OrderDto getByOrder(Integer orderId) {
		Order order=this.orderDao.findById(orderId).orElseThrow(()->new ResourceNotFoundException("order","id",orderId));
		return this.modelMapper.map(this.orderDao.save(order), OrderDto.class);
	}

	@Override
	public List<OrderDto> getAllOrder() {
		List<Order> orders=this.orderDao.findAll();
		List<OrderDto> ordersdto=orders.stream().map((order)->this.modelMapper.map(order, OrderDto.class)).collect(Collectors.toList());
		return ordersdto;
	}

	@Override
	public void deleteOrder(Integer orderId) {
		Order order=this.orderDao.findById(orderId).orElseThrow(()->new ResourceNotFoundException("order","id",orderId));
		this.orderDao.delete(order);
		
	}

	@Override
	public List<OrderDto> getOrderByUser(Integer userId) {
	User user=this.userDao.findById(userId).orElseThrow(()->new ResourceNotFoundException("order","id",userId));
		
		List<Order> order=this.orderDao.findByUser(user);
		
		List<OrderDto> orderDto=order.stream().map((or)->this.modelMapper.map(or, OrderDto.class)).collect(Collectors.toList());
		
		
		return orderDto;
	}

	@Override
	public List<OrderDto> getOrderByProduct(Integer productId) {
		
		Product pro=this.productDao.findById(productId).orElseThrow(()->new ResourceNotFoundException("product","id",productId));
		
		List<Order> order=this.orderDao.findByProduct(pro);
		
		List<OrderDto> orderDto=order.stream().map((or)->this.modelMapper.map(or, OrderDto.class)).collect(Collectors.toList());
		
		
		return orderDto;
	}

}
