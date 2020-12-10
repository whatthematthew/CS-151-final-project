package model;

import javax.swing.ImageIcon;

public class SushiBase implements Base 
{
	private String baseName;
	private ImageIcon basePicture;
	
	public SushiBase(String name)
	{
		baseName = name;
	}
	
	public SushiBase(String name, ImageIcon picture)
	{
		baseName = name;
		basePicture = picture;
	}
	
	@Override
	public String getName() 
	{
		return baseName;
	}

	@Override
	public ImageIcon getIcon() 
	{
		return basePicture;
	}
}