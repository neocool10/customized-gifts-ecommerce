package com.virtusa.springapp.controller;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.virtusa.springapp.tempmodel.TempTheme;

@SpringBootTest
class ThemeControllerTests {
	
	@Autowired
	private ThemeController tc;
	
	@Test
	void getTest() {
		tc.getAdminTheme();
		tc.getUserTheme();
		assertEquals(tc.getAdminTheme().toString(),tc.getUserTheme().toString());
		
	}
	
	@Test
	void modifyTest() {
		String a = "Test";
		int	b = 1;
		long c = 1;
		TempTheme t = new TempTheme(c, a, a, b);
		tc.addTheme(t);
		tc.editTheme(c, t);
		tc.getThemeById(c);
//		assertEquals(c,tc.getThemeById(c).getThemeId());
	}
}
