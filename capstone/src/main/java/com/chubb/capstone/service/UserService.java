package com.chubb.capstone.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.chubb.capstone.database.UserRepository;
import com.chubb.capstone.model.User;
import com.chubb.capstone.model.UserCredentials;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	// create data
	public User addUser(User user) {
		return userRepository.save(user);
	}
	
	//get users data
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	public User getUserById(String UserId) {
		return userRepository.findById(UserId).get();
	}
	
	public User updateUser(User user) {
		User curr=userRepository.findById(user.getUserId()).get();
		curr.setUserName(user.getUserName());
		curr.setPassword(user.getPassword());
		curr.setEmail(user.getEmail());
		curr.setMobileNo(user.getMobileNo());
		curr.setAddress(user.getAddress());
		curr.setCart(user.getCart());
		curr.setWishlist(user.getWishlist());
		return userRepository.save(curr);
	}
	
	public String login(UserCredentials credentials) {
	   	Optional<User> optionalUser = userRepository.findByEmail(credentials.getEmail());
	    if (optionalUser.isPresent() && optionalUser.get().getPassword().equals(credentials.getPassword())) {
	        return optionalUser.get().getUserId();
	    }
	    else {
	        return "User not found";
	    }
    }
	
	
	
}
