package com.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.demo.entity.Booked;

public interface bookedRepo extends JpaRepository<Booked, Integer> {
	
	@Modifying
	@Query(value="select b from Booked b where customerId=?1")
	public List<Booked> findAllBookedTours(int customerId);


}
