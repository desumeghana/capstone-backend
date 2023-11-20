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

import com.chubb.capstone.model.Product;
import com.chubb.capstone.model.User;
import com.chubb.capstone.model.UserCredentials;
import com.chubb.capstone.service.UserService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	UserService userService;
	
	@GetMapping("")
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@GetMapping("/{userId}")
	public User getUserById(@PathVariable String userId) {
		return userService.getUserById(userId);
	}
	
	@PostMapping("/create")
	public User addUser(@RequestBody User user) {
		return userService.addUser(user);
	}
	
	@PostMapping("/login")
	public String login(@RequestBody UserCredentials credentials) {
	   return userService.login(credentials);
	}
	
	@PutMapping("/update")
	public User updateUser(@RequestBody User user) {
		return userService.updateUser(user);
	}
}
