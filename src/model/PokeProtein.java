package model;
import javax.swing.ImageIcon;
/**
 * @author matthew, juan, Lila
 * This class is for poke proteins and images.
 */
public class PokeProtein implements Protein
{
	String proteinName;
	double proteinPrice;
	ImageIcon proteinPicture;
	/**
	 * constructor for poke protein
	 * @param name of protein
	 * @param picture of protein
	 */
	public PokeProtein(String name, ImageIcon picture)
	{
		proteinName = name;
		proteinPicture = picture;
		proteinPrice = 1;
	}
	
	/**
	 * gets the name of the protein
	 */
	@Override
	public String getName() 
	{
		return proteinName;
	}
	
	/**
	 * returns the price 
	 */
	@Override
	public double getPrice() 
	{
		return proteinPrice;
	}
	/**
	 * returns the name 
	 */
	@Override
	public String toString()
	{
		return getName();
	}

	/**
	 * returns the picture.
	 */
	@Override
	public ImageIcon getIcon() 
	{
		return proteinPicture;
	}
}
