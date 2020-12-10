package model;

import java.util.ArrayList;

public class Test 
{
	public static void main(String[] args) throws CloneNotSupportedException
	{
		ArrayList<OrderType> order = new ArrayList<>();
		
		AllIngredients a = new AllIngredients();
		PresetOrders p = new PresetOrders();
		
		PokeBowl pb = new PokeBowl();
		
		pb.changeBase(a.whiteRice);
		
		pb.addProtein(a.salmon);
		pb.addProtein(a.salmon);
		
		pb.addTopping(a.edamame);
		//pb.addTopping(a.crabSalad);
		
		System.out.println(pb);
		
		pb.removeTopping(a.edamame);
		
		pb.removeProtein(a.salmon);
		
		pb.changeBase(a.veggies);
		
		System.out.println(pb);
		
		MilkTea mt = new MilkTea();
		
		mt.changeBase(a.blackTea);
		mt.addTopping(a.boba);
		
		System.out.println(mt);
		
		/*System.out.println(p.tropical);
		PokeBowl pc = (PokeBowl)p.tropical.clone();
		System.out.println(pc);
		pc.addProtein(a.salmon);
		System.out.println(pc);
		pc.removeProtein(a.salmon);
		System.out.println(pc);
		pc.removeProtein(a.salmon);
		pc.removeProtein(a.salmon);
		pc.removeProtein(a.salmon);
		System.out.println(pc);*/
		//System.out.println(pc);
		//pc.changeBase(a.veggies);
		//pc.removeProtein(a.salmon);
		//pc.removeTopping(a.avocado);
		
		order.add(pb);
		order.add(mt);
		order.add(p.spicySalmon);
		order.add(p.tropical);
		//order.add(pc);
		
		System.out.println();
		
		for(int i = 1; i < (order.size() + 1); i++)
			System.out.println("Order " + i + ": " + order.get(i - 1).toString());
		
		ArrayList<Protein> tropicalProteins = new ArrayList<>();
		tropicalProteins.add(a.tuna);
		tropicalProteins.add(a.spicySalmon);
		tropicalProteins.add(a.spicySalmon);
		tropicalProteins.add(a.spicySalmon);
		tropicalProteins.add(a.spicySalmon);
		tropicalProteins.add(a.spicySalmon);
		tropicalProteins.add(a.tuna);
		tropicalProteins.add(a.salmon);
		tropicalProteins.add(a.spicySalmon);
		tropicalProteins.add(a.salmon);
		tropicalProteins.add(a.spicyTuna);
		tropicalProteins.add(a.spicyTuna);
		tropicalProteins.add(a.tuna);
		tropicalProteins.add(a.salmon);
		tropicalProteins.add(a.spicySalmon);
			
		
		ArrayList<Topping> tropicalToppings = new ArrayList<>();
		tropicalToppings.add(a.avocado);
		tropicalToppings.add(a.edamame);
		
		PokeBowl tropical = new PokeBowl("Tropical Poke Bowl", a.whiteRice, tropicalProteins, tropicalToppings);
		System.out.println(tropical);
	}
}
