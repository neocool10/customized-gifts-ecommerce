package com.virtusa.springapp.tempmodel;

public class TempUser {

	private int userId;
	private String email;
	private String password;
	private String username;
	private String mobileNumber;
	private String userRole="User";
	
	
	
	public TempUser() {
		super();
	}

	public TempUser(int userId, String email, String password, String username, String mobileNumber, String userRole) {
		super();
		this.userId = userId;
		this.email = email;
		this.password=password;
		this.username=username;
		this.mobileNumber = mobileNumber;
		this.userRole = userRole;
		
		
	}

	public int getuserId() {
		return userId;
	}

	public void setuserId(int userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}


}
