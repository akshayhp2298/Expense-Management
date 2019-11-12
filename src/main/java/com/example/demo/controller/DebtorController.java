package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Debtor;
import com.example.demo.repo.DebtorRepo;

@RestController(value = "debtor")
public class DebtorController {
	@Autowired
	DebtorRepo repo;
	
	@GetMapping("debtor/by/user/{user}")
	List<Debtor> getExpenseByUser(@PathVariable String user) {
		return repo.findByUId(Integer.parseInt(user));
	}
	
	@DeleteMapping("debtor/{id}")
	String deleteExpense(@PathVariable int id) {
		repo.deleteById(id);
		return "success";
	}

}
