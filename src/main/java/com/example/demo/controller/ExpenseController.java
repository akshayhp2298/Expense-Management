package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Expense;
import com.example.demo.repo.ExpenseRepo;

@RestController(value = "expense")
public class ExpenseController {
	@Autowired
	ExpenseRepo repo;
	
	@GetMapping("expense/by/user/{user}")
	List<Expense> getExpenseByUser(@PathVariable String user) {
		return repo.findByUId(Integer.parseInt(user));
	}
	
	@DeleteMapping("expense/{id}")
	String deleteExpense(@PathVariable int id) {
		repo.deleteById(id);
		return "success";
	}

}
