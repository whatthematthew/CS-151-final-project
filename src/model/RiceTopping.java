package model;

import javax.swing.ImageIcon;

public class RiceTopping implements Topping 
{

	String toppingName;
	double toppingPrice;
	ImageIcon toppingPicture;
	
	public RiceTopping(String n, double p)
	{
		toppingName = n;
		toppingPrice = p;
	}
	
	@Override
	public String getName()
	{
		return toppingName;
	}
	
	@Override
	public double getPrice() 
	{
		return toppingPrice;
	}

	@Override
	public ImageIcon getIcon() 
	{
		return toppingPicture;
	}
}
