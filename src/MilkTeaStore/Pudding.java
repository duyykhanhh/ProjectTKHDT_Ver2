package MilkTeaStore;

import java.util.ArrayList;

public class Pudding extends ToppingDecorator{
	private double price=5000;
	public Pudding(Drink drink) {
		super(drink);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getDiscription() {
		// TODO Auto-generated method stub
		return drink.getDiscription() + " Eggpudding ";
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
