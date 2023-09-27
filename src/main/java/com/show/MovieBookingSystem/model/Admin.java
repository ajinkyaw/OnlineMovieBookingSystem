package com.show.MovieBookingSystem.model;


public class Admin {
	
	private String adminName;
	private String password;
	private String phoneNo;

	public Admin(String adminName, String password) {
		super();
		this.adminName = "rozina";
		this.password = "1234";
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	@Override
	public String toString() {
		return "Admin [adminName=" + adminName + ", password=" + password + ", phoneNo=" + phoneNo + "]";
	}

 

}