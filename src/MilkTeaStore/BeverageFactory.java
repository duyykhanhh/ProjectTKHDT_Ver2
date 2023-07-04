package MilkTeaStore;

public class BeverageFactory {
    public ISizeStrategy createSize(String size){
        ISizeStrategy sizeStrategy = null;
        if(size.equalsIgnoreCase("S"))
            sizeStrategy= new Small();
        else if(size.equalsIgnoreCase("M"))
            sizeStrategy= new Medium();
        else if(size.equalsIgnoreCase("L"))
            sizeStrategy= new Large();
        return sizeStrategy;
    }
    public IFlavourStrategy createFlavour(String flavour){
        IFlavourStrategy flavourStrategy = null;
        if(flavour.equals("Chocolate"))
            flavourStrategy= new ChocolateFlavour();
        else if(flavour.equals("Matcha"))
            flavourStrategy= new MatchaFlavour();
        else if(flavour.equals("Taro"))
            flavourStrategy= new TaroFlavour();
        else if(flavour.equals("Orange"))
            flavourStrategy= new OrangeFlavour();
        else if(flavour.equals("Lemonade"))
            flavourStrategy= new LemonadeFlavour();
        else if(flavour.equals("Sting"))
            flavourStrategy= new Sting();
        else if(flavour.equals("Redbull"))
            flavourStrategy= new RedBull();
        else if(flavour.equals("CocaCola"))
            flavourStrategy= new CocaCola();
        else if(flavour.equals("7Up"))
            flavourStrategy= new SevenUp();
        else if(flavour.equals("Black"))
            flavourStrategy= new BlackCoffeeFlavour();
        else if(flavour.equals("Milk"))
            flavourStrategy= new MilkCoffeeFlavour();
        return flavourStrategy;
    }
    public Beverage createBeverage(String name){
        Beverage beverage ;
        if(name.equalsIgnoreCase("Milktea")){
            beverage = new MilkTea();
        }
        else if(name.equalsIgnoreCase("Coffee")){
            beverage = new Coffee();


        }
        else if(name.equalsIgnoreCase("Juice")){
            beverage = new Juice();


        }
        else if(name.equalsIgnoreCase("SoftDrink")){
            beverage = new SoftDrink();


        }
       else {
           return null;
        }

        return beverage;
    }
}
