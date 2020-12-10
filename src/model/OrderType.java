package model;

public interface OrderType extends Cloneable
{
	String getName();
	void changeBase(Base b);
	void addProtein(Protein p);
	void removeProtein(Protein p);
	void addTopping(Topping t);
	void removeTopping(Topping t);
	double getPrice();
}
