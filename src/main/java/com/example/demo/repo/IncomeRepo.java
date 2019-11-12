package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.model.Income;

@RepositoryRestResource(collectionResourceRel = "income", path = "income")
public interface IncomeRepo extends JpaRepository<Income, Integer>{

	@Query(value = "SELECT i_id,name,date,u_id,amt FROM income WHERE u_id = :uId", nativeQuery = true)
	List<Income> findByUId(@Param("uId") int uId);
}
