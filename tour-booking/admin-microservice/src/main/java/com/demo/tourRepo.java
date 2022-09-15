package com.demo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entity.Tour;

public interface tourRepo extends JpaRepository<Tour, Integer> {
	

}
