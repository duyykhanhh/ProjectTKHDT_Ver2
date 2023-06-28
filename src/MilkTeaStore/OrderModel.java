package MilkTeaStore;

import java.util.ArrayList;
import java.util.List;

public class OrderModel {
	private List<String> order = new ArrayList<>();
	private Alarm alarm;
	public OrderModel(List<String> order, Alarm alarm) {
		super();
		this.order = order;
		this.alarm = alarm;
	}
	public List<String> getOrder() {
		return order;
	}
	public void setOrder(List<String> order) {
		this.order = order;
	}
	public Alarm getAlarm() {
		return alarm;
	}
	public void setAlarm(Alarm alarm) {
		this.alarm = alarm;
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	
	
}
