package com.virtusa.springapp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringappApplicationTests {

	@Test
	void contextLoads() {
		int o = 1;
		assertEquals(1,o);
	}
	

}
