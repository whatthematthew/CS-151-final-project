package model;

import java.util.ArrayList;

public class Sushi implements Food
{
	private String name;
	private Base nameOfBase;
	private ArrayList<Protein> proteins = new ArrayList<>();
	private ArrayList<Topping> toppings = new ArrayList<>();
	private double price = 7;
	
	public Sushi()
	{
		name = "Custom Sushi";
		nameOfBase = new SushiBase("");
	}
	
	public Sushi(String n, Base b, ArrayList<Protein> p, ArrayList<Topping> t)
	{
		name = n;
		nameOfBase = b;
		for(Protein pp: p)
			proteins.add(pp);
		for(Topping pt: t)
			toppings.add(pt);
	}
	
	public Sushi(Sushi n)
	{
		name = n.getName();
		nameOfBase = n.getBase();
		for(Protein p: n.getProteins())
			proteins.add(p);
		for(Topping t: n.getToppings())
			toppings.add(t);
	}
	
	@Override
	public String getName()
	{
		return name;
	}
	
	public Base getBase()
	{
		return nameOfBase;
	}
	
	public ArrayList<Protein> getProteins()
	{
		return proteins;
	}
	
	public ArrayList<Topping> getToppings()
	{
		return toppings;
	}
	
	@Override
	public void addProtein(Protein p)
	{
		if(p instanceof SushiProtein)
			proteins.add(p);
	}
	
	@Override
	public void removeProtein(Protein p)
	{
		if(p instanceof SushiProtein)
			proteins.remove(p);
		else
			System.out.println("not instance of sushi protein");
	}
	
	@Override
	public void changeBase(Base b)
	{
		if(b instanceof SushiBase)
			nameOfBase = b;
	}
	
	@Override
	public void addTopping(Topping pt)
	{
		if(pt instanceof SushiTopping)
			toppings.add(pt);
	}
	
	@Override
	public void removeTopping(Topping pt)
	{
		if(pt instanceof SushiTopping)
			toppings.remove(pt);
	}
	
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
