package model;

import javax.swing.ImageIcon;

public class SushiTopping implements Topping
{
	String toppingName;
	double toppingPrice;
	ImageIcon toppingPicture;
	
	public SushiTopping(String n, double p, ImageIcon picture)
	{
		toppingName = n;
		toppingPrice = p;
		toppingPicture = picture;
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