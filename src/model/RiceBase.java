package model;

import javax.swing.ImageIcon;
/**
 * @author Juan , Matthew, Lila
 *This class will implement Rice base and pictures
 */
public class RiceBase implements Base {

	private String baseName;
	private ImageIcon basePicture;
	/**
	 * construct rice base name
	 * @param name of base
	 */
	public RiceBase(String name)
	{
		baseName = name;
	}
	/**
	 * construct base name with picture
	 * @param name of base
	 * @param picture of base
	 */
	public RiceBase(String name, ImageIcon picture)
	{
		baseName = name;
		basePicture = picture;
	}
	/**
	 * returns the name
	 */
	@Override
	public String getName() 
	{
		return baseName;
	}
	/**
	 * returns the picture
	 */
	@Override
	public ImageIcon getIcon() 
	{
		return basePicture;
	}
}
