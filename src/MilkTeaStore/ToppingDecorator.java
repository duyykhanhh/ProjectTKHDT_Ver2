package MilkTeaStore;

public abstract class ToppingDecorator extends Drink{
	protected Drink drink;

//	public ToppingDecorator(ISizeStrategy size, IPriceStrategy pricePercentage, IFlavorStrategy flavor,
//			boolean isOwnCup, Drink drink) {
//		super(size, pricePercentage, flavor, isOwnCup);
//		this.drink = drink;
//	}

	public ToppingDecorator(Drink drink) {
		super();
		// TODO Auto-generated constructor stub
		this.drink = drink;
	}

	
}
