package MilkTeaStore;

import java.util.ArrayList;

public class Pearl extends Topping {
	private static FileRW filePrice = new FileRW("scr/data/priceUnit");
//	private double price = filePrice.readPriceUnit("pearl");
	private double price=3000;


	public Pearl() {
//		Pearl.filePrice = new FileRW("scr/data/priceUnit");
//		Pearl.price = filePrice.readPriceUnit("pearl");
	}

	public Pearl(int quantity) {
		super(quantity);
//		Pearl.filePrice = new FileRW("scr/data/priceUnit");
//		Pearl.price = filePrice.readPriceUnit("pearl");
	}

	@Override
	public String getDiscription() {
		// TODO Auto-generated method stub
		return " Pearl ";
	}

	public double getPrice() {
		// TODO Auto-generated method stub
		return price*getQuantity();
	}
	
	

//	@Override
//	public void addTopping(Drink dr, ArrayList<String> toppings) {
//		// TODO Auto-generated method stub
//
//	}
	

}
