package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Creditor;
import com.example.demo.repo.CreditorRepo;

@RestController(value = "creditor")
public class CreditorController {
	@Autowired
	CreditorRepo repo;
	@GetMapping("creditor/by/user/{user}")
	List<Creditor> getExpenseByUser(@PathVariable String user) {
		return repo.findByUId(Integer.parseInt(user));
	}
	
	@DeleteMapping("creditor/{id}")
	String deleteExpense(@PathVariable int id) {
		repo.deleteById(id);
		return "success";
	}

}
