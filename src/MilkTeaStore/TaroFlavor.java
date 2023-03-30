package MilkTeaStore;

public class TaroFlavor implements IFlavorStrategy{

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
