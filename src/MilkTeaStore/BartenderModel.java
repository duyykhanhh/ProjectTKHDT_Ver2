package MilkTeaStore;

import java.util.ArrayList;
import java.util.List;

public class BartenderModel implements Observer{
	private List<OrderModel> orderList = new ArrayList<>();
	private OrderData orderData = new OrderData();
	private int sizeOld=0;
	private boolean change=false;
	public BartenderModel(OrderData orderData) {
		super();
		this.orderData = orderData;
		this.orderData.registerObserver(this);
	}
	@Override
	public void update(OrderModel o) {
		// TODO Auto-generated method stub

		if(o.getAlarm().isAvailable()==false) {
			orderList.add(o);

		}
		System.out.println(orderList);
		
	}
	
	public void finish(OrderModel order) {
//		order.getAlarm().setAvailable(true);
		orderData.freeAlarm(order.getAlarm());
		orderList.remove(order);
	}
	
	public void doAlarm(OrderModel order) {
		order.getAlarm().ring();
	}
	
	public List<OrderModel> getOrderList() {
		return orderList;
	}
	public void setOrderList(List<OrderModel> orderList) {
		this.orderList = orderList;
	}
	public boolean isChange() {
		return change;
	}
	public void setChange(boolean change) {
		this.change = change;
	}
	
	
	
//	public boolean isChanged() {
//		
//	}
//	
}
