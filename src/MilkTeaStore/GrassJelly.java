package MilkTeaStore;

import java.util.ArrayList;

public class GrassJelly extends ToppingDecorator{
	private double price=2000;
	public GrassJelly(Drink drink) {
		super(drink);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getDiscription() {
		// TODO Auto-generated method stub
		return drink.getDiscription() + " Grass jelly ";
	}

	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return drink.getPrice() + price;
	}

	@Override
	public void addTopping(Drink dr, ArrayList<String> toppings) {
		// TODO Auto-generated method stub
		
	}

}
