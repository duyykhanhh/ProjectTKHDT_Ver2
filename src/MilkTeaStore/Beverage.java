package MilkTeaStore;

public class Beverage {
	private ISizeStrategy size;
	private IPriceStrategy priceStrategy;
	private IFlavorStrategy flavor;
	private boolean isOwnCup;
	private Drink drink;
	public Beverage() {
		
	}
	public Beverage(ISizeStrategy size, IPriceStrategy priceStrategy, IFlavorStrategy flavor, boolean isOwnCup,
			Drink drink) {
		super();
		this.size = size;
		this.priceStrategy = priceStrategy;
		this.flavor = flavor;
		this.isOwnCup = isOwnCup;
		this.drink = drink;

	}
	public String getDescription() {
		return drink.getDiscription();
	}
	public double getPrice() {
		return priceStrategy.getPrice(size.getPrice() * (drink.getPrice() + flavor.getPrice()))  ;
		
	}
	public double getPoint() {
		return priceStrategy.getPoint(size.getPrice() * (drink.getPrice() + flavor.getPrice()));
		
	}
}
