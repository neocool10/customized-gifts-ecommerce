package com.virtusa.springapp.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.virtusa.springapp.model.JwtResponse;
import com.virtusa.springapp.model.Login;

@SpringBootTest
class AuthControllerTests {
	
	@Autowired
	private AuthController ac;
	
	@Test
	void isPresentTest() throws Exception{
		Login l = new Login("c@c.c","cccccccc");
		ac.createJwtToken(l);
		assertEquals(true,ac.isAdminPresent("b@b.b"));
		assertEquals(false,ac.isAdminPresent(""));
		assertEquals(true,ac.isSuperAdminPresent("a@a.a"));
		assertEquals(false,ac.isSuperAdminPresent(""));
		assertEquals(true,ac.isUserPresent("c@c.c"));
		assertEquals(false,ac.isUserPresent(""));	
	}
	

}
