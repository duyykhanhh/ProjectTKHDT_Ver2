package MilkTeaStore;

public class MilkTea extends Drink{
	private double price= 13000;
	public MilkTea() {
		
	}

	@Override
	public String getDiscription() {
		// TODO Auto-generated method stub
		return "Milk tea";
	}

	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return price;
	}
}
