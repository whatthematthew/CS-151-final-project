package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class testTeatopping {

	@Test
	void testgetPrice() {
		TeaTopping test= new TeaTopping("boba", .50);
		double price= test.getPrice();
		assertEquals(price, .50);
	}
	
	void testName() {
		TeaTopping test= new TeaTopping("boba", .50);
		String name= test.getName();
		assertSame(name, "boba");
	}
	
}
