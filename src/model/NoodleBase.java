package model;

import javax.swing.ImageIcon;
/**
 * @author matthew, juan, lila
 * This class focuses on Noodles (image, noodle, price, name)
 */
public class NoodleBase implements Base 
{

	private String baseName;
	private ImageIcon basePicture;
	
	/**
	 * type of noodle base
	 * @param name accepts a string for noodle type
	 */
	public NoodleBase(String name)
	{
		baseName = name;
	}
	/**
	 * Type of noodle with a picture
	 * @param name name of noodle type
	 * @param picture of noodle
	 */
	public NoodleBase(String name, ImageIcon picture)
	{
		baseName = name;
		basePicture = picture;
	}
	/**
	 * @return gets the name of the noodle
	 */
	@Override
	public String getName() 
	{
		return baseName;
	}

	/**
	 * gets the image of the picture
	 */
	@Override
	public ImageIcon getIcon() 
	{
		return basePicture;
	}
}
