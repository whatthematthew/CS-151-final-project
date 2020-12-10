package model;

import javax.swing.ImageIcon;
/**
 * @author Lila, Juan, Matthew
 *Noodle topping name, image, and price.
 */
public class NoodleTopping implements Topping
{
	String toppingName;
	double toppingPrice;
	ImageIcon toppingPicture;
	/**
	 * constructor for noodle topping
	 * @param name of the topping
	 * @param price of the topping
	 */
	public NoodleTopping(String name, double price)
	{
		toppingName = name;
		toppingPrice = price;
	}
	/**
	 * Noodle constructor for name, price, and picture
	 * @param name of topping
	 * @param price of topping
	 * @param picture of topping
	 */
	public NoodleTopping(String name, double price, ImageIcon picture)
	{
		toppingName = name;
		toppingPrice = price;
		toppingPicture = picture;
	}
	/**
	 * gets the name of topping
	 */
	@Override
	public String getName()
	{
		return toppingName;
	}
	
	/**
	 * returns the price of the topping
	 */
	@Override
	public double getPrice() 
	{
		return toppingPrice;
	}
	/**
	 * returns the picture
	 */
	@Override
	public ImageIcon getIcon() 
	{
		return toppingPicture;
	}
}
