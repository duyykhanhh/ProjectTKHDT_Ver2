package MilkTeaStore;

import java.util.List;

public class WaiterService implements IServiceObserver{
	private OrderData orderData;
	private String table;
	public DeliveryService(OrderData orderData) {
		super();
		this.orderData = orderData;
		orderData.registerServer(this);
	}
	@Override
	public void update(String cusId, List<Drink> drinks, String table) {
		// TODO Auto-generated method stub
		this.table=table;
		this.DeliveryDrink();
	}

	public void DeliveryDrink(){
		Systemp.out.println("Ban " + this.table + " da duoc giao nuoc");
	}
	
}
