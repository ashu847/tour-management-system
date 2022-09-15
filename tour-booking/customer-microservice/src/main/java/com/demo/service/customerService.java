package com.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.registrationRepo;
import com.demo.entity.Registration;

@Service
public class customerService implements customerServiceDao {
	
	@Autowired
	registrationRepo regRepo;
	
	public String registerCustomer(Registration reg) {
		
		if(regRepo.existsByUsername(reg.getUsername())) {
			return "Customer Already Exist";
		}
		
		else {
			regRepo.save(reg);
			return "Successfully Customer Added";
			
		}
		
	}
	
	public boolean validCredential(String id, String pass) {
		Optional<Registration> cust = regRepo.findByUsername(id);
		
		if(cust.isPresent()) {
			if(cust.get().getPassword().equals(pass)) {
				return true;
			}
			else {
				return false;
			}
		}
		
		else {
			return false;
		}
		
	}
	
	public Registration findCust(String username) {
		Optional<Registration> cust= regRepo.findByUsername(username);
		return cust.get();
		
		
	}

}
