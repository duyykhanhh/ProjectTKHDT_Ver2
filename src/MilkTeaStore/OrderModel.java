package MilkTeaStore;

import java.util.ArrayList;
import java.util.List;

public class OrderModel {
	private List<Beverage> order = new ArrayList<>();
	private Alarm alarm;
	public OrderModel(List<Beverage> order, Alarm alarm) {
		super();
		this.order = order;
		this.alarm = alarm;
	}
	
	
}
