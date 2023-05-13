package MilkTeaStore;

import java.util.ArrayList;

public class Coffee extends Beverage{
	private double price=15000;
	private boolean isIce;
	public Coffee() {
	
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getDescription() {
		return " Coffe ";
	}





	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return price;
	}

	public void setIce(boolean ice) {
		isIce = ice;
	}

	public boolean getIsIce() {
		return isIce;
	}


}
