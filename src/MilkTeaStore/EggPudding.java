package MilkTeaStore;

public class EggPudding extends ToppingDecorator{
	private double price=5000;
	public EggPudding(Drink drink) {
		super(drink);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getDiscription() {
		// TODO Auto-generated method stub
		return drink.getDiscription() + " Eggpudding ";
	}

	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return drink.getPrice() + price;
	}


}
