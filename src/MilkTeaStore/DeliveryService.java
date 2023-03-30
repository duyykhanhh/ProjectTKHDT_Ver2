package MilkTeaStore;

import java.util.List;

public class DeliveryService implements IServiceObserver{
	private OrderData orderData;
	private String address;
	public DeliveryService(OrderData orderData) {
		super();
		this.orderData = orderData;
		orderData.registerServer(this);
	}
	@Override
	public void update(String cusId, List<Drink> drinks, String address) {
		// TODO Auto-generated method stub
		
	}
	
}
