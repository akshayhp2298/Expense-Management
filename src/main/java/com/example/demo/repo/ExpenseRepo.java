package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.model.Expense;

@RepositoryRestResource(collectionResourceRel = "expense", path = "expense")
public interface ExpenseRepo extends JpaRepository<Expense, Integer>{
	
	@Query(value = "SELECT e_id,name,date,u_id,amt FROM expense e WHERE e.u_id = :uId", nativeQuery = true)
	List<Expense> findByUId(@Param("uId") int uId);
}
