package MilkTeaStore;

import java.util.ArrayList;

public abstract class Beverage {
	private FileRW filePrice = new FileRW("scr/data/priceUnit");
//	private static double priceUnit;
//	private double price = filePrice.readPriceUnit("beverage");
	private double price;

	private IFlavourStrategy flavour;
	private ISizeStrategy size;
	private IPriceStrategy priceStrategy = new NormalPrice();
	private ToppingFactory toppingFactory = new ToppingFactory();
	private ArrayList<Topping> toppingList = new ArrayList<Topping>();

public Beverage() {

}
public Beverage(double price, IFlavourStrategy flavour){
	super();
	this.price = price;
	this.flavour = flavour;
}
	public Beverage(double price,IFlavourStrategy flavour, ISizeStrategy size) {
		super();
        this.price = price;
		this.flavour = flavour;
		this.size = size;

	}

public abstract String getDescription();
public String getFullDescription(){
	StringBuilder sb = new StringBuilder();
	sb.append(getDescription());
	if(flavour!=null)
	sb.append(flavour.getFlavorDiscription()+" ");
	for(Topping topping: toppingList){
		sb.append(" "+topping.getDiscription()+"x"+topping.getQuantity()+" ");

	}
	if(size!=null)
    sb.append(size.getSize());
	return sb.toString();
}

	public double getTotalPrice() {
		double toppingPrice = 0;
		if(toppingList.size()!=0){
		for(Topping topping : toppingList){
			toppingPrice+=topping.getPrice();
		}}
		else {
			toppingPrice =0;
		}
//		if(flavour == null){
//
//			return priceStrategy.getPrice(size.getPrice() * ( 1))+toppingPrice ;
//		}
		if(size == null){
		 return	priceStrategy.getPrice(  ( flavour.getPrice())) ;
		}
		return priceStrategy.getPrice(size.getPrice() * ( flavour.getPrice()))+toppingPrice ;

//		return priceStrategy.getPrice(5000);






	}

	public double getPoint() {
		return priceStrategy.getPoint(size.getPrice() * (this.getPrice() + flavour.getPrice()));

	}

	public double getPrice() {
		return price;
	}
	

	public void setPrice(double price) {
		this.price = price;
	}

//	cac method ho tro order nuoc
//	*************************************

//public Drink getDrink() {
//		return drink;
//	}

//	public void setDrink(Drink drink) {
//		this.drink = drink;
//	}

	public IFlavourStrategy getFlavour() {
		return flavour;
	}

//	public void setFlavour(IFlavourStrategy flavour) {
//		this.flavour = flavour;
//	}

	public ISizeStrategy getSize() {
		return size;
	}

//	public void setSize(ISizeStrategy size) {
//		this.size = size;
//	}

	public IPriceStrategy getPriceStrategy() {
		return priceStrategy;
	}

	public void setPriceStrategy(IPriceStrategy priceStrategy) {
		this.priceStrategy = priceStrategy;
	}


	//	huong vi
	public void setFlavour(String flavour) {
		if(flavour.equals("Chocolate"))
			this.flavour= new ChocolateFlavour();
		else if(flavour.equals("Matcha"))
			this.flavour= new MatchaFlavour();
		else if(flavour.equals("Taro"))
			this.flavour= new TaroFlavour();
		else if(flavour.equals("Orange"))
			this.flavour= new OrangeFlavour();
		else if(flavour.equals("Lemonade"))
			this.flavour= new LemonadeFlavour();
		else if(flavour.equals("Sting"))
			this.flavour= new Sting();
		else if(flavour.equals("Redbull"))
			this.flavour= new RedBull();
		else if(flavour.equals("CocaCola"))
			this.flavour= new CocaCola();
		else if(flavour.equals("7Up"))
			this.flavour= new SevenUp();
		else if(flavour.equals("Black"))
			this.flavour= new BlackCoffeeFlavour();
		else if(flavour.equals("Milk"))
			this.flavour= new MilkCoffeeFlavour();
	}


	//	size
	public void setSize(String size) {
		if(size.equalsIgnoreCase("S"))
			this.size= new Small();
		else if(size.equalsIgnoreCase("M"))
			this.size= new Medium();
		else if(size.equalsIgnoreCase("L"))
			this.size= new Large();
	}

	//	them topping
	public void addTopping(String toppingName,int quantity) {
		Topping topping = toppingFactory.createTopping(toppingName,quantity);
		toppingList.add(topping);
	}
   public void addTopping(Topping topping){
		toppingList.add(topping);
   }





	public ToppingFactory getToppingFactory() {
		return toppingFactory;
	}



	public ArrayList<Topping> getToppingList() {
		return toppingList;
	}




}
