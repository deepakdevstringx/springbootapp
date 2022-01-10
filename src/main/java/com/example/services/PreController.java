package com.example.services;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.User;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class PreController {
	
	@GetMapping("/testing")
	public String testing() {
		return "finally chal gaya";
	}
	
	@PostMapping("/addUser")
	public User create(@RequestBody User userData) {	 

		System.out.println(userData);
		return userData;
	}
}
