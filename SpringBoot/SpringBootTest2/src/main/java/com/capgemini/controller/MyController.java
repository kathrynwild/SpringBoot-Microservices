package com.capgemini.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
	@GetMapping("/hello")
	public String helloWorld() {
		return "Welcome to Spring Boot Training"; 	// return employee object
	}
	

}
