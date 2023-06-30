package MilkTeaStore;

import java.util.ArrayList;
import java.util.List;

public class OrderData {
	private OrderModel order;
	private List<Observer> obs;
    private FileRW fileAlarm;
    private List<Alarm> as=new ArrayList<>();
	public OrderData() {
		super();
		this.obs = new ArrayList<>();
		fileAlarm= new FileRW("src/data/alarm");
		as = fileAlarm.readAlarms();
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
		this.order = order;
		notifyObs();
		
	}
	
	public void freeAlarm(Alarm a) {
		for(Alarm al : as) {
			if(al.getNumber() == a.getNumber()) {
				al.setAvailable(true);
				break;
			}
		}
		notifyObs();
		fileAlarm.reWriteAlarm(as);
	}
	
	public void allocateAlarm(Alarm a) {
		for(Alarm al : as) {
			if(al.getNumber() == a.getNumber()) {
				al.setAvailable(false);
				break;
			}
		}
		notifyObs();
		fileAlarm.reWriteAlarm(as);
	}
	
	public static void main(String[] args) {
		OrderData data = new OrderData();
//		AlarmManagement am = new AlarmManagement(data);
//		Bartender ba = new Bartender(data);
		
		String s1= "sting";
		String s2= "coca";
		String s3= "redbull";
		String s4= "7up";
	}
	
	
	
	
	
	
	
	
}
