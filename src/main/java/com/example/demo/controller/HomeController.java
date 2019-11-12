package com.example.demo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class HomeController{
	@RequestMapping("/")
	public String home() {
		
		return "hello";
	}
	@RequestMapping("/ping")
	public String ping() {
		
		return "working";
	}
}
	