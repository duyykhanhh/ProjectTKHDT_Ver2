package view;

import MilkTeaStore.Alarm;
import MilkTeaStore.BartenderModel;
import MilkTeaStore.OrderData;
import MilkTeaStore.OrderModel;

public class test2 {
public static void main(String[] args) {
	Order order = new Order();
	order.setVisible(true);
	OrderData orderData = new OrderData();
	Bartender ba = new Bartender(orderData);
	ba.setVisible(true);
	System.out.println(orderData.getOrder());
	
	
	
	
//	OrderData orderData = new OrderData();
//	BartenderModel ba = new BartenderModel(orderData);
//	
//	OrderModel o1 = new OrderModel("nhat", new Alarm(1, false));
//	OrderModel o2 = new OrderModel("to minh nhat", new Alarm(2, false));
//	
//	orderData.setOrder(o2);
////	orderList.add(o1);
////	orderList.add(o2);
	
	
}
}
