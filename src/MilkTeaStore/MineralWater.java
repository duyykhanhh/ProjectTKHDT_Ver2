package MilkTeaStore;

public class MineralWater extends Drink {
    int price=0;


    @Override
    public String getDiscription() {
        // TODO Auto-generated method stub
        return "Mineral water";
    }

    @Override
    public double getPrice() {
        // TODO Auto-generated method stub
        return this.price;
    }
}
