package MilkTeaStore;

public class BlackCoffeeFlavour implements IFlavourStrategy{
    public BlackCoffeeFlavour(){

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
