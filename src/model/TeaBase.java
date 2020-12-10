package model;

import javax.swing.ImageIcon;

public class TeaBase implements Base
{
	private String baseName;
	private ImageIcon basePicture;
	
	public TeaBase(String name)
	{
		baseName = name;
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
