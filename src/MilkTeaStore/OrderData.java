package MilkTeaStore;

import java.util.ArrayList;
import java.util.List;

public class OrderData {
	private static OrderModel order;
	private static List<Observer> obs;
    private FileRW fileAlarm;
    private List<Alarm> as=new ArrayList<>();
	public OrderData() {
		super();
		this.obs = new ArrayList<>();
		fileAlarm= new FileRW("src/data/alarm");
		as = fileAlarm.readAlarms();
	}
	
	public static void registerObserver(Observer o) {
		obs.add(o);
	}
	
	public static void removeObserver(Observer o) {
		obs.remove(o);
	}
	
	public void notifyObs() {
		for(Observer o : obs) {
			o.update(order);
		}
	}

	public static OrderModel getOrder() {
		return order;
	}

	public void setOrder(OrderModel order) {
		this.order = order;
		orderChanged();
		
	}
	
	public void orderChanged() {
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
	
	
	
	public static List<Observer> getObs() {
		return obs;
	}

	public static void setObs(List<Observer> obs) {
		OrderData.obs = obs;
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
