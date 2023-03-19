package com.neodev.cupgift.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;

import org.junit.jupiter.api.Test;



class OrderTests {

	Order obj = new Order();
	
	
	@Test
	void OrderIdTest() {
		int a = 1;
		obj.setOrderId(a);
		assertEquals(a,obj.getOrderId());
	}
	
	@Test
	void OrderPriceTest() {
		int a = 01;
		obj.setOrderPrice(a);
		assertEquals(a,obj.getOrderPrice());
	}
	
	@Test
	void OrderGiftTest() {
		String a = "Test";
		int	b = 1;
		long c = 1;
		Gift g = new Gift(c, a, b, a, b, a);
		obj.setGift(g);
		assertEquals(g,obj.getGift());
	}
	
	@Test
	void OrderThemeTest() {
		String a = "Test";
		int	b = 1;
		long c = 1;
		Theme t = new Theme(c, a, a, b);
		obj.setTheme(t);
		assertEquals(t,obj.getTheme());
	}
	
	@Test
	void OrderUserTest() {
		String a = "Test";
		int	b = 1;
		User u = new User(b, a, a, a, a, a);
		obj.setUser(u);
		assertEquals(u,obj.getUser());
	}
	
	@Test
	void orderToStringTest() {
		String a = "Test";
		int	b = 1;
		long c = 1;
		Date d = Date.valueOf("2015-03-31");
		Gift g = new Gift(c, a, b, a, b, a);
		Theme t = new Theme(c, a, a, b);
		User u = new User(b, a, a, a, a, a);
		obj.setOrderId(b);
		obj.setOrderPrice(b);
		obj.setGift(g);
		obj.setTheme(t);
		obj.setUser(u);
		
//		assertEquals("Order [orderId=" + b + ", orderName=" + a + ", orderDescription=" + a
//				+ ", orderDate=" + d + ", orderPrice=" + b + ", orderAddress=" + a
//				+ ", orderPhone=" + a + ", orderEmail=" + a + ", orderQuantity=" + b + ", gift="
//				+ g + ", user=" + u + ", theme=" + t + "]",obj.toString());
	}
}
