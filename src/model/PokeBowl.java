package model;

import java.util.ArrayList;
/**
 * @author Lila, Juan, matthewwu
 *This class brings the Poke order together
 */
public class PokeBowl implements Food
{	//instance variables
	private String name;
	private Base nameOfBase;
	private ArrayList<Protein> proteins = new ArrayList<>();
	private ArrayList<Topping> toppings = new ArrayList<>();
	private double price = 7;
	
	/**
	 * Constructor for Pokebowl
	 * initialize name and base
	 */
	public PokeBowl()
	{
		name = "Custom Poke Bowl";
		nameOfBase = new PokeBase("");
	}
	/**
	 * constructor for name, base, list of protein and topping
	 * @param n
	 * @param b
	 * @param p
	 * @param t
	 */
	public PokeBowl(String n, Base b, ArrayList<Protein> p, ArrayList<Topping> t)
	{
		name = n;
		nameOfBase = b;
		for(Protein pp: p)
			proteins.add(pp);
		for(Topping pt: t)
			toppings.add(pt);
	}
	/**
	 * constructor to gets the whole order description
	 * @param pb a poke bowl
	 */
	public PokeBowl(PokeBowl pb)
	{
		name = pb.getName();
		nameOfBase = pb.getBase();
		for(Protein p: pb.getProteins())
			proteins.add(p);
		for(Topping t: pb.getToppings())
			toppings.add(t);
	}
	/**
	 * gets the name
	 */
	@Override
	public String getName()
	{
		return name;
	}
	/**
	 * @returns the base
	 */
	public Base getBase()
	{
		return nameOfBase;
	}
	/**
	 * @return the list of protein
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
	 * adds a protein to the list
	 */
	@Override
	public void addProtein(Protein p)
	{
		if(p instanceof PokeProtein)
			proteins.add(p);
	}
	
	/**
	 * removes a protein from the list
	 */
	@Override
	public void removeProtein(Protein p)
	{
		if(p instanceof PokeProtein)
			proteins.remove(p);
		else
			System.out.println("not instance of poke protein");
	}
	
	/**
	 * change the base 
	 */
	@Override
	public void changeBase(Base b)
	{
		if(b instanceof PokeBase)
			nameOfBase = b;
	}
	
	/**
	 * add a topping to the list
	 */
	@Override
	public void addTopping(Topping pt)
	{
		if(pt instanceof PokeTopping)
			toppings.add(pt);
	}
	
	/**
	 * removes a topping from the list
	 */
	@Override
	public void removeTopping(Topping pt)
	{
		if(pt instanceof PokeTopping)
			toppings.remove(pt);
	}
	
	/**
	 * gets the price of the entire PokeBowl
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
	 * gets the description of the entire order
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
