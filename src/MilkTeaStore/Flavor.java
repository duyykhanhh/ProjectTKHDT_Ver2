package MilkTeaStore;

public class Flavor {
	private static double chocolatePrice = 5000;
	private static double mathcaPrice = 6000;
	private static double taroPrice = 7000;
	private static double stingPrice = 10000;
	private static double redbullPrice = 11000;
	private static double cocacolaPrice = 12000;
	private static double sevenUpPrice = 13000;
	private static double orangePrice = 20000;
	private static double lemonadePrice = 15000;
	private static double blackCoffeePrice = 30000;
	private static double milkPrice = 25000;




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
