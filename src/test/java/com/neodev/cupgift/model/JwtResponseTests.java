package com.neodev.cupgift.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class JwtResponseTests {
	
	JwtResponse obj = new JwtResponse();
	
	@Test
	void UserRoleTest() {
		String a = "Test";
		obj.setUser(a);
		assertEquals(a,obj.getUserRole());
	}
	
	@Test
	void JwtTokenTest() {
		String a = "Test";
		obj.setJwtToken(a);
		assertEquals(a,obj.getJwtToken());
	} 
	
	@Test
	void UserIdTest() {
		int a = 1;
		obj.setUserId(a);
		assertEquals(a,obj.getUserId());
	}
}
