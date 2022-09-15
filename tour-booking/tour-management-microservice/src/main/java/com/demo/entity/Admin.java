package com.demo.entity;

public class Admin {
	
	
	private int adminId;
	
	private String username;
	
	
	private String pass;
	
	public Admin() {
		// TODO Auto-generated constructor stub
	}

	

	public Admin(int adminId, String username, String pass) {
		this.adminId = adminId;
		this.username = username;
		this.pass = pass;
	}



	public int getAdminId() {
		return adminId;
	}



	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}



	

	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
	

}
