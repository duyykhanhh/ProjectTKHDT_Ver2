package MilkTeaStore;

public class SoftDrink extends Drink{
	private double price= 12000;
	public SoftDrink() {
	
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getDiscription() {
		// TODO Auto-generated method stub
		return "Soft drink";
	}

	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return this.price;
	}
}
