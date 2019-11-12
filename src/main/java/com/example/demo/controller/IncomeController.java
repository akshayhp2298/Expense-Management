package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Income;
import com.example.demo.repo.IncomeRepo;

@RestController(value ="income")
public class IncomeController {
	@Autowired
	IncomeRepo repo;
	@GetMapping("income/by/user/{user}")
	List<Income> getExpenseByUser(@PathVariable String user) {
		return repo.findByUId(Integer.parseInt(user));
	}
	
	@DeleteMapping("income/{id}")
	String deleteExpense(@PathVariable int id) {
		repo.deleteById(id);
		return "success";
	}

}
