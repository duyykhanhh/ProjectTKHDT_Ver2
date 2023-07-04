package MilkTeaStore;

import java.util.ArrayList;

import view.Home;

public class GrassJelly extends Topping {
	private FileRW filePrice = new FileRW(Home.getUrlRoot() +"/priceUnit");
//	private double price = filePrice.readPriceUnit("grassjelly");
	private double price=2000;
	public GrassJelly() {


	}

	public GrassJelly(int quantity) {
		super(quantity);
	}

	@Override
	public String getDiscription() {
		// TODO Auto-generated method stub
		return  " Grass jelly ";
	}

	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return  price*getQuantity();
	}



}
