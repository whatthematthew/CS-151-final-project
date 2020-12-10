package model;

import java.util.ArrayList;
import java.util.Arrays;

public class PresetOrders 
{
	AllIngredients a = new AllIngredients();
	
	PokeBowl customBowl = new PokeBowl();
	MilkTea customMTea = new MilkTea();
	Noodles customNoodle = new Noodles();
	Sushi customSushi = new Sushi();
	
	ArrayList<Protein> spicySalmonProteins = new ArrayList<>(Arrays.asList(a.spicySalmon, a.spicySalmon, a.spicySalmon));
	ArrayList<Topping> spicySalmonToppings = new ArrayList<>(Arrays.asList(a.avocado, a.edamame));
	PokeBowl spicySalmon = new PokeBowl("Spicy Salmon Poke Bowl", a.whiteRice, spicySalmonProteins, spicySalmonToppings);
	
	ArrayList<Protein> tropicalProteins = new ArrayList<>();
	ArrayList<Topping> tropicalToppings = new ArrayList<>();
	PokeBowl tropical = new PokeBowl("Tropical Poke Bowl", a.whiteRice, tropicalProteins, tropicalToppings);
	
	ArrayList<PokeBowl> pokeOrders = new ArrayList<>(Arrays.asList(customBowl, spicySalmon, tropical));
	ArrayList<Noodles> noodleOrders = new ArrayList<>(Arrays.asList(customNoodle));
	ArrayList<Sushi> sushiOrders = new ArrayList<>(Arrays.asList(customSushi));
	ArrayList<MilkTea> teaOrders = new ArrayList<>(Arrays.asList(customMTea));
	
	public PresetOrders()
	{
		spicySalmonProteins.add(a.spicySalmon);
		spicySalmonProteins.add(a.spicySalmon);
		spicySalmonProteins.add(a.spicySalmon);
		
		spicySalmonToppings.add(a.avocado);
		spicySalmonToppings.add(a.edamame);
		
		spicySalmon = new PokeBowl("Spicy Salmon Poke Bowl", a.whiteRice, spicySalmonProteins, spicySalmonToppings);

		tropicalProteins.add(a.salmon);
		tropicalProteins.add(a.spicySalmon);
		tropicalProteins.add(a.salmon);
		tropicalProteins.add(a.spicyTuna);
		tropicalProteins.add(a.spicyTuna);
		tropicalProteins.add(a.tuna);
		tropicalProteins.add(a.salmon);
		
		tropicalToppings.add(a.avocado);
		tropicalToppings.add(a.edamame);
		
		tropical = new PokeBowl("Tropical Poke Bowl", a.whiteRice, tropicalProteins, tropicalToppings);

	}
	
	public ArrayList<PokeBowl> getPokeBowlOrders()
	{
		return pokeOrders;
	}
	
	public ArrayList<Noodles> getNoodleOrders()
	{
		return noodleOrders;
	}

	public ArrayList<Sushi> getSushiOrders() 
	{
		return sushiOrders;
	}
}
