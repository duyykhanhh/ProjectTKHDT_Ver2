package MilkTeaStore;

import java.util.ArrayList;

public class Juice extends Drink {
    int price=0;


    @Override
    public String getDiscription() {
        // TODO Auto-generated method stub
        return "Mineral water";
    }

    @Override
    public double getPrice() {
        // TODO Auto-generated method stub
        return this.price;
    }

	@Override
	public void addTopping(Drink dr, ArrayList<String> toppings) {
		// TODO Auto-generated method stub
		
	}
}
