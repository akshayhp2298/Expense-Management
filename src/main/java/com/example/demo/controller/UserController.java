package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.repo.UserRepo;

import net.minidev.json.JSONObject;


@RestController(value = "user")
public class UserController {
	@Autowired
	UserRepo userRepo;
	
	@GetMapping("user/{email}") 
	User getUsers(@PathVariable String email) {
		return userRepo.findByEmail(email);
	}
	
	@PostMapping("user/login")
	boolean login(@RequestBody JSONObject ob) {
		boolean isValid = false;
		String email = ob.get("email").toString();
		String password = ob.getAsString("password").toString();
		User user = userRepo.findByEmail(email);
		if(user == null) return false;
		System.out.println(ob.get("email") + " " + ob.get("password"));
		if(password.equals(user.getPassword())) isValid = true;
		return isValid;
	}
}
