import model.*;
import view.GUI;
import controller.*;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class CustomizableVendingMachine 
{
	//Denoted as CVM in other classes
	
	private static BlockingQueue<Message> queue = new LinkedBlockingQueue<>();
    private static GUI view;
    private static Store model;
    private static AllIngredients ingredients = new AllIngredients();
	private static PresetOrders popularOrders = new PresetOrders();
	
    public static void main(String[] args) 
    {
    	view = GUI.init(queue);
        model = new Store(ingredients, popularOrders);
        Controller controller = new Controller(view, model, queue);

        controller.mainLoop();
        view.dispose();
        queue.clear();
    }
}
