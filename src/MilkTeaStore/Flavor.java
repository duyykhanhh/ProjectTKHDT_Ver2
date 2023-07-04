package MilkTeaStore;

import view.Home;

public class Flavor {

	private static FileRW filePriceUnit = new FileRW(Home.getUrlRoot() +"/priceUnit");
//	private static double chocolatePrice = 5000;
//	private static double mathcaPrice = 6000;
//	private static double taroPrice = 7000;
//	private static double stingPrice = 10000;
//	private static double redbullPrice = 11000;
//	private static double cocacolaPrice = 12000;
//	private static double sevenUpPrice = 13000;
//	private static double orangePrice = 20000;
//	private static double lemonadePrice = 15000;
//	private static double blackCoffeePrice = 27000;
//	private static double milkPrice = 30000;
	
	private static double chocolatePrice = filePriceUnit.readPriceUnit("chocolate");
	private static double mathcaPrice = filePriceUnit.readPriceUnit("matcha");
	private static double taroPrice = filePriceUnit.readPriceUnit("taro");
	private static double stingPrice = filePriceUnit.readPriceUnit("sting");
	private static double redbullPrice = filePriceUnit.readPriceUnit("redbull");
	private static double cocacolaPrice = filePriceUnit.readPriceUnit("cocacola");
	private static double sevenUpPrice = filePriceUnit.readPriceUnit("sevenup");
	private static double orangePrice = filePriceUnit.readPriceUnit("orange");
//	private static double orangePrice = 6000;
	private static double lemonadePrice = filePriceUnit.readPriceUnit("lemonade");
	private static double blackCoffeePrice = filePriceUnit.readPriceUnit("black");
	private static double milkPrice = filePriceUnit.readPriceUnit("milk");





	public static String getFlavorDescription(Object o) {
	if(o instanceof ChocolateFlavour) {
		return "Chocolate";
	}
	else if(o instanceof MatchaFlavour) {
		return "Matcha";
	}
	else if(o instanceof TaroFlavour) {
		return "Taro";
	}
	else if(o instanceof  Sting){
		return " Sting";
	}
	else if(o instanceof  RedBull){
		return " Redbull";
	}
	else if(o instanceof  CocaCola){
		return " CocaCola";
	}
	else if(o instanceof  SevenUp){
		return " 7Up";
	}
	else if(o instanceof  OrangeFlavour){
		return " Orange";
	}
	else if(o instanceof  LemonadeFlavour){
		return " Lemon";
	}
	else if(o instanceof BlackCoffeeFlavour){
		return " BlackCoffee";
	}
	else if(o instanceof  MilkCoffeeFlavour){
		return " Milk";
	}

	return "";
}
public static double getPrice(Object o) {
	if(o instanceof ChocolateFlavour) {
		return chocolatePrice;
	}
	else if(o instanceof MatchaFlavour) {
		return mathcaPrice;
	}
	else if(o instanceof TaroFlavour) {
		return taroPrice;
	}
	else if(o instanceof Sting) {
		return stingPrice;
	}
	else if(o instanceof  RedBull){
		return redbullPrice;
	}else if(o instanceof  CocaCola){
		return cocacolaPrice;
	}else if(o instanceof  Sting){
		return stingPrice;
	}else if(o instanceof  SevenUp){
		return sevenUpPrice;
	}else if(o instanceof  OrangeFlavour){
		return orangePrice;
	}else if(o instanceof  LemonadeFlavour){
		return lemonadePrice;
	}
	else if( o instanceof  BlackCoffeeFlavour){
		return blackCoffeePrice;
	}
	else if(o instanceof  MilkCoffeeFlavour){
		return milkPrice;
	}
	return 0;
}

public static void setChocolatePrice(double chocolatePrice) {
	Flavor.chocolatePrice = chocolatePrice;
}

public static void setMathcaPrice(double mathcaPrice) {
	Flavor.mathcaPrice = mathcaPrice;
}

public static void setTaroPrice(double taroPrice) {
	Flavor.taroPrice = taroPrice;
}
}
