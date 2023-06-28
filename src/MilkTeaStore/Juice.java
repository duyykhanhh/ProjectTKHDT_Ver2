package MilkTeaStore;

import java.util.ArrayList;

public class Juice extends Beverage {

	private static FileRW filePrice = new FileRW("scr/data/priceUnit");
	private static double priceUnit = filePrice.readPriceUnit("juice");
    public Juice() {
    }

    public Juice(IFlavourStrategy flavour, ISizeStrategy size) {
        super(7000, flavour, size);
    }

    @Override
    public String getDescription() {
        return "Juice";
    }





}
