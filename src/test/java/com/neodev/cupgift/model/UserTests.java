package com.neodev.cupgift.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class UserTests {
	
	User obj = new User();
	
	@Test
	void userIdTest() {
		int a = 1;
		obj.setuserId(a);
		assertEquals(a,obj.getuserId());
	}
	
	@Test
	void EmailTest() {
		String a = "Test";
		obj.setEmail(a);
		assertEquals(a,obj.getEmail());
	}
	
	@Test
	void PasswordTest() {
		String a = "Test";
		obj.setPassword(a);
		assertEquals(a,obj.getPassword());
	}
	
	@Test
	void UsernameTest() {
		String a = "Test";
		obj.setUsername(a);
		assertEquals(a,obj.getUsername());
	}
	
	@Test
	void MobileTest() {
		String a = "Test";
		obj.setMobileNumber(a);
		assertEquals(a,obj.getMobileNumber());
	}
	
	@Test
	void UserRoleTest() {
		String a = "Test";
		obj.setUserRole(a);
		assertEquals(a,obj.getUserRole());
	}

}
