package com.virtusa.springapp.model;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class GiftTests {
	
	Gift obj = new Gift();
	
	
	@Test
	void giftIdTest() {
		long a = 1;
		obj.setGiftId(a);
		assertEquals(a,obj.getGiftId());
	}
	
	@Test
	void giftNameTest() {
		String a = "Test";
		obj.setGiftName(a);
		assertEquals(a,obj.getGiftName());
	}
	
	@Test
	void giftImageUrlTest() {
		String a = "Test";
		obj.setGiftImageUrl(a);
		assertEquals(a,obj.getGiftImageUrl());
	}
	
	@Test
	void giftDetailsTest() {
		String a = "Test";
		obj.setGiftDetails(a);
		assertEquals(a,obj.getGiftDetails());
	}
	
	@Test
	void giftPriceTest() {
		int	a = 1;
		obj.setGiftPrice(a);
		assertEquals(a,obj.getGiftPrice());
	}
	
	@Test
	void giftQuantityTest() {
		int a = 1;
		obj.setGiftQuantity(a);
		assertEquals(a,obj.getGiftQuantity());
	}
	
	@Test
	void gifttoStringTest() {
		String a = "Test";
		int	b = 1;
		long c = 1;
		obj.setGiftId(c);
		obj.setGiftName(a);
		obj.setGiftImageUrl(a);
		obj.setGiftDetails(a);
		obj.setGiftPrice(b);
		obj.setGiftQuantity(b);
		assertEquals("Gift [giftId=1, giftName=Test, giftImageUrl=Test, giftDetails=Test, giftPrice=1, giftQuantity=1]",obj.toString());
	}
}
