package model;

import javax.swing.ImageIcon;
/**
 * @author Juan, Lila, Matthew
 *this class will focus on meat topping (picture, price, and name)
 */
public class NoodleProtein implements Protein 
{
	String proteinName;
	double proteinPrice;
	ImageIcon proteinPicture;
	
	/**
	 * sets the name of the meat
	 * @param accepts a name of the meat
	 */
	public NoodleProtein(String name)
	{
		proteinName = name;
		proteinPrice = 1;
	}
	/**
	 * sets the protein type and image
	 * @param name accepts a protein name
	 * @param picture accepts a picture
	 */
	public NoodleProtein(String name, ImageIcon picture)
	{
		proteinName = name;
		proteinPrice = 1;
		proteinPicture = picture;
	}
	
	/**
	 * @returns gets the name of the protein
	 */
	@Override
	public String getName() 
	{
		return proteinName;
	}
	/**
	 * @returns returns the price of the protein 
	 */
	@Override
	public double getPrice() 
	{
		return proteinPrice;
	}
	/**
	 * converts the type protein into a type string
	 */
	@Override
	public String toString()
	{
		return getName();
	}
/**
 * gets the icon of the meat
 */
	@Override
	public ImageIcon getIcon() 
	{
		return proteinPicture;
	}
}
