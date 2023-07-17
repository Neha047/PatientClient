package com.springProject_ms.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springProject_ms.Model.Registration;



@Repository
public interface Registration_repo extends JpaRepository<Registration, String>{

Registration getByUsername(String username);
//
	boolean existsByUsername(String username);

	boolean existsByEmail(String username);
	<optional>Registration findByUsername(String username);

	

}