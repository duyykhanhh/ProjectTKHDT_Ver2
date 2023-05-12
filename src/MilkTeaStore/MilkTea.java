package MilkTeaStore;

import java.util.ArrayList;

public class MilkTea extends Drink{
	private double price= 13000;
	public MilkTea() {
		
	}

	@Override
	public String getDiscription() {
		// TODO Auto-generated method stub
		return "Milk tea";
	}

	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return price;
	}


	public void addToppingHelper(Drink dr, String topping) {
		// TODO Auto-generated method stub
		
		if(topping.equals("Soy"))
			dr= new Pearl(dr);
		else if(topping.equals("Pudding"))
			dr= new Pudding(dr);
		else if(topping.equals("GrassJelly"))
			dr= new GrassJelly(dr);
		
	
	}
	
	public void addTopping(Drink dr, ArrayList<String> toppings) {
		for(String topping : toppings) {
			this.addToppingHelper(dr, topping);
		}
	}
	
	
	

}
