package model;

import java.awt.Image;

import javax.swing.ImageIcon;

public class RiceProtein implements Protein
{
	String proteinName;
	double proteinPrice;
	ImageIcon proteinPicture;
	
	public RiceProtein(String name)
	{
		proteinName = name;
		proteinPrice = 1;
	}
	
	public RiceProtein(String name, ImageIcon picture)
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
