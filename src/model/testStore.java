package model;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class testStore {
	//Model class is MVC pattern
	private AllIngredients ai;
	private PresetOrders po;
	private ArrayList<OrderType> allOrders = new ArrayList<>();

	@Test
	void getAllOrder() {
		for(int i=0; i<allOrders.size(); i++)
		{
			System.out.println(allOrders);
		}
		assertEquals(allOrders.size(), 0);
	}
	
	@Test
	void testGetCounter() {
		Store test= new Store(ai, po);
		int count= test.getCurrentOrderIndex();
		assertEquals(count,-1);
	}
}
	
	
	
	

	


