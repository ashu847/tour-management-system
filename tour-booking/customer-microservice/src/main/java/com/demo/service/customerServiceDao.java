package com.demo.service;

import com.demo.entity.Registration;

public interface customerServiceDao {
	public String registerCustomer(Registration reg);
	
	public boolean validCredential(String id, String pass);
	
	public Registration findCust(String username);

}
