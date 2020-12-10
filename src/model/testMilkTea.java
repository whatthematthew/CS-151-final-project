package model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class testMilkTea {
	
	private Base nameOfBase = new TeaBase("green");
	private Topping tt;
	
	@Test
	void testName() {
		MilkTea test= new MilkTea();
		String name= test.getName();
		assertNotNull(name, "Milk Tea");
	}
	
	@Test
	void testBaseChange() {
		MilkTea test= new MilkTea();
		test.changeBase(nameOfBase);
		assertNotNull(test);
	}
	
	@Test
	void testAddTopping() {
		MilkTea test= new MilkTea();
		test.addTopping(tt);
		assertNotNull(test);
	}
	
	@Test
	void testRemoveTopping() {
		MilkTea test= new MilkTea();
		test.removeTopping(tt);
		assertNotNull(test);
	}
	
	@Test
	void testgetPrice() {
		MilkTea test= new MilkTea();
		double price= test.getPrice();
		assertEquals(price, 3);
	}
	
	@Test
	void testToString() {
		MilkTea test= new MilkTea();
		String phrase= test.toString();
		assertNotNull(phrase);
	}
	
	

}
