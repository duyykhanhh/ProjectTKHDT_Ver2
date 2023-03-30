package MilkTeaStore;

public class ChocolateFlavor implements IFlavorStrategy{
private int price;
	@Override
	public String getFlavorDiscription() {
		// TODO Auto-generated method stub
		return Flavor.getFlavorDescription(this);
	}

	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		

		return Flavor.getPrice(this);
	}

}
