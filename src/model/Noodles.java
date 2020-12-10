package model;

import java.util.ArrayList;
/**
 * @author matthew, lila, juan
 *This class is the main noodle class that bring the order together
 */
public class Noodles implements Food
{
	private String name;
	private Base nameOfBase;
	private ArrayList<Protein> proteins = new ArrayList<>();
	private ArrayList<Topping> toppings = new ArrayList<>();
	private double price = 7;
/**
 * construct a noodle with no parameters 
 * initialize the name of noodle and base	
 */
	public Noodles()
	{
		name = "Custom Noodles";
		nameOfBase = new NoodleBase("");
	}
	/**
	 * Noodle constructor
	 * @param n accepts the name of the noodle
	 * @param b base of the noodle
	 * @param p list of protein 
	 * @param t list of topping
	 */
	public Noodles(String n, Base b, ArrayList<Protein> p, ArrayList<Topping> t)
	{
		name = n;
		nameOfBase = b;
		for(Protein pp: p)
			proteins.add(pp);
		for(Topping pt: t)
			toppings.add(pt);
	}
	/**
	 * construct a noodle
	 * @param n accepts a set noodle
	 */
	public Noodles(Noodles n)
	{
		name = n.getName();
		nameOfBase = n.getBase();
		for(Protein p: n.getProteins())
			proteins.add(p);
		for(Topping t: n.getToppings())
			toppings.add(t);
	}
	/**
	 * gets the name of the noodle
	 */
	@Override
	public String getName()
	{
		return name;
	}
	
	/**
	 * @return the base of the noodle
	 */
	public Base getBase()
	{
		return nameOfBase;
	}
	
	/**
	 * @return a list of protein
	 */
	public ArrayList<Protein> getProteins()
	{
		return proteins;
	}
	
	/**
	 * @return list of topping
	 */
	public ArrayList<Topping> getToppings()
	{
		return toppings;
	}
	/**
	 * adds a protein 
	 */
	@Override
	public void addProtein(Protein p)
	{
		if(p instanceof NoodleProtein)
			proteins.add(p);
	}
	/**
	 * removes a protein
	 */
	@Override
	public void removeProtein(Protein p)
	{
		if(p instanceof NoodleProtein)
			proteins.remove(p);
		else
			System.out.println("not instance of noodle protein");
	}
	/**
	 * Changes base from one to another
	 */
	@Override
	public void changeBase(Base b)
	{
		if(b instanceof NoodleBase)
			nameOfBase = b;
	}
	/**
	 * add topping
	 */
	@Override
	public void addTopping(Topping pt)
	{
		if(pt instanceof NoodleTopping)
			toppings.add(pt);
	}
	
	/**
	 * removes topping
	 */
	@Override
	public void removeTopping(Topping pt)
	{
		if(pt instanceof NoodleTopping)
			toppings.remove(pt);
	}
	
	/**
	 * gets the price of the entire noodle order
	 */
	@Override
	public double getPrice()
	{
		double returnPrice = price;
		
		for(Protein p: proteins)
			returnPrice += p.getPrice();
		
		for(Topping t: toppings)
			returnPrice += t.getPrice();
		
		return returnPrice;
	}
	
	/**
	 * converts the noodle and its topping into a string
	 */
	@Override
	public String toString()
	{
		String returnString = name + " with " + nameOfBase.getName();
		
		//check if the user has multiple of the same protein
		int sameProtein = 0;
		for(int current =  0; current < proteins.size(); current++)
		{
			//future is a pointer that points to the right side of the current protein
			int future = current;
			//previous is a pointer that points to the left side of the current protein
			int previous = 0;
			//breakLoop determines when to end both while loops
			boolean breakLoop = false;
			
			while(future < proteins.size() && !breakLoop)
			{
				while(previous < current && !breakLoop)
				{
					//if the current protein was accounted for previously, then break the loop
					if(proteins.get(previous).getName().equals(proteins.get(current).getName()))
						breakLoop = true;
					//otherwise, iterate to the next previous item
					else
						previous++;
				}
				
				//if the current protein is repeated in the list and the loop has not been broken, then increase the count
				if(proteins.get(current).getName().equals(proteins.get(future).getName()) && !breakLoop)
					sameProtein++;
				
				//update values of pointers
				future++;
				previous = 0;
			}
			
			//if the loop was not broken, the multiples of the protein are accounted for, so add in a specific format
			if(sameProtein > 1)
				returnString += " and " + proteins.get(current).getName() + " x" + sameProtein;
			//otherwise add a single protein if the loop was not broken and there were no multiples
			else if(!breakLoop)
				returnString += " and " + proteins.get(current).getName();
			
			//reset the protein counter
			sameProtein = 0;
		}
		
		for(Topping t: toppings)
			returnString += " and " + t.getName();
				
		return returnString;
	}
}

