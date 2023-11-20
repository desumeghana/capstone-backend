package com.chubb.capstone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chubb.capstone.model.Order;
import com.chubb.capstone.service.OrderService;

@CrossOrigin("*")
@RestController
@RequestMapping("/orders")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@GetMapping("")
	public List<Order> getAllOrders(){
		return orderService.getAllOrders();
	}
	
	@GetMapping("/{userId}")
	public List<Order> getOrderByUserId(@PathVariable String userId) {
		return orderService.getOrderByUserId(userId);
	}
	
	@GetMapping("/order/{orderId}")
	public Order getOrderById(@PathVariable String orderId) {
		return orderService.getOrderById(orderId);
	}
	
	@PostMapping("/create")
	public Order addOrder(@RequestBody Order order) {
		return orderService.addOrder(order);
	}
	
	@PutMapping("/update")
	public Order updateOrder(@RequestBody Order order) {
		return orderService.updateOrder(order);
	}
	
	
}
