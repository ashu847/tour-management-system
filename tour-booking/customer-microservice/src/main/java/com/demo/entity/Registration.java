package com.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CUSTOMER")
public class Registration {
	
	@Id
	@Column(name="CUSTOMERID")
	private int customerid;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="USERNAME")
	private String username;
	
	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="PHONENUMBER")
	private double phoneno;
	
	@Column(name="AGE")
	private int age;
	
	public Registration() {
		// TODO Auto-generated constructor stub
	}

	public Registration(int customerid, String name, String username, String password, double phoneno, int age) {
		this.customerid = customerid;
		this.name = name;
		this.username = username;
		this.password = password;
		this.phoneno = phoneno;
		this.age = age;
	}

	public int getCustomerid() {
		return customerid;
	}

	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(double phoneno) {
		this.phoneno = phoneno;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
	

}
