package com.demo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entity.Registration;

public interface registrationRepo extends JpaRepository<Registration, Integer> {
	
	public boolean existsByUsername(String username);
	
	public Optional<Registration> findByUsername(String ussrname);

}
