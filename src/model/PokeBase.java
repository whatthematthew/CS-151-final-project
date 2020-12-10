package model;

import javax.swing.ImageIcon;
/**
 * @author matthew, Lila, Juan
 *gets the name, image, and price.
 */
public class PokeBase implements Base
{
	private String baseName;
	private ImageIcon basePicture;
	
	/**
	 * contructor for Poke Base
	 * @param name of poke base
	 */
	public PokeBase(String name)
	{
		baseName = name;
	}
	/**
	 * constructor with name and picture
	 * @param name of Poke Base
	 * @param picture of Poke Base
	 */
	public PokeBase(String name, ImageIcon picture)
	{
		baseName = name;
		basePicture = picture;
	}
	/**
	 * returns the name of Poke Base 
	 */
	@Override
	public String getName() 
	{
		return baseName;
	}
	/**
	 * returns Poke Base picture
	 */
	@Override
	public ImageIcon getIcon() 
	{
		return basePicture;
	}
}
