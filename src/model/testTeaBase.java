package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class testTeaBase {

	@Test
		void testBaseName() {
			TeaBase test= new TeaBase("Green");
			String name= test.getName();
			assertSame(name, "Green");
		}
	
	void testName() {
		TeaBase test= new TeaBase("Green");
		String name= test.getName();
		assertNotEquals(name, "Milk Tea");
	}
	
	

}
