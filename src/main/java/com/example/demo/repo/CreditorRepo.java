package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.model.Creditor;

@RepositoryRestResource(collectionResourceRel = "creditor", path = "creditor")
public interface CreditorRepo extends JpaRepository<Creditor, Integer>{
	@Query(value = "SELECT c_id,name,date,u_id,amt FROM creditor WHERE u_id = :uId", nativeQuery = true)
	List<Creditor> findByUId(@Param("uId") int uId);
}
