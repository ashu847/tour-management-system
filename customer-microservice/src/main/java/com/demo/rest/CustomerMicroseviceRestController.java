package com.demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.Registration;
import com.demo.service.customerServiceDao;

@RestController
public class CustomerMicroseviceRestController {
	
	@Autowired
	customerServiceDao custServ;
	
	@PostMapping(value="/adduser")
	public ResponseEntity<String> addcustomer(@RequestBody Registration reg) {
		String res = custServ.registerCustomer(reg);
		return ResponseEntity.ok(res);
		
	}
	
	@GetMapping(value="/custlogin/{username}/{password}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> validateAdmin(@PathVariable("username") String username, @PathVariable("password") String password) {
		boolean res= custServ.validCredential(username, password);
		if(res==true) {
			return ResponseEntity.ok("first");
		}
		else {
			return ResponseEntity.ok("{\"status\":\"Invalid user\"}");
		}
		
		
		
	}
	

	@GetMapping(value="/findcust/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Registration> findCustomer(@PathVariable("username") String username) {
		
		Registration cust= custServ.findCust(username);
			return ResponseEntity.ok(cust);
		}
		
		
		
	}
	
	


