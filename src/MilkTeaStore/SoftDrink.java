package MilkTeaStore;

import java.util.ArrayList;

public class SoftDrink extends Beverage{
	private static FileRW filePrice = new FileRW("scr/data/priceUnit");
	private static double priceUnit = filePrice.readPriceUnit("softdrink");
	public SoftDrink() {
	
		// TODO Auto-generated constructor stub
	}

	public SoftDrink(IFlavourStrategy flavour, ISizeStrategy size) {
		super(priceUnit, flavour, size);
	}

	@Override
	public String getDescription() {
		return "SoftDrink";
	}





}
