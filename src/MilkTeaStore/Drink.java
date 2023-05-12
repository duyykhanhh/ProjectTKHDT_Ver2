package MilkTeaStore;

import java.util.ArrayList;

public abstract class Drink {
	
	
	
	public Drink() {
		super();
	}

	public abstract String getDiscription();
	public abstract double getPrice();
	public abstract void addTopping(Drink dr, ArrayList<String> toppings);
//	public abstract void addToppingHelper(Drink dr, String topping);
	

}
