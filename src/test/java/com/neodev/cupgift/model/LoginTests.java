package com.neodev.cupgift.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class LoginTests {
	
	Login obj = new Login();
	
	@Test
	void emailTest() {
		String a = "Test";
		obj.setEmail(a);
		assertEquals(a,obj.getEmail());
	}
	
	@Test
	void passwordTest() {
		String a = "Test";
		obj.setPassword(a);
		assertEquals(a,obj.getPassword());
	}

}
