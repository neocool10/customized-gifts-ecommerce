package com.virtusa.springapp.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;

import com.virtusa.springapp.tempmodel.TempGift;

@SpringBootTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class GiftControllerTests {
	
	@Autowired
	private GiftController gc;
	
	@Test
	void getGiftByIdtest() {
		gc.getGift();
		long c = 1;
		assertEquals(c,gc.getGiftById(c).getGiftId());
	}
	
	@Test
	void deleteGiftTest() {
		String a = "Test";
		int	b = 1;
		long c = 100;
		TempGift g = new TempGift(c, a, b, a, b, a);
		gc.addGift(g);
		assertEquals("Gift Deleted Successfully!", gc.deleteGift(c));
	}
	
	@Test
	void editGiftTest() {
		String a = "Test";
		int	b = 1;
		long c = 100;
		TempGift g = new TempGift(c, a, b, a, b, a);
		gc.addGift(g);
		assertEquals("Gift Updated Successfully!", gc.editGift(c,g));
	}
	
	@Test
	void editGiftQuantityTest() {
		int b = 1;
		long c = 100;
		assertEquals("Gift Quantity Updated Sucessfully",gc.editGiftQuantity(c, b));
	}

}
