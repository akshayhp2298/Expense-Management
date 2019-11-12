package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.repo.UserRepo;

import antlr.collections.List;
import net.minidev.json.JSONObject;

@RestController(value = "user")
public class UserController {
	@Autowired
	UserRepo userRepo;
	
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
