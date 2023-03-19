package com.neodev.cupgift.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.neodev.cupgift.model.Gift;
import com.neodev.cupgift.model.Order;
import com.neodev.cupgift.model.Theme;
import com.neodev.cupgift.model.User;

@SpringBootTest
class OrderControllerTests {

	@Autowired
	private OrderController oc;
	
	@Test
	void addtest() {
		String a = "Test";
		int	b = 1;
		long c = 1;
		Date d = Date.valueOf("2015-03-31");
		Gift g = new Gift(c, a, b, a, b, a);
		Theme t = new Theme(c, a, a, b);
		User u = new User(b, a, a, a, a, a);
		
//		Order o = new Order(b,a,a,d,b,a,a,a,b,g,u,t);
//		assertEquals(o.getOrderName(),oc.addOrder(o).getOrderName());
//		oc.editOrder(o, b);
//		oc.editOrderByUser(b);
//		oc.editOrder(o, b);
//		oc.getorderbyId(b);
//		
		
//		oc.deleteOrder(b);
//		oc.deleteOrderByUser(b);
	}
	
//	@Test
//	void getAllOrdersTest() {
//		oc.getAllOrders();
//	}
	
//	@Test
//	void deleteOrderTest() {
//		String a = "Test";
//		int	b = 1;
//		long c = 1;
//		Date d = Date.valueOf("2015-03-31");
//		Gift g = new Gift(c, a, b, a, b, a);
//		Theme t = new Theme(c, a, a, b);
//		User u = new User(b, a, a, a, a, a);
//		
//		Order o = new Order(b,a,a,d,b,a,a,a,b,g,u,t);
//		
//		
//			}
	

}
