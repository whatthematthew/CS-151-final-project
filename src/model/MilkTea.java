package model;

import java.text.DecimalFormat;
import java.util.ArrayList;
/**
 * This class focuses on Milk tea features.
 * Customizable drink, names, and price 
 * @author Lila, Juan, Matthew
 *
 */
public class MilkTea implements Drink
{
	private Base nameOfBase = new TeaBase("");
	private ArrayList<Topping> toppings = new ArrayList<>();
	private double price = 3;
	private String name = "Milk Tea";
	
	/**
	 * gets name of milk tea
	 * @param returns a String for the name of milk tea
	 */
	@Override
	public String getName()
	{
		return name;
	}
	
	/**
	 * changes the base for tea base
	 *@param Base b of the tea
	 */
	@Override
	public void changeBase(Base b) 
	{
		if(b instanceof TeaBase)
			nameOfBase = b;
	}

	/**
	 * adds topping
	 * @param accepts topping
	 */
	@Override
	public void addTopping(Topping tt) 
	{
		if(tt instanceof TeaTopping)
			toppings.add(tt);
	}

	/**
	 * removes a topping
	 * @param accepts a topping
	 */
	@Override
	public void removeTopping(Topping tt) 
	{
		if(tt instanceof TeaTopping)
			toppings.remove(tt);
	}

	/**
	 * gets the price of the milk tea
	 * Returns the price of the milk tea
	 */
	@Override
	public double getPrice() 
	{
		double returnPrice = price;
		
		for(Topping t: toppings)
			returnPrice += t.getPrice();
		
		return returnPrice;
	}
	
	/**
	 * Concatenates the entire drink order 
	 * @returns a string that tells the name of the drink and price.
	 */
	@Override
	public String toString()
	{
		String returnString = name + " with " + nameOfBase.getName();
		
		for(Topping t: toppings)
			returnString += " and " + t.getName();
		
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(2);
		df.setMinimumFractionDigits(2);
		
		returnString += " and costs $" + df.format(getPrice());
		
		return returnString;
	}

	/**
	 * cannot select this option
	 */
	@Override
	public void addProtein(Protein p) 
	{
		throw new UnsupportedOperationException();
	}

	/**
	 * cannot select this option
	 */
	@Override
	public void removeProtein(Protein p) 
	{
		throw new UnsupportedOperationException();
	}
}
