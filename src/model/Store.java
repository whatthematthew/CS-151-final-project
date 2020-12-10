package model;

import java.util.ArrayList;

import view.*;

public class Store 
{
	//Model class is MVC pattern
	private AllIngredients ai;
	private PresetOrders po;
	
	//List of stored orders
	private ArrayList<OrderType> allOrders = new ArrayList<>();
	private int orderCounter = -1;
	private int editCounter;
	
	//List of items related to Poke Bowls
	private ArrayList<PokeBase> pb;
	private ArrayList<PokeProtein> pp;
	private ArrayList<PokeTopping> pt;
	private ArrayList<PokeBowl> pbo;
	
	//List of items related to Noodles
	private ArrayList<NoodleBase> nb;
	private ArrayList<NoodleProtein> np;
	private ArrayList<NoodleTopping> nt;
	private ArrayList<Noodles> nbo;
	
	//List of items related to Sushi
	private ArrayList<SushiBase> sb;
	private ArrayList<SushiProtein> sp;
	private ArrayList<SushiTopping> st;
	private ArrayList<Sushi> sbo;
	
	//List of items related to Milk Tea
	private ArrayList<TeaBase> tb;
	private ArrayList<TeaTopping> tt;
	
	
	public Store(AllIngredients a, PresetOrders p)
	{
		ai = a;
		po = p;
	}
	
	public void attach()
	{	
		pb = ai.getPokeBase();
		pp = ai.getPokeProtein();
		pt = ai.getPokeTopping();
		pbo = po.getPokeBowlOrders();
		
		nb = ai.getNoodleBase();
		np = ai.getNoodleProtein();
		nt = ai.getNoodleTopping();
		nbo = po.getNoodleOrders();
		
		sb = ai.getSushiBase();
		sp = ai.getSushiProtein();
		st = ai.getSushiTopping();
		sbo = po.getSushiOrders();
		
		tb = ai.getMilkTeaBase();
		tt = ai.getMilkTeaTopping();
	}
	
	public ArrayList<OrderType> getAllOrders()
	{
		return allOrders;
	}
	
	public int getCurrentOrderIndex()
	{
		return orderCounter;
	}
	
	public void addNewOrder(OrderType ot)
	{
		orderCounter++;
		allOrders.add(ot);
	}
	
	public void changeBase(int i, Base b)
	{
		allOrders.get(i).changeBase(b);
	}
	
	public void addProtein(int i, Protein p)
	{
		allOrders.get(i).addProtein(p);
	}
	
	public void addToppings(int i, Topping t)
	{
		allOrders.get(i).addTopping(t);
	}
	
	public ArrayList<PokeBase> getPokeBase()
	{
		return pb;
	}
	
	public ArrayList<PokeProtein> getPokeProtein()
	{
		return pp;
	}
	
	public ArrayList<PokeTopping> getPokeTopping()
	{
		return pt;
	}
	
	public ArrayList<PokeBowl> getPokeBowlOrders()
	{
		return pbo;
	}
	
	public ArrayList<NoodleBase> getNoodleBase()
	{
		return nb;
	}
	
	public ArrayList<NoodleProtein> getNoodleProtein()
	{
		return np;
	}
	
	public ArrayList<NoodleTopping> getNoodleTopping()
	{
		return nt;
	}
	
	public ArrayList<Noodles> getNoodleOrders()
	{
		return nbo;
	}
	
	public ArrayList<SushiBase> getSushiBase()
	{
		return sb;
	}
	
	public ArrayList<SushiProtein> getSushiProtein()
	{
		return sp;
	}
	
	public ArrayList<SushiTopping> getSushiTopping()
	{
		return st;
	}
	
	public ArrayList<Sushi> getSushiOrders()
	{
		return sbo;
	}
	
	public ArrayList<TeaBase> getMilkTeaBase()
	{
		return tb;
	}
	
	public ArrayList<TeaTopping> getMilkTeaTopping()
	{
		return tt;
	}
}
