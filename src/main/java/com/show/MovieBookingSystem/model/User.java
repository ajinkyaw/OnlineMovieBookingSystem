package com.show.MovieBookingSystem.model;

public class User {
	private int userId;
	private String name;
	private String phoneNo;
	
	
	public User(String name, String phoneNo) {
		super();
		this.name = name;
		this.phoneNo = phoneNo;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", phoneNo=" + phoneNo + "]";
	}
	
	
}
