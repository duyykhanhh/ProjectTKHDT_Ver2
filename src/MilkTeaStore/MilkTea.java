package MilkTeaStore;

import java.util.ArrayList;

public class MilkTea extends Beverage{
	private static FileRW filePrice = new FileRW("scr/data/priceUnit");
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
