package controller;

public class ProteinSelectedMessage implements Message
{
	int proteinIndex;
	String name;
	
	public ProteinSelectedMessage(int i, String n)
	{
		proteinIndex = i;
		name = n;
	}
	
	public int getIndex()
	{
		return proteinIndex;
	}
	
	public String getName()
	{
		return name;
	}
}
