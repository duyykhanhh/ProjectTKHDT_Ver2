package MilkTeaStore;

import java.util.ArrayList;

public class SoftDrink extends Beverage{
	private double price= 12000;
	public SoftDrink() {
	
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getDescription() {
		return "SoftDrink";
	}


	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return this.price;
	}


}
