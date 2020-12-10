package model;

import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.ImageIcon;

public class AllIngredients 
{
	//Class used to store offered toppings and bases
	
	//Poke Bowls section
	
	//Base for Poke Bowls
	PokeBase whiteRice = new PokeBase("White Rice", new ImageIcon("rice.png"));
	PokeBase brownRice = new PokeBase("Brown Rice");
	PokeBase veggies = new PokeBase("Fresh Veggies");
	
	//Proteins for Poke Bowls
	PokeProtein salmon = new PokeProtein("Salmon", new ImageIcon("salmon.JPG"));
	PokeProtein spicySalmon = new PokeProtein("Spicy Salmon", new ImageIcon("salmon.JPG"));
	PokeProtein tuna = new PokeProtein("Tuna", new ImageIcon("tuna.PNG"));
	PokeProtein spicyTuna = new PokeProtein("Spicy Tuna", new ImageIcon("tuna.PNG"));
	PokeProtein mackerel = new PokeProtein("Mackerel", new ImageIcon("mackerel.PNG"));
	PokeProtein octopus = new PokeProtein("Octopus", new ImageIcon("octopus.PNG"));
	PokeProtein scallop = new PokeProtein("Scallop", new ImageIcon("scallop.PNG"));
	
	//Toppings for Poke Bowls
	PokeTopping edamame = new PokeTopping("Edamame", 0.25, new ImageIcon("edamame.PNG"));
	PokeTopping avocado = new PokeTopping("Avocado", 2.75, new ImageIcon("avocado.PNG"));
	PokeTopping seaweedSalad = new PokeTopping("Seaweed Salad", .75, new ImageIcon("seaweedsalad.PNG"));
	PokeTopping corn = new PokeTopping("Corn", 0.25, new ImageIcon("corn.PNG"));
	PokeTopping cilantro = new PokeTopping("Cilantro",0.25, new ImageIcon("cilantro.PNG"));
	PokeTopping kale = new PokeTopping("Kale", 0.25,new ImageIcon("kale.PNG"));
	PokeTopping cucumber = new PokeTopping("Cucumber", 0.25, new ImageIcon("cucumber.PNG"));
	PokeTopping greenOnion = new PokeTopping("Green Onion", 0.25, new ImageIcon("greenOnion.PNG"));
	PokeTopping sesameOil = new PokeTopping("Sesame Oil", 0.25, new ImageIcon("sesameoil.PNG"));
	PokeTopping ponzu = new PokeTopping("Ponzu", 0.25, new ImageIcon("ponzu.PNG"));
	PokeTopping spicyMayo = new PokeTopping("Spicy Mayo", 0.25, new ImageIcon("spicymayo.PNG"));
	PokeTopping sweetChili = new PokeTopping("Sweet Chili", 0.25, new ImageIcon("sweetchili.PNG"));
	PokeTopping sriracha = new PokeTopping("Sriracha", 0.25, new ImageIcon("sriracha.PNG"));
	PokeTopping soySauce = new PokeTopping("Soy Sauce", 0.25, new ImageIcon("soysauce.PNG"));

	//Base for Noodles
	NoodleBase eggNoodle = new NoodleBase("Egg Noodle", new ImageIcon("noodles.PNG"));
	NoodleBase ramenNoodle = new NoodleBase("Ramen Noodle", new ImageIcon("noodles.PNG"));
	NoodleBase udonNoodle = new NoodleBase("Udon Noodle", new ImageIcon("noodles.PNG"));
	NoodleBase riceNoodle = new NoodleBase("Rice Noodle", new ImageIcon("noodles.PNG"));
	
	//Protein for Noodles
	NoodleProtein chicken = new NoodleProtein("Chicken", new ImageIcon("chicken.PNG"));
	NoodleProtein pork = new NoodleProtein("Pork", new ImageIcon("pork.PNG"));
	NoodleProtein beef = new NoodleProtein("Beef", new ImageIcon("beef.PNG"));
	NoodleProtein shrimp = new NoodleProtein("Shrimp", new ImageIcon("shrimp.PNG"));
	NoodleProtein mackerel0 = new NoodleProtein("Mackerel", new ImageIcon("mackerel.PNG"));
	NoodleProtein tofu = new NoodleProtein("Tofu", new ImageIcon("tofu.PNG"));
	
	//Toppings for Noodles
	NoodleTopping egg = new NoodleTopping("Egg", 1, new ImageIcon("egg.PNG"));
	NoodleTopping mushroom = new NoodleTopping("Mushroom", 0.25, new ImageIcon("mushroom.PNG"));
	NoodleTopping edamame0 = new NoodleTopping("Edamame", 0.25, new ImageIcon("edamame.PNG"));
	NoodleTopping corn0 = new NoodleTopping("Corn", 0.25, new ImageIcon("corn.PNG"));
	NoodleTopping carrot = new NoodleTopping("Carrot", 0.25, new ImageIcon("carrot.PNG"));
	NoodleTopping cilantro0 = new NoodleTopping("Cilantro", 0.25, new ImageIcon("cilantro.PNG"));
	NoodleTopping greenOnion0 = new NoodleTopping("Green Onion", 0.25, new ImageIcon("greenonion.PNG"));
	NoodleTopping sriracha0 = new NoodleTopping("Sriracha", 0.25, new ImageIcon("sriracha.PNG"));
	NoodleTopping sesameOil0 = new NoodleTopping("Sesame Oil", 0.25, new ImageIcon("sesameoil.PNG"));
	NoodleTopping soyTopping0 = new NoodleTopping("Soy Topping", 0.25, new ImageIcon("soyTopping.PNG"));
	NoodleTopping sweetChili0 = new NoodleTopping("Sweet Chili", 0.25, new ImageIcon("sweetchili.PNG"));
	NoodleTopping seaweedSalad0 = new NoodleTopping("Seaweed Salad", 0.75, new ImageIcon("seaweedsalad.PNG"));
	NoodleTopping cucumber0 = new NoodleTopping("Cucumber", 0.25, new ImageIcon("cucumber.PNG"));
	NoodleTopping sweetPotatoes0 = new NoodleTopping("Sweet Potatoes", 0.25, new ImageIcon("sweetpotato.PNG"));
	NoodleTopping kimchi = new NoodleTopping("Kimchi", 0.25, new ImageIcon("kimchi.PNG"));
	NoodleTopping avocado0 = new NoodleTopping("Avocado", 2.75, new ImageIcon("avocado.PNG"));
	NoodleTopping crispyOnion = new NoodleTopping("Crispy Onion", 0.25, new ImageIcon("crispyonion.PNG"));
	NoodleTopping furikake = new NoodleTopping("Furikake", 0.25, new ImageIcon("furikake.PNG"));
	NoodleTopping sesameSeeds = new NoodleTopping("Sesame Seeds", 0.25, new ImageIcon("sesameseed.PNG"));
	
	//Base for Sushi
	SushiBase whiteRice0 = new SushiBase("White Rice", new ImageIcon("rice.png"));
	
	//Protein for Sushi
	SushiProtein tuna0 = new SushiProtein("Tuna", new ImageIcon("tuna.PNG"));
	SushiProtein salmon0 = new SushiProtein("Salmon", new ImageIcon("salmon2.PNG"));
	SushiProtein mackerel1 = new SushiProtein("Mackerel", new ImageIcon("mackerel.PNG"));
	SushiProtein octopus0 = new SushiProtein("Octopus", new ImageIcon("octopus.PNG"));
	SushiProtein scallop0 = new SushiProtein("Scallop", new ImageIcon("scallop.PNG"));
	SushiProtein shrimp0 = new SushiProtein("Shrimp", new ImageIcon("shrimp.PNG"));
	SushiProtein albacore = new SushiProtein("Albacore", new ImageIcon("albacore.PNG"));
	SushiProtein sardine = new SushiProtein("Sardine", new ImageIcon("sardine.PNG"));
	SushiProtein uni = new SushiProtein("Uni", new ImageIcon("uni.PNG"));
	SushiProtein cod = new SushiProtein("Cod", new ImageIcon("cod.PNG"));
	SushiProtein crabImitation = new SushiProtein("Crab Imitation", new ImageIcon("crabimitation.PNG"));
	
	//Topping for Sushi
	SushiTopping avocado1 = new SushiTopping("Avocado", 2.75, new ImageIcon("avocado.PNG"));
	SushiTopping mushroom0 = new SushiTopping("Mushroom", 0.25, new ImageIcon("mushroom.PNG"));
	SushiTopping egg0 = new SushiTopping("Egg", 1, new ImageIcon("egg.PNG"));
	SushiTopping cucumber1 = new SushiTopping("Cucumber", 0.25, new ImageIcon("cucumber.PNG"));
	SushiTopping soyTopping = new SushiTopping("Soy Sauce", 0.25, new ImageIcon("soysauce.PNG"));
	SushiTopping spicyMayo0 = new SushiTopping("Spicy Mayo", 0.25, new ImageIcon("spicymayo.PNG"));
	SushiTopping sweetChili1 = new SushiTopping("Sweet Chili", 0.25, new ImageIcon("sweetchili.PNG"));
	SushiTopping edamame1 = new SushiTopping("Edamame", 0.25, new ImageIcon("edamame.PNG"));
	SushiTopping ginger = new SushiTopping("Ginger", 0.25, new ImageIcon("ginger.PNG"));
	SushiTopping wasabi = new SushiTopping("Wasabi", 0.25, new ImageIcon("wasabi.PNG"));
	SushiTopping seaweedSalad1 = new SushiTopping("Seaweed Salad", 0.25, new ImageIcon("seaweedsalad.PNG"));	
	
	//Milk Tea section
	
	//Base for Milk Tea
	TeaBase blackTea = new TeaBase("Black Tea");
	TeaBase oolongTea = new TeaBase("Oolong Tea");
	
	//Toppings for Milk Tea
	TeaTopping boba = new TeaTopping("Boba", 1);
	TeaTopping grassJelly = new TeaTopping("Grass Jelly", 1);
	
	ArrayList<String> ot = new ArrayList<>(Arrays.asList("Food", "Drink"));
	
	ArrayList<PokeBase> pb = new ArrayList<>(Arrays.asList(whiteRice, brownRice, veggies));
	ArrayList<PokeProtein> pp = new ArrayList<>(Arrays.asList(salmon, spicySalmon, tuna, spicyTuna, mackerel, octopus, scallop));
	ArrayList<PokeTopping> pt = new ArrayList<>(Arrays.asList(edamame, seaweedSalad, corn, cilantro, kale, cucumber, greenOnion, sesameOil, ponzu, spicyMayo, sweetChili, sriracha, soySauce));
	
	ArrayList<NoodleBase> nb = new ArrayList<>(Arrays.asList(eggNoodle, ramenNoodle, udonNoodle, riceNoodle));
	ArrayList<NoodleProtein> np = new ArrayList<>(Arrays.asList(chicken, pork, beef, shrimp, mackerel0, tofu));
	ArrayList<NoodleTopping> nt = new ArrayList<>(Arrays.asList(egg, mushroom, edamame0, corn0, carrot, cilantro0, greenOnion0, sriracha0, sesameOil0, soyTopping0, sweetChili0, seaweedSalad0, cucumber0, sweetPotatoes0, kimchi, avocado0, crispyOnion, furikake, sesameSeeds));
	
	ArrayList<SushiBase> sb = new ArrayList<>(Arrays.asList(whiteRice0));
	ArrayList<SushiProtein> sp = new ArrayList<>(Arrays.asList(tuna0, salmon0, mackerel1, octopus0, scallop0, shrimp0, albacore, sardine, uni, cod, crabImitation));
	ArrayList<SushiTopping> st = new ArrayList<>(Arrays.asList(avocado1, mushroom0, egg0, cucumber1, soyTopping, spicyMayo0, sweetChili1, edamame1, ginger, wasabi, seaweedSalad1));
	
	ArrayList<TeaBase> tb = new ArrayList<>(Arrays.asList(blackTea, oolongTea));
	ArrayList<TeaTopping> tt = new ArrayList<>(Arrays.asList(boba, grassJelly));

	
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
	
	public ArrayList<TeaBase> getMilkTeaBase()
	{
		return tb;
	}
	
	public ArrayList<TeaTopping> getMilkTeaTopping()
	{
		return tt;
	}
}
