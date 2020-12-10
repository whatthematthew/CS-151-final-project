package model;

import javax.swing.ImageIcon;

public class SushiProtein implements Protein
{
	String proteinName;
	double proteinPrice;
	ImageIcon proteinPicture;
	
	public SushiProtein(String name)
	{
		proteinName = name;
		proteinPrice = 1;
	}
	
	public SushiProtein(String name, ImageIcon picture)
	{
		proteinName = name;
		proteinPrice = 1;
		proteinPicture = picture;
	}
	
	@Override
	public String getName() 
	{
		return proteinName;
	}
	
	@Override
	public double getPrice() 
	{
		return proteinPrice;
	}
	
	@Override
	public String toString()
	{
		return getName();
	}

	@Override
	public ImageIcon getIcon() 
	{
		return proteinPicture;
	}
}
