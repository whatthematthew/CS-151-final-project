package model;

import javax.swing.ImageIcon;

public class TeaTopping implements Topping 
{
	String toppingName;
	double toppingPrice;
	ImageIcon toppingPicture;
	
	public TeaTopping(String n, double p)
	{
		toppingName = n;
		toppingPrice = p;
	}
	
	@Override
	public double getPrice() 
	{
		return toppingPrice;
	}

	@Override
	public String getName() 
	{
		return toppingName;
	}

	@Override
	public Object clone()
	{
		TeaTopping clone = null;
		
		try {
			clone = (TeaTopping) super.clone();
		} catch (CloneNotSupportedException e) {
			
		}
		
		return clone;
	}

	@Override
	public ImageIcon getIcon() 
	{
		return toppingPicture;
	}
}
