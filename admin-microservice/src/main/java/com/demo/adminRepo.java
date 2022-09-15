package com.demo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entity.Admin;

public interface adminRepo extends JpaRepository<Admin, Integer> {
	
	public Optional<Admin> findByUsername(String username);

}
