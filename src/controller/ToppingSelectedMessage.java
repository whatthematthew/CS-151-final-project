package controller;

public class ToppingSelectedMessage implements Message 
{
	int toppingIndex;
	String name;
	
	public ToppingSelectedMessage(int i, String n)
	{
		toppingIndex = i;
		name = n;
	}
	
	public int getIndex()
	{
		return toppingIndex;
	}
	
	public String getName()
	{
		return name;
	}
}
