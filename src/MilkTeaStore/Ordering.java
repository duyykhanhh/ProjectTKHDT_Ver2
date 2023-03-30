package MilkTeaStore;

import java.util.List;

import javax.management.DescriptorAccess;
import javax.xml.crypto.Data;

public class Ordering implements IServiceObserver{
	private String cusId;
	private List<Drink> drinks;
	private IPayStrategy pay;
	private String address;
	private Data date;
	private OrderData orderData;
	public Ordering(OrderData orderData) {
		super();
		this.orderData = orderData;
		orderData.registerServer(this);
	}
	@Override
	public void update(String cusId, List<Drink> drinks, String address) {
		// TODO Auto-generated method stub
		
	}
	public String getCusId() {
		return cusId;
	}
	public List<Drink> getDrinks() {
		return drinks;
	}
	public OrderData getOrderData() {
		return orderData;
	}
	
	//chuyển đơn hàng lên orderData
	public void setOrderData(String cusId, List<Drink> drinks, String address) {
		orderData.setCusId(cusId);
		orderData.setDrinks(drinks);
		orderData.setAddress(address);
		
		//kêu cái orderData thông báo cho mấy cái service
		orderData.orderChanged();
	}
	
	
	
	
	
	
	
	
}
