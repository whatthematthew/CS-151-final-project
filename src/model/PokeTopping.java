package model;

import javax.swing.ImageIcon;
/**
 * @author matthew, Juan, Lila
 * this class is for setting up the picture, image, price, and name
 */
public class PokeTopping implements Topping
{
	String toppingName;
	double toppingPrice;
	ImageIcon toppingPicture;
	/**
	 * constructs poke topping
	 * @param n name of topping
	 * @param p price of topping
	 */
	public PokeTopping(String n, double p)
	{
		toppingName = n;
		toppingPrice = p;
	}
	/**
	 * constructor for topping
	 * @param n name of topping	
	 * @param p price of topping
	 * @param picture of topping
	 */
	public PokeTopping(String n, double p, ImageIcon picture)
	{
		toppingName = n;
		toppingPicture = picture;
		toppingPrice = p;
	}
	
	/**
	 * returns the name of topping
	 */
	@Override
	public String getName()
	{
		return toppingName;
	}
	/**
	 * returns price
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
