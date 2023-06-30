package MilkTeaStore;

import java.util.ArrayList;
import java.util.List;

public class OrderModel {
	private String order;
	private Alarm alarm;
	public OrderModel(String order, Alarm alarm) {
		super();
		this.order = order;
		this.alarm = alarm;
	}
	
	
	public OrderModel(Alarm alarm) {
		super();
		this.alarm = alarm;
	}


	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
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
	
	public String toString() {
		return order + alarm;
	}
	
	
}
