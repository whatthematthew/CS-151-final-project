package model;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.ImageIcon;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class testIngredient {
	
	@Test
	void testBase() {
		AllIngredients test= new AllIngredients();
		ArrayList<PokeBase> base= test.getPokeBase();
		assertNotNull(base);
	}
	
	@Test
	void testProtein() {
		AllIngredients test= new AllIngredients();
		ArrayList<PokeProtein> base= test.getPokeProtein();
		assertNotNull(base);
	}
	
	@Test
	void testPokeTopping() {
		AllIngredients test= new AllIngredients();
		ArrayList<PokeTopping> base= test.getPokeTopping();
		assertNotNull(base);
	}
	
	@Test
	void testTeaBase()
	{
		AllIngredients test= new AllIngredients();
		ArrayList<TeaBase> base= test.getMilkTeaBase();
		assertNotNull(base);
	}
	
	@Test
	void testTeaTopping() {
		AllIngredients test= new AllIngredients();
		ArrayList<TeaTopping> base= test.getMilkTeaTopping();
		assertNotNull(base);
	}
}
