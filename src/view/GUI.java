package view;

import model.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.BlockingQueue;
import javax.swing.*;
import controller.*;
import java.util.Iterator;

public class GUI extends JFrame
{
	//View of MVC model
	private BlockingQueue<Message> queue;
	
	private AllIngredients ai;
	private PresetOrders po;
	
	private Page currentPage;
	
	// MenuPage currentOrder;
	
	private GridBagConstraints c = new GridBagConstraints();
	
	//Swing components used in Home Page
	private JButton button1;
	
	//Swing components used in Start Page
	private JButton startButton;
	private JButton loginButton;
	private JButton button2;
	
	//Swing components used in Main Page
	private JButton previous = new JButton("Previous");
	private JButton next = new JButton("Next");
	private JButton save = new JButton("Save");
	private JButton cancel = new JButton("Cancel");
	private JButton edit = new JButton("Edit");
	private JButton delete = new JButton("Delete");
	
	//Swing components used in Order
	private JLabel currentMenuPage;
	
	private JRadioButton foodButton;
	private JRadioButton drinkButton;
	private ButtonGroup orderGroup;
	
	private ArrayList<JRadioButton> typeBoxes;
	private ButtonGroup typeGroup;
	
	private ArrayList<JRadioButton> choiceBoxes;
	private ButtonGroup choiceGroup;
	
	private ArrayList<JRadioButton> baseBoxes;
	private ButtonGroup baseGroup;
	
	private ArrayList<JCheckBox> proteinBoxes;
	private ArrayList<JCheckBox> toppingBoxes;
	
	private ArrayList<String> orderList;
	private ArrayList<String> orderPriceList;
	private JList<String> orderJList;
	private JList<String> orderJPriceList;
	private double allOrderPriceTotal;
	private DecimalFormat df = new DecimalFormat();
	
	private JPanel menu = new JPanel();
	
   // private JPanel orderTotal;
	private JLabel subtotal;
    private JLabel total;
    private JButton checkout;
    
    //color used for border
    private Color BrightGreen = new Color(102, 255, 0);
	
    public static GUI init(BlockingQueue<Message> queue)
    {
    	return new GUI(queue);
    }
	
	public GUI(BlockingQueue<Message> queue)
	{
		this.queue = queue;
		initialize();
		attach();
	}
	
	public void attach()
	{
		po = new PresetOrders();
		ai = new AllIngredients();
	}
	
	public void initialize()
	{
		//set frame up
		this.frameInit();
		setTitle("Customizable Vending Machine");
		setSize(500, 500);  
        setVisible(true);  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        
        save.setVisible(false);
        
        //set swing components used in home page up
        button1 = new JButton();
        button1.setIcon(new ImageIcon("vendingmachine5.PNG"));
        
        //set swing components used in Start Page
    	startButton = new JButton("Start");
    	loginButton = new JButton("Employee Login");
    	button2 = new JButton();
    	button2.setIcon(new ImageIcon("VendingMachine.PNG"));
        
    	//set swing components used in Main page
    	currentMenuPage = new JLabel();
    	
    	//set swing components used to choose food or drink
    	foodButton = new JRadioButton("Food");
    	drinkButton = new JRadioButton("Drink");
    	orderGroup = new ButtonGroup();
    	orderGroup.add(foodButton);
    	orderGroup.add(drinkButton);
    	
    	typeBoxes = new ArrayList<>();
    	typeGroup = new ButtonGroup();
    	
    	//set swing components used to choose specific type of food or drink
    	choiceBoxes = new ArrayList<>();
    	choiceGroup = new ButtonGroup();
    	
    	//set swing components used to choose a base for the type of food or drink
    	baseBoxes = new ArrayList<>();
    	baseGroup = new ButtonGroup();
    	
    	//set swing components used to choose proteins for food
    	proteinBoxes = new ArrayList<>();
    	
    	//set swing components used to choose toppings
    	toppingBoxes = new ArrayList<>();
    	
    	orderList = new ArrayList<>();
    	orderJList = new JList<>();
    	
    	orderPriceList = new ArrayList<>();
    	orderJPriceList = new JList<>();
    	
    	//orderTotal = new JPanel();
        subtotal = new JLabel("Subtotal: ");
        total = new JLabel("Total: ");
        checkout = new JButton("Checkout");
        checkout.setEnabled(false);
        previous.setEnabled(false);
        cancel.setEnabled(false);
        edit.setEnabled(false);
        delete.setEnabled(false);
    	
        df.setMaximumFractionDigits(2);
		df.setMinimumFractionDigits(2);
        
        actions();
        currentPage = Page.HOME;
        homePage();
	}
	
	private void actions()
	{
		button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				queue.add(new StartedApplicationMessage());
			}
			
		});
		
		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				//call action listener of startButton
				startButton.doClick();
			}
			
		});
		
		startButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				queue.add(new NewCVMMessage());
			}
			
		});
		
		foodButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				next.setEnabled(true);
				foodButton.setBorder(BorderFactory.createLineBorder(BrightGreen, 5));
				if(foodButton.isSelected())
				{
					drinkButton.setSelected(false);
					foodButton.setBorderPainted(true);
					drinkButton.setBorderPainted(false);
				}
			}
		
		});
		
		drinkButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				next.setEnabled(true);
				drinkButton.setBorder(BorderFactory.createLineBorder(BrightGreen, 5));
				if(drinkButton.isSelected())
				{
					foodButton.setSelected(false);
					drinkButton.setBorderPainted(true);
					foodButton.setBorderPainted(false);
				}
		}});
		
		previous.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				queue.add(new ReturnToPreviousMessage(currentPage));
			}
			
		});
		
		next.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				if(currentPage == Page.SELECT_ORDER)
				{
					if(foodButton.isSelected())
						queue.add(new FoodOrderStartedMessage());
					else
						queue.add(new DrinkOrderStartedMessage());
				}
				
				if(currentPage == Page.SELECT_TYPE)
				{
					if(foodButton.isSelected())
						for(JRadioButton tb: typeBoxes)
						{
							//System.out.println(tb.isSelected() + " " + tb.getText());
							if(tb.isSelected() && tb.getText().equals("Poke Bowl"))
								queue.add(new PokeBowlStartedMessage());
							if(tb.isSelected() && tb.getText().equals("Noodles"))
								queue.add(new NoodleStartedMessage());
							if(tb.isSelected() && tb.getText().equals("Sushi"))
								queue.add(new SushiStartedMessage());
						}
								
				}
				
				if(currentPage == Page.SELECT_CHOICE)
				{
					if(foodButton.isSelected())
						for(JRadioButton cb: choiceBoxes)
						{
							if(cb.isSelected() && cb.getText().equals("Custom Poke Bowl"))
								queue.add(new CustomPokeBowlMessage());
							if(cb.isSelected() && cb.getText().equals("Custom Noodles"))
								queue.add(new CustomNoodleMessage());
							if(cb.isSelected() && cb.getText().equals("Custom Sushi"))
								queue.add(new CustomSushiMessage());
						}
				}
				
				if(currentPage == Page.SELECT_BASE)
				{
					if(foodButton.isSelected())
						for(JRadioButton bb: baseBoxes)
						{
							if(bb.isSelected())
							{
								if(typeBoxes.get(0).isSelected())
									queue.add(new BaseSelectedMessage(baseBoxes.indexOf(bb), "Poke"));
								if(typeBoxes.get(1).isSelected())
									queue.add(new BaseSelectedMessage(baseBoxes.indexOf(bb), "Noodles"));
								if(typeBoxes.get(2).isSelected())
									queue.add(new BaseSelectedMessage(baseBoxes.indexOf(bb), "Sushi"));
								if(typeBoxes.get(3).isSelected())
									queue.add(new BaseSelectedMessage(baseBoxes.indexOf(bb), "Rice"));
							
							}
						}
				}
				
				if(currentPage == Page.SELECT_PROTEINS)
				{
					if(foodButton.isSelected())
						for(JCheckBox pp: proteinBoxes)
						{
							if(pp.isSelected())
							{
								if(typeBoxes.get(0).isSelected())
									queue.add(new ProteinSelectedMessage(proteinBoxes.indexOf(pp), "Poke"));
								if(typeBoxes.get(1).isSelected())
									queue.add(new ProteinSelectedMessage(proteinBoxes.indexOf(pp), "Noodles"));
								if(typeBoxes.get(2).isSelected())
									queue.add(new ProteinSelectedMessage(proteinBoxes.indexOf(pp), "Sushi"));
								if(typeBoxes.get(3).isSelected())
									queue.add(new ProteinSelectedMessage(proteinBoxes.indexOf(pp), "Rice"));
							
							}
						}
					
					if(foodButton.isSelected())
					{
						if(typeBoxes.get(0).isSelected())
							queue.add(new ProteinCompletedMessage("Poke"));
						if(typeBoxes.get(1).isSelected())
							queue.add(new ProteinCompletedMessage("Noodles"));
						if(typeBoxes.get(2).isSelected())
							queue.add(new ProteinCompletedMessage("Sushi"));
						if(typeBoxes.get(3).isSelected())
							queue.add(new ProteinCompletedMessage("Rice"));
					}

				}
			}
			
		});
		
		save.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				if(foodButton.isSelected())
					for(JCheckBox tt: toppingBoxes)
					{
						if(tt.isSelected())
						{
							if(typeBoxes.get(0).isSelected())
								queue.add(new ToppingSelectedMessage(toppingBoxes.indexOf(tt), "Poke"));
							if(typeBoxes.get(1).isSelected())
								queue.add(new ToppingSelectedMessage(toppingBoxes.indexOf(tt), "Noodles"));
							if(typeBoxes.get(2).isSelected())
								queue.add(new ToppingSelectedMessage(toppingBoxes.indexOf(tt), "Sushi"));
							if(typeBoxes.get(3).isSelected())
								queue.add(new ToppingSelectedMessage(toppingBoxes.indexOf(tt), "Rice"));						}
					}
				
				save.setEnabled(false);
				save.setVisible(false);
				next.setVisible(true);
				checkout.setEnabled(true);
				
				queue.add(new RestartMessage(true));
			}
			
		});
		
		checkout.addActionListener(new ActionListener() 
		{

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				JOptionPane thankYou = new JOptionPane();
				thankYou.showMessageDialog(null, "", "", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("thankyou.PNG"));
			}
			
		});
		
		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				queue.add(new RestartMessage(false));
			}
			
		});
	} 
	
	private void variableActions()
	{
		for(JRadioButton tb: typeBoxes)
		{
			tb.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) 
				{
					tb.setBorder(BorderFactory.createLineBorder(BrightGreen, 5));
					if(tb.isSelected())
					{
						tb.setBorderPainted(true);
						next.setEnabled(true);
					}
					else
						tb.setBorderPainted(false);
				}
				
			});
		}
		
		for(JRadioButton cb: choiceBoxes)
			cb.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) 
				{
					cb.setBorder(BorderFactory.createLineBorder(BrightGreen, 5));
	        		if(cb.isSelected())
	        		{
	        			cb.setBorderPainted(true);
	        			next.setEnabled(true);
	        		}
	        		else
	        			cb.setBorderPainted(false);
				}
				
			});
		
		for(JRadioButton bb: baseBoxes)
			bb.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) 
				{
					bb.setBorder(BorderFactory.createLineBorder(BrightGreen, 5));
	        		if(bb.isSelected())
	        		{
	        			baseGroup.clearSelection();
	        			bb.setSelected(true);
	        			bb.setBorderPainted(true);
	        			next.setEnabled(true);
	        		}
	        		else
	        			bb.setBorderPainted(false);
				}
				
			});
		
		for(JCheckBox pb: proteinBoxes)
		{
			pb.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) 
				{
					pb.setBorder(BorderFactory.createLineBorder(BrightGreen, 5));
	        		if(pb.isSelected())
	        		{
	        			pb.setBorderPainted(true);
	        			next.setEnabled(true);
	        		}
	        		else
	        			pb.setBorderPainted(false);
				}
				
			});
		}
		
		for(JCheckBox tb: toppingBoxes)
			tb.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) 
				{
					tb.setBorder(BorderFactory.createLineBorder(BrightGreen, 5));
	        		if(tb.isSelected())
	        		{
	        			tb.setBorderPainted(true);
	        			save.setEnabled(true);
	        		}
	        		else
	        			tb.setBorderPainted(false);
				}
				
			});
	}
	
	private void clearPanel()
	{
		getContentPane().removeAll();
		getContentPane().repaint();
		getContentPane().revalidate();
	}
	
	private void homePage()
	{
		clearPanel();
		
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(button1);
	}
	
	private void startPage()
	{
		clearPanel();
		
		getContentPane().setLayout(new FlowLayout());
		getContentPane().add(button2);
		getContentPane().add(startButton);
		getContentPane().add(loginButton);
	}
	
	private void restartPage()
	{
		foodButton.setBorderPainted(false);
		drinkButton.setBorderPainted(false);
		delete.setEnabled(true);
		edit.setEnabled(true);
		orderGroup.clearSelection();
		typeBoxes.clear();
		typeGroup.clearSelection();
		choiceBoxes.clear();
		choiceGroup.clearSelection();
		baseBoxes.clear();
		baseGroup.clearSelection();
		proteinBoxes.clear();
		toppingBoxes.clear();
		
		currentPage = Page.SELECT_ORDER;
		
		mainPage();
	}
	
	private void cancelPage()
	{
		foodButton.setBorderPainted(false);
		drinkButton.setBorderPainted(false);
		orderGroup.clearSelection();
		typeBoxes.clear();
		typeGroup.clearSelection();
		choiceBoxes.clear();
		choiceGroup.clearSelection();
		baseBoxes.clear();
		baseGroup.clearSelection();
		proteinBoxes.clear();
		toppingBoxes.clear();
		
		currentPage = Page.SELECT_ORDER;
		
		mainPage();
	}
	
	private void mainPage()
	{
		clearPanel();
		//getContentPane().add(new JLabel("This"));
		
		// set GridBagLaout for the frame  
        getContentPane().setLayout(new GridBagLayout()); 
        c.fill = GridBagConstraints.BOTH;
        
        //create left column
        JPanel currentOrderList = new JPanel();
        currentOrderList.setLayout(new BoxLayout(currentOrderList, BoxLayout.Y_AXIS));
        JScrollPane sp = new JScrollPane();
        sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);  
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        String[] custom = orderList.toArray(new String[100]);
        orderJList = new JList<String>(custom);
        sp.setViewportView(orderJList);
        currentOrderList.add(sp);
        currentOrderList.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 1;
        c.gridheight = 4;
        c.weightx = 0.2;
        c.weighty = 0.8;
        getContentPane().add(currentOrderList, c);
        
        //create scrollable center panel
        menu = new JPanel();
        menu.setLayout(new BoxLayout(menu, BoxLayout.Y_AXIS));
        menu.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JScrollPane scrollablePanel = new JScrollPane(menu);
        scrollablePanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);  
        scrollablePanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        c.gridx = 1;
        c.gridy = 0;
        c.gridwidth = 3;
        c.gridheight = 4;
        c.weightx = 0.6;
        c.weighty = 0.8;
        
        menu.removeAll();
        currentMenuPage.setText("" + currentPage);
    	menu.add(currentMenuPage);
        
    	
        //select if the order is a food or drink type
        if(currentPage == Page.SELECT_ORDER)
        {
        	addPossibleOrders();
        }
        
        //select specific type of food or drink for the order
        if(currentPage == Page.SELECT_TYPE)
        {
        	addTypeOfOrders();
        }
        
        //select a specific food
        if(currentPage == Page.SELECT_CHOICE)
        {
        	addPresetOrders();
        }
        
        //select the base for the food or drink
        if(currentPage == Page.SELECT_BASE)
        {
        	addBase();
        }
        
        //select the proteins for the food, not applicable to drinks
        if(currentPage == Page.SELECT_PROTEINS)
        {
        	addProteins();
        }
        
        //select the toppings for the food or drink
        if(currentPage == Page.SELECT_TOPPINGS)
        {
        	addToppings();
        }
        
        getContentPane().add(scrollablePanel, c);
        
        //create right column
        JPanel orderTotal = new JPanel();
        orderTotal.setLayout(new BoxLayout(orderTotal, BoxLayout.Y_AXIS));
        JScrollPane sp1 = new JScrollPane();
        sp1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);  
        sp1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        String[] customPrice = orderPriceList.toArray(new String[100]);
        orderJPriceList = new JList<String>(customPrice);
        sp1.setViewportView(orderJPriceList);
        orderTotal.add(sp1);
        
        subtotal.setText("Sutotal: " + df.format(allOrderPriceTotal));
        total.setText("Total: " + df.format(1.098 * allOrderPriceTotal));
        
        orderTotal.add(subtotal);
        orderTotal.add(total);
        orderTotal.add(checkout);
        orderTotal.setBorder(BorderFactory.createLineBorder(Color.BLACK)); 
        c.gridx = 4;
        c.gridy = 0;
        c.gridwidth = 1;
        c.gridheight = 4;
        c.weightx = 0.2;
        c.weighty = 0.8;
        getContentPane().add(orderTotal,c);
        
        //create left button
        c.fill = GridBagConstraints.HORIZONTAL;
        
        c.gridx = 0;
        c.gridy = 4;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.weightx = 0.2;
        c.weighty = 0.2;
        c.anchor = GridBagConstraints.PAGE_END;
        getContentPane().add(previous, c);
        
        //create center button 1
        c.fill = GridBagConstraints.HORIZONTAL;
        
        c.gridx = 1;
        c.gridy = 4;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.weightx = 0.2;
        c.weighty = 0.2;
        c.anchor = GridBagConstraints.PAGE_END;
        getContentPane().add(cancel, c);
        
        //create center button 2
        c.fill = GridBagConstraints.HORIZONTAL;
        
        c.gridx = 2;
        c.gridy = 4;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.weightx = 0.2;
        c.weighty = 0.2;
        c.anchor = GridBagConstraints.PAGE_END;
        getContentPane().add(delete, c);
        
        //create center button 3
        c.fill = GridBagConstraints.HORIZONTAL;
        
        c.gridx = 3;
        c.gridy = 4;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.weightx = 0.2;
        c.weighty = 0.2;
        c.anchor = GridBagConstraints.PAGE_END;
        getContentPane().add(edit, c);
        
        //create right button
        if(!save.isVisible())
        {
	        c.gridx = 4;
	        c.gridy = 4;
	        c.gridwidth = 1;
	        c.gridheight = 1;
	        c.weightx = 0.2;
	        c.weighty = 0.2;
	        c.anchor = GridBagConstraints.PAGE_END;
	        getContentPane().add(next, c);
        }
        
        if(!next.isVisible())
        {
        	getContentPane().remove(next);
        	c.gridx = 4;
            c.gridy = 4;
            c.gridwidth = 1;
            c.gridheight = 1;
            c.weightx = 0.2;
            c.weighty = 0.2;
            c.anchor = GridBagConstraints.PAGE_END;
            getContentPane().add(save, c);
        }
        
        variableActions();
        
        repaint();
        setVisible(true);
	}
	
	private void addPossibleOrders()
	{
		if(!foodButton.isSelected() && !drinkButton.isSelected())
    		next.setEnabled(false);   	
    	
        menu.add(foodButton);
        menu.add(drinkButton);
        previous.setEnabled(false);
        cancel.setEnabled(false);
	}
	
	private void addTypeOfOrders()
	{
		if(foodButton.isSelected())
		{
			JRadioButton pb = new JRadioButton("Poke Bowl");
			pb.setIcon(new ImageIcon("poke.png"));
			pb.setHorizontalTextPosition(JRadioButton.CENTER);
			pb.setVerticalTextPosition(JRadioButton.BOTTOM);
			
			JRadioButton n = new JRadioButton("Noodles");
			n.setIcon(new ImageIcon("noodles.png"));
			n.setHorizontalTextPosition(JRadioButton.CENTER);
			n.setVerticalTextPosition(JRadioButton.BOTTOM);
			
			JRadioButton s = new JRadioButton("Sushi");
			s.setIcon(new ImageIcon("sushi.png"));
			s.setHorizontalTextPosition(JRadioButton.CENTER);
			s.setVerticalTextPosition(JRadioButton.BOTTOM);
			
			JRadioButton rb = new JRadioButton("Rice Bowl");
			rb.setIcon(new ImageIcon("rice.png"));
			rb.setHorizontalTextPosition(JRadioButton.CENTER);
			rb.setVerticalTextPosition(JRadioButton.BOTTOM);
			
			typeBoxes.add(pb);
			typeBoxes.add(n);
			typeBoxes.add(s);
			typeBoxes.add(rb);
		}
		
		else
		{
			JRadioButton w = new JRadioButton("Water");
			w.setIcon(new ImageIcon("water.PNG"));
			w.setHorizontalTextPosition(JRadioButton.CENTER);
			w.setVerticalTextPosition(JRadioButton.BOTTOM);
			
			JRadioButton j = new JRadioButton("Juice");
			j.setIcon(new ImageIcon("juice.PNG"));
			j.setHorizontalTextPosition(JRadioButton.CENTER);
			j.setVerticalTextPosition(JRadioButton.BOTTOM);
			
			JRadioButton c = new JRadioButton("Coffee");
			c.setIcon(new ImageIcon("coffee.PNG"));
			c.setHorizontalTextPosition(JRadioButton.CENTER);
			c.setVerticalTextPosition(JRadioButton.BOTTOM);
			
			typeBoxes.add(w);
			typeBoxes.add(j);
			typeBoxes.add(c);
		}
		
		for(JRadioButton tb: typeBoxes)
    	{
    		typeGroup.add(tb);
    		menu.add(tb);
    	}
		
		next.setEnabled(false);
		previous.setEnabled(true);
		cancel.setEnabled(true);
	}
	
	private void addPresetOrders()
	{	
		if(foodButton.isSelected())
    	{
    		if(typeBoxes.get(0).isSelected())
    		{
    			for(PokeBowl p: po.getPokeBowlOrders())
    				choiceBoxes.add(new JRadioButton(p.getName()));
    		}
    		if(typeBoxes.get(1).isSelected())
    		{
    			for(Noodles n: po.getNoodleOrders())
    				choiceBoxes.add(new JRadioButton(n.getName()));
    		}
    		if(typeBoxes.get(2).isSelected())
    		{
    			for(Sushi s: po.getSushiOrders())
    				choiceBoxes.add(new JRadioButton(s.getName()));
    		}
    	}
    	
    	for(JRadioButton cb: choiceBoxes)
    	{
    		choiceGroup.add(cb);
    		menu.add(cb);
    	}
    	
    	next.setEnabled(false);
    	previous.setEnabled(true);
    	cancel.setEnabled(true);
	}
	
	private void addBase()
	{
		if(foodButton.isSelected())
		{
			if(typeBoxes.get(0).isSelected())
			{
				for(PokeBase b: ai.getPokeBase())
				{
					JRadioButton temp = new JRadioButton(b.getName());
					temp.setIcon(b.getIcon());
					temp.setHorizontalTextPosition(JRadioButton.CENTER);
					temp.setVerticalTextPosition(JRadioButton.BOTTOM);
					baseBoxes.add(temp);
				}
			}
			if(typeBoxes.get(1).isSelected())
			{
				for(NoodleBase b: ai.getNoodleBase())
				{
					JRadioButton temp = new JRadioButton(b.getName());
					temp.setIcon(b.getIcon());
					temp.setHorizontalTextPosition(JRadioButton.CENTER);
					temp.setVerticalTextPosition(JRadioButton.BOTTOM);
					baseBoxes.add(temp);
				}
			}
			if(typeBoxes.get(2).isSelected())
			{
				for(SushiBase b: ai.getSushiBase())
				{
					JRadioButton temp = new JRadioButton(b.getName());
					temp.setIcon(b.getIcon());
					temp.setHorizontalTextPosition(JRadioButton.CENTER);
					temp.setVerticalTextPosition(JRadioButton.BOTTOM);
					baseBoxes.add(temp);
				}
			}
		}
		
		for(JRadioButton bb: baseBoxes)
    	{
    		baseGroup.add(bb);
    		menu.add(bb);
    	}
		
		next.setEnabled(false);
		previous.setEnabled(true);
		cancel.setEnabled(true);
	}
	
	private void addProteins()
	{
		if(foodButton.isSelected())
    	{
    		if(typeBoxes.get(0).isSelected())
    		{
    			for(PokeProtein pp: ai.getPokeProtein())
    			{
    				JCheckBox temp = new JCheckBox(pp.getName());
					temp.setIcon(pp.getIcon());
					temp.setHorizontalTextPosition(JCheckBox.CENTER);
					temp.setVerticalTextPosition(JCheckBox.BOTTOM);
    				proteinBoxes.add(temp);
    			}
    		}
    		
    		if(typeBoxes.get(1).isSelected())
    		{
    			for(NoodleProtein np: ai.getNoodleProtein())
    			{
    				JCheckBox temp = new JCheckBox(np.getName());
					temp.setIcon(np.getIcon());
					temp.setHorizontalTextPosition(JCheckBox.CENTER);
					temp.setVerticalTextPosition(JCheckBox.BOTTOM);
    				proteinBoxes.add(temp);
    			}
    		}
    		
    		if(typeBoxes.get(2).isSelected())
    		{
    			for(SushiProtein sp: ai.getSushiProtein())
    			{
    				JCheckBox temp = new JCheckBox(sp.getName());
					temp.setIcon(sp.getIcon());
					temp.setHorizontalTextPosition(JCheckBox.CENTER);
					temp.setVerticalTextPosition(JCheckBox.BOTTOM);
    				proteinBoxes.add(temp);
    			}
    		}
    	}
		
		for(JCheckBox pm: proteinBoxes)
    		menu.add(pm);
		
		next.setEnabled(false);
		previous.setEnabled(true);
		cancel.setEnabled(true);
	}
	
	private void addToppings()
	{
		if(foodButton.isSelected())
    	{
    		if(typeBoxes.get(0).isSelected())
    		{
    			for(PokeTopping tt: ai.getPokeTopping())
    			{
    				JCheckBox temp = new JCheckBox(tt.getName());
					temp.setIcon(tt.getIcon());
					temp.setHorizontalTextPosition(JCheckBox.CENTER);
					temp.setVerticalTextPosition(JCheckBox.BOTTOM);
    				toppingBoxes.add(temp);
    			}
    		}
    		
    		if(typeBoxes.get(1).isSelected())
    		{
    			for(NoodleTopping nt: ai.getNoodleTopping())
    			{
    				JCheckBox temp = new JCheckBox(nt.getName());
					temp.setIcon(nt.getIcon());
					temp.setHorizontalTextPosition(JCheckBox.CENTER);
					temp.setVerticalTextPosition(JCheckBox.BOTTOM);
    				toppingBoxes.add(temp);
    			}
    		}
    		
    		if(typeBoxes.get(2).isSelected())
    		{
    			for(SushiTopping st: ai.getSushiTopping())
    			{
    				JCheckBox temp = new JCheckBox(st.getName());
					temp.setIcon(st.getIcon());
					temp.setHorizontalTextPosition(JCheckBox.CENTER);
					temp.setVerticalTextPosition(JCheckBox.BOTTOM);
    				toppingBoxes.add(temp);
    			}
    		}
    	}
		
		for(JCheckBox tt: toppingBoxes)
    		menu.add(tt);
		
		
		next.setEnabled(false);
		next.setVisible(false);
		save.setEnabled(false);
		save.setVisible(true);
	}
	
	//get a list of the current base
	public ArrayList<JRadioButton> getBase()
	{
		return baseBoxes;
	}
	
	//get a list of the current proteins
	public ArrayList<JCheckBox> getProtein()
	{
		return proteinBoxes;
	}
	
	//get a list of the current toppings
	public ArrayList<JCheckBox> getTopping()
	{
		return toppingBoxes;
	}
	
	//get the current page
	public Page getCurrentPage()
	{
		return currentPage;
	}
	
	//when an order is added, the order is added to a list
	public void addToList(OrderType ot, int currentOrder)
	{
		orderList.add("Order " + (currentOrder + 1) + ": "+ ot.toString());
		addToPriceList(ot.getPrice(), currentOrder);
	}
	
	//when an order is added, the price is added
	private void addToPriceList(double price, int currentOrder)
	{
		allOrderPriceTotal += price;
		orderPriceList.add("Order " + (currentOrder + 1) + ": " + df.format(price));
	}
	
	//uses the controller to update the view
	public void update(Page current)
	{
		if(current == Page.HOME)
			homePage();
		if(current == Page.START)
			startPage();
		if(current == Page.MAIN)
			mainPage();
		if(current == Page.RESTART)
			restartPage();
		if(current == Page.CANCEL)
			cancelPage();
		if(current == Page.SELECT_ORDER)
		{
			currentPage = current;
			previous.setEnabled(false);
			mainPage();
		}
		if(current == Page.SELECT_TYPE)
		{
			currentPage = current;
			previous.setEnabled(true);
			mainPage();
		}
		if(current == Page.SELECT_CHOICE)
		{
			currentPage = current;
			previous.setEnabled(true);
			mainPage();
		}
		if(current == Page.SELECT_BASE){
			currentPage = current;
			previous.setEnabled(true);
			mainPage();
		}
		if(current == Page.SELECT_PROTEINS){
			currentPage = current;
			previous.setEnabled(true);
			mainPage();
		}
		if(current == Page.SELECT_TOPPINGS)
		{
			currentPage = current;
			mainPage();
		}
	}
}
