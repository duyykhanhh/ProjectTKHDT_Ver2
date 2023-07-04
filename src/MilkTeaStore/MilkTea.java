package MilkTeaStore;

import java.util.ArrayList;

import view.Home;

public class MilkTea extends Beverage{
	

	private static FileRW filePrice = new FileRW(Home.getUrlRoot() +"/priceUnit");
	private static double priceUnit = filePrice.readPriceUnit("milktea");
	
	
	public MilkTea() {
		
	}

	public MilkTea( IFlavourStrategy flavour, ISizeStrategy size) {
		super(priceUnit, flavour, size);
	}

	@Override
	public String getDescription() {
		return "MilkTea";
	}
	


}
