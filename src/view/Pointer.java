package view;


// class này lấy địa chỉ của ORDER được tạo ở Home
public class Pointer {

    public static Order currentOrder;

    public  static Pay currentPay ;

    public static Bartender currentBartender;

    public static Bartender setCurrentWatercounters(Bartender a){

        return currentBartender =a ;
    }
    public static Order setCurrentOrder(Order order) {
        return Order.setCurrentOrder(order) ;
    }
//    public static Pay setCurrentPay(Pay pay) {
//        return Pay.setCurrentPay(pay);
//    }

}
