package MilkTeaStore;

public class MilkCoffeeFlavour implements IFlavourStrategy{
    public  MilkCoffeeFlavour(){

    }
    @Override
    public String getFlavorDiscription() {
        return Flavor.getFlavorDescription(this);
    }

    @Override
    public double getPrice() {
        return Flavor.getPrice(this);
    }
}
