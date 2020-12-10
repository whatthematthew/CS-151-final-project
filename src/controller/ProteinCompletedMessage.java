package controller;

public class ProteinCompletedMessage implements Message 
{
	private String name;
	
	public ProteinCompletedMessage(String n)
	{
		name = n;
	}
	
	public String getName()
	{
		return name;
	}
}
