package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.model.Debtor;

@RepositoryRestResource(collectionResourceRel = "debtor", path = "debtor")
public interface DebtorRepo extends JpaRepository<Debtor, Integer>{
	@Query(value = "SELECT d_id,name,date,u_id,amt FROM debtor WHERE u_id = :uId", nativeQuery = true)
	List<Debtor> findByUId(@Param("uId") int uId);
}
