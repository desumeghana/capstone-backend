package com.chubb.capstone.database;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.chubb.capstone.model.Order;

public interface OrderRepository extends MongoRepository<Order, String>{

	List<Order> findByUserId(String userId);

}
