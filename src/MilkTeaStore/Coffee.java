package MilkTeaStore;

import java.util.ArrayList;

public class Coffee extends Beverage{
	private static FileRW filePrice = new FileRW("scr/data/priceUnit");
	private static double priceUnit = filePrice.readPriceUnit("coffee");
	public Coffee() {
	
		// TODO Auto-generated constructor stub
	}

	public Coffee( IFlavourStrategy flavour, ISizeStrategy size) {
		super(priceUnit, flavour, size);
	}

	@Override
	public String getDescription() {
		return " Coffee ";
	}


//	public void setIce(boolean ice) {
//		isIce = ice;
//	}
//
//	public boolean getIsIce() {
//		return isIce;
//	}

	public static void main(String[] args) {
		double price = 9;
//		IFlavourStrategy flavor = new 
		
	}

}
