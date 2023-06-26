package MilkTeaStore;

public class Sting implements IFlavourStrategy{
	double price;
	public Sting() {
	}


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
