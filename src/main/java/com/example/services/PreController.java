package com.example.services;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.example.models.User;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class PreController {
	private static final Logger logger = LogManager.getLogger(PreController.class);
	@GetMapping("/testing")
	public String testing() {
		logger.debug("Debugging log");
        logger.info("Info log");
        logger.warn("Hey, This is a warning!");
        logger.error("Oops! We have an Error. OK");
        logger.fatal("Damn! Fatal error. Please fix me.");
		return "finally chal gaya1";
	}
	
	@PostMapping("/addUser")
	public User create(@RequestBody User userData) {	 

		System.out.println(userData);
		return userData;
	}
}
