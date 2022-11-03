package com.virtusa.springapp.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class ThemeTests {
	
	Theme obj = new Theme();
	
	@Test
	void themeIdTest() {
		long a = 1;
		obj.setThemeId(a);
		assertEquals(a,obj.getThemeId());
	}
	
	@Test
	void themeNameTest() {
		String a = "Test";
		obj.setThemeName(a);
		assertEquals(a,obj.getThemeName());
	}
	
	@Test
	void themeDetailsTest() {
		String a = "Test";
		obj.setThemeDetails(a);
		assertEquals(a,obj.getThemeDetails());
	}
	
	@Test
	void themePriceTest() {
		int a = 1;
		obj.setThemePrice(a);
		assertEquals(a,obj.getThemePrice());
	}
	
	@Test
	void gifttoStringTest() {
		String a = "Test";
		int	b = 1;
		long c = 1;
		obj.setThemeId(c);
		obj.setThemeName(a);
		obj.setThemeDetails(a);
		obj.setThemePrice(b);
		assertEquals("{" +
	            " themeId='" + c + "'" +
	            ", themeName='" + a + "'" +
	            ", themeDetails='" + a + "'" +
	            ", themePrice='" + b + "'" +
	            "}",obj.toString());
	}
}