package com.neodev.cupgift.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.neodev.cupgift.tempmodel.TempUser;

@SpringBootTest
class UserControllerTests {

	@Autowired
	private UserController uc;
	
//	@Test
//	void registertest() {
//		String a = "a@a.a";
//		int	b = 1;
//		TempUser u = new TempUser(b, a, a, a, a, "SuperAdmin");
//		assertEquals(a,uc.registerNewUser(u).getEmail());
//	}

}
