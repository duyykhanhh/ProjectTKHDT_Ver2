package MilkTeaStore;

public class Coffee extends Drink{
	private double price=15000;
	public Coffee() {
	
		// TODO Auto-generated constructor stub
	}



	private boolean isIce;

	@Override
	public String getDiscription() {
		// TODO Auto-generated method stub
		return " Coffee ";
	}

	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return price;
	}

	public void setIce(boolean ice) {
		isIce = ice;
	}

	public boolean getIsIce() {
		return isIce;
	}
}
