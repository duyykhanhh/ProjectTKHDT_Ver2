package MilkTeaStore;

public class GrassJerry extends ToppingDecorator{
	private double price=2000;
	public GrassJerry(Drink drink) {
		super(drink);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getDiscription() {
		// TODO Auto-generated method stub
		return drink.getDiscription() + " grass jerry ";
	}

	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return drink.getPrice() + price;
	}

}
