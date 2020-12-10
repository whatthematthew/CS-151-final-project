package controller;

import model.*;
import view.GUI;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

import javax.swing.JCheckBox;
import javax.swing.JRadioButton;

public class Controller 
{
	private BlockingQueue<Message> queue;
	private GUI view;
	private Store model;
	
	private List<Valve> valves = new LinkedList<>();
	
	//variable needed to access order in model
	private int current;
	
	//variables needed to access base in model
	private int selectedBaseIndex;
	private Base selectedBase;
	private ArrayList<JRadioButton> base;
	
	//variable needed to access protein in model
	private int selectedProteinIndex;
	private Protein selectedProtein;
	private ArrayList<JCheckBox> protein;
	
	//variables needed to access topping in model
	private int selectedToppingIndex;
	private Topping selectedTopping;
	private ArrayList<JCheckBox> topping;
	
	public Controller(GUI view, Store model, BlockingQueue<Message> queue)
	{
		this.view = view;
		this.model = model;
		this.queue = queue;
		initialize();
	}
	
	private void initialize()
	{
		valves.add(new StartApplication());
		valves.add(new ContinueApplication());
		valves.add(new DoNewCVMValve());
		valves.add(new DoNewFoodOrder());
		valves.add(new DoNewPokeOrder());
		valves.add(new DoNewNoodleOrder());
		valves.add(new DoNewSushiOrder());
		valves.add(new DoNewCustomPokeBowl());
		valves.add(new DoNewCustomNoodles());
		valves.add(new DoNewCustomSushi());
		valves.add(new AddBase());
		valves.add(new AddProtein());
		valves.add(new ProteinDone());
		valves.add(new AddTopping());
		valves.add(new Restart());
		valves.add(new Previous());
	}
	
	public void mainLoop()
	{
		ValveResponse response = ValveResponse.EXECUTED;
		Message message = null;
		while(response != ValveResponse.FINISH)
		{
			try {
				message = queue.take();
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
			
			for(Valve valve: valves)
			{
				response = valve.execute(message);
				if(response != ValveResponse.MISS)
					break;
			}
		}
	}
	
	private void updateCVM()
	{
		
	}
	
	private interface Valve
	{
		public ValveResponse execute(Message message);
	}
	
	private class StartApplication implements Valve
	{
		@Override
		public ValveResponse execute(Message message) 
		{
			if(message.getClass() != StartedApplicationMessage.class)
				return ValveResponse.MISS;
			
			
			view.update(Page.START);
			
			return ValveResponse.EXECUTED;
		}
	}
	
	private class ContinueApplication implements Valve
	{
		@Override
		public ValveResponse execute(Message message) 
		{
			if(message.getClass() != ApplicationContinuedMessage.class)
				return ValveResponse.MISS;
			
			view.update(Page.HOME);
			
			return ValveResponse.EXECUTED;
		}
	}
	
	private class DoNewCVMValve implements Valve
	{
		@Override
        public ValveResponse execute(Message message) 
		{
            if (message.getClass() != NewCVMMessage.class) 
            	return ValveResponse.MISS;
            // otherwise it means that it is a NewGameMessage message
            
            // actions in Model
            
            model.attach();
            
            // actions in View
            //view.initialize();
            view.update(Page.SELECT_ORDER);
            
            return ValveResponse.EXECUTED;
        }
	}
	
	private class DoNewFoodOrder implements Valve
	{
		@Override
		public ValveResponse execute(Message message) 
		{
			if(message.getClass() != FoodOrderStartedMessage.class)
            	return ValveResponse.MISS;

			// otherwise it means that it is a NewGameMessage message
            
			// actions in Model
			
			
            // actions in View
			view.update(Page.SELECT_TYPE);
			
            return ValveResponse.EXECUTED;
		}
		
	}
	
	private class DoNewPokeOrder implements Valve
	{
		@Override
		public ValveResponse execute(Message message) 
		{
			if(message.getClass() != PokeBowlStartedMessage.class)
            	return ValveResponse.MISS;
			
            // actions in View
			view.update(Page.SELECT_CHOICE);
			
            return ValveResponse.EXECUTED;
		}
		
	}
	
	private class DoNewNoodleOrder implements Valve
	{
		@Override
		public ValveResponse execute(Message message) 
		{
			if(message.getClass() != NoodleStartedMessage.class)
            	return ValveResponse.MISS;
			
            // actions in View
			view.update(Page.SELECT_CHOICE);
			
            return ValveResponse.EXECUTED;
		}
		
	}
	
	private class DoNewSushiOrder implements Valve
	{
		@Override
		public ValveResponse execute(Message message) 
		{
			if(message.getClass() != SushiStartedMessage.class)
            	return ValveResponse.MISS;
			
            // actions in View
			view.update(Page.SELECT_CHOICE);
			
            return ValveResponse.EXECUTED;
		}
		
	}
	
	private class DoNewCustomPokeBowl implements Valve
	{

		@Override
		public ValveResponse execute(Message message) 
		{
			if(message.getClass() != CustomPokeBowlMessage.class)
            	return ValveResponse.MISS;

			// actions in Model
			model.addNewOrder(new PokeBowl());
			
            // actions in View
			view.update(Page.SELECT_BASE);
			
            return ValveResponse.EXECUTED;
		}
		
	}
	
	private class DoNewCustomNoodles implements Valve
	{

		@Override
		public ValveResponse execute(Message message) 
		{
			if(message.getClass() != CustomNoodleMessage.class)
            	return ValveResponse.MISS;
            
			// actions in Model
			model.addNewOrder(new Noodles());
			
            // actions in View
			view.update(Page.SELECT_BASE);
			
            return ValveResponse.EXECUTED;
		}
	}
	
	private class DoNewCustomSushi implements Valve
	{

		@Override
		public ValveResponse execute(Message message) 
		{
			if(message.getClass() != CustomSushiMessage.class)
            	return ValveResponse.MISS;
            
			// actions in Model
			model.addNewOrder(new Sushi());
			
            // actions in View
			view.update(Page.SELECT_BASE);
			
            return ValveResponse.EXECUTED;
		}
	}
	
	private class AddBase implements Valve
	{
		@Override
		public ValveResponse execute(Message message) 
		{
			if(message.getClass() != BaseSelectedMessage.class)
            	return ValveResponse.MISS;

			BaseSelectedMessage bsm = (BaseSelectedMessage) message;
            
			// actions in Model
			current = model.getCurrentOrderIndex();
			base = view.getBase();
			
			for(JRadioButton b: base)
				if(b.isSelected())
					selectedBaseIndex = base.indexOf(b);
			
			if(bsm.getName().equals("Poke"))
				selectedBase = model.getPokeBase().get(selectedBaseIndex);
			if(bsm.getName().equals("Noodles"))
				selectedBase = model.getNoodleBase().get(selectedBaseIndex);
			if(bsm.getName().equals("Sushi"))
				selectedBase = model.getSushiBase().get(selectedBaseIndex);
			
			model.changeBase(current, selectedBase);
			base.clear();
			
            // actions in View
			view.update(Page.SELECT_PROTEINS);
			
            return ValveResponse.EXECUTED;
		}
	}
	
	private class AddProtein implements Valve
	{
		@Override
		public ValveResponse execute(Message message) 
		{
			if(message.getClass() != ProteinSelectedMessage.class)
            	return ValveResponse.MISS;
			
			// actions in Model
			ProteinSelectedMessage ppsm = (ProteinSelectedMessage) message;
			
			selectedProteinIndex = ppsm.getIndex();
			current = model.getCurrentOrderIndex();
			protein = view.getProtein();
			
			if(ppsm.getName().equals("Poke"))
				selectedProtein = model.getPokeProtein().get(selectedProteinIndex);
			if(ppsm.getName().equals("Noodles"))
				selectedProtein = model.getNoodleProtein().get(selectedProteinIndex);
			if(ppsm.getName().equals("Sushi"))
				selectedProtein = model.getSushiProtein().get(selectedProteinIndex);
			
			model.addProtein(current, selectedProtein);
			
            return ValveResponse.EXECUTED;
		}
	}
	
	private class ProteinDone implements Valve
	{

		@Override
		public ValveResponse execute(Message message) 
		{
			if(message.getClass() != ProteinCompletedMessage.class)
            	return ValveResponse.MISS;
			
			// actions in View
			view.update(Page.SELECT_TOPPINGS);
			
			return ValveResponse.EXECUTED;
		}
		
	}
	
	private class AddTopping implements Valve
	{
		@Override
		public ValveResponse execute(Message message) 
		{
			if(message.getClass() != ToppingSelectedMessage.class)
            	return ValveResponse.MISS;

			// actions in Model
			ToppingSelectedMessage ptsm = (ToppingSelectedMessage) message;
			
			selectedToppingIndex = ptsm.getIndex();
			current = model.getCurrentOrderIndex();
			topping = view.getTopping();
			
			if(ptsm.getName().equals("Poke"))
				selectedTopping = model.getPokeTopping().get(selectedToppingIndex);
			if(ptsm.getName().equals("Noodles"))
				selectedTopping = model.getNoodleTopping().get(selectedToppingIndex);
			if(ptsm.getName().equals("Sushi"))
				selectedTopping = model.getSushiTopping().get(selectedToppingIndex);
			
			model.addToppings(current, selectedTopping);
			
            return ValveResponse.EXECUTED;
		}
	}
	
	private class Previous implements Valve
	{
		
		@Override
		public ValveResponse execute(Message message) 
		{
			if(message.getClass() != ReturnToPreviousMessage.class)
            	return ValveResponse.MISS;
			
			ReturnToPreviousMessage rtpm = (ReturnToPreviousMessage) message;
			
			if(rtpm.getCurrentPage() == Page.SELECT_TOPPINGS)
				view.update(Page.SELECT_PROTEINS);
			if(rtpm.getCurrentPage() == Page.SELECT_PROTEINS)
				view.update(Page.SELECT_BASE);
			if(rtpm.getCurrentPage() == Page.SELECT_BASE)
				view.update(Page.SELECT_CHOICE);
			if(rtpm.getCurrentPage() == Page.SELECT_CHOICE)
				view.update(Page.SELECT_TYPE);
			if(rtpm.getCurrentPage() == Page.SELECT_TYPE)
				view.update(Page.SELECT_ORDER);
			
			return ValveResponse.EXECUTED;
		}
		
	}
	
	private class Restart implements Valve
	{

		@Override
		public ValveResponse execute(Message message) 
		{
			if(message.getClass() != RestartMessage.class)
            	return ValveResponse.MISS;
			
			RestartMessage rm = (RestartMessage) message;
			
			// actions in View
			if(rm.getStatus())
			{			
				view.addToList(model.getAllOrders().get(current), current);
				view.update(Page.RESTART);
			}
			else
				view.update(Page.CANCEL);
			
			return ValveResponse.EXECUTED;
		}
		
	}
}
