package com.chubb.capstone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.chubb.capstone.database.OrderRepository;
import com.chubb.capstone.model.Order;

@Service
public class OrderService {
	@Autowired
	OrderRepository orderRepository;
	public List<Order> getAllOrders() {
		return orderRepository.findAll();
	}
	
	public Order getOrderById(String OrderId) {
		return orderRepository.findById(OrderId).get();
	}
	
	public List<Order> getOrderByUserId(String userId){
		return orderRepository.findByUserId(userId);
	}
	
	public Order addOrder(Order order) {
		return orderRepository.save(order);
	}
	
	//update data
	public Order updateOrder(Order order) {
		Order curr=orderRepository.findById(order.getOrderId()).get();
		curr.setUserId(order.getUserId());
		curr.setProducts(order.getProducts());
		curr.setPrice(order.getPrice());
		curr.setAddress(order.getAddress());
		curr.setMobileNo(order.getMobileNo());
		curr.setOrderStatus(order.getOrderStatus());
		return orderRepository.save(curr);
	}

}
