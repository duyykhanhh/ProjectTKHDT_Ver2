package MilkTeaStore;

import java.util.ArrayList;
import java.util.List;

public class OrderData {
	private OrderModel order;
	private List<Observer> obs;
	public OrderData() {
		super();
		this.obs = new ArrayList<>();
	}
	
	public void registerObserver(Observer o) {
		this.obs.add(o);
	}
	
	public void removeObserver(Observer o) {
		this.obs.remove(o);
	}
	
	public void notifyObs() {
		for(Observer o : this.obs) {
			o.update(order);
		}
	}

	public OrderModel getOrder() {
		return order;
	}

	public void setOrder(OrderModel order) {
		if(order.getAlarm().getNumber() >=1 && order.getAlarm().getNumber()<=30) {
			this.order = order;
			notifyObs();
		}
		
	}
	
	public static void main(String[] args) {
		OrderData data = new OrderData();
		AlarmManagement am = new AlarmManagement(data);
		Bartender ba = new Bartender(data);
		
		String s1= "sting";
		String s2= "coca";
		String s3= "redbull";
		String s4= "7up";
	}
	
	
	
	
	
	
	
	
}
