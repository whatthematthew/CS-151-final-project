package controller;

public class BaseSelectedMessage implements Message 
{

	private int baseIndex;
	private String name;
	
	public BaseSelectedMessage(int i, String n) 
	{
		baseIndex = i;
		name = n;
	}

	public int getIndex()
	{
		return baseIndex;
	}
	
	public String getName()
	{
		return name;
	}
}
