package service;

import MilkTeaStore.*;

import java.util.List;

public class ProductServiceImp implements  IProductService{
    ToppingFactory toppingFactory = new ToppingFactory();
    BeverageFactory beverageFactory = new BeverageFactory();
    @Override
    public double getTotalPrice(Beverage beverage, String flavour, List<Topping> toppingList, String size) {
        beverage.setFlavour(flavour);
        beverage.setSize(size);
        if(toppingList.size()!=0){
        for(Topping topping: toppingList){
            beverage.addTopping(topping);
        }}
        return beverage.getTotalPrice();
    }

    @Override
    public Beverage setBeverage(String name) {
        Beverage beverage = beverageFactory.createBeverage(name) ;
        return beverage;
    }

    @Override
    public Topping createTopping(String name, int quantity) {
        return toppingFactory.createTopping(name, quantity);
    }
}
