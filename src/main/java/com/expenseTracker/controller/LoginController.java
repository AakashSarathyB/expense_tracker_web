package com.expenseTracker.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expenseTracker.entity.User;
import com.expenseTracker.repository.UserRepository;

@RestController
@RequestMapping("expense-tracker/auth")
@CrossOrigin(origins = "*")
public class LoginController {
	
	@Autowired
	private UserRepository userRepo;
	
	@PostMapping("/login")
	public ResponseEntity<HashMap<String, Object>> login(@RequestBody User user){
		HashMap<String, Object> response = new HashMap<String, Object>();
		User userObj = userRepo.findByUsername(user.getUsername());
		if(userObj != null) {
			System.out.print(userObj.getUsername());
			response.put("status", "success");
			response.put("message", "Login successful");
			response.put("token", "dummy-jwt-token");
		}else {
			response.put("status", "fail");
			response.put("message", "Login un-successful");
		}
		return ResponseEntity.ok(response);
	}
	
	@PostMapping("/register")
	public ResponseEntity<HashMap<String, Object>> registerUser(@RequestBody User user){
		HashMap<String, Object> response = new HashMap<String, Object>();
		User userObj = userRepo.findByUsername(user.getUsername());
		if(userObj != null) {
			response.put("status", "success");
			response.put("userExists", true);
			response.put("message", "User name exists");
		}else {
			
		}
		
		return ResponseEntity.ok(response);
	}

}
