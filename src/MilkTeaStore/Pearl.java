package MilkTeaStore;

public class Pearl extends ToppingDecorator{
	private double price=3000;
	public Pearl(Drink drink) {
		super(drink);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getDiscription() {
		// TODO Auto-generated method stub
		return drink.getDiscription() + " Pearl ";
	}

	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return drink.getPrice() + price;
	}
	

}
