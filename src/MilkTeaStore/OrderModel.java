package MilkTeaStore;

import controller.PayController;
import view.Order;
import view.Pay;

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


	// hàm lấy địa chỉ bảng của oder , copy qua Pay
	public void getCurrentTableOrder(){
		//tạo object Pay và lấy dữ liệu từ table của Order khi Pay đưuọc nhấn
		var orderData = Order.currentOrder.getPaymentTableData();
		Pay pay = new Pay(orderData);
		new PayController( pay);
		Pay.currentPay = pay;
		//lấy pay hiện tại theo order kia (để lấy bảng của nó, mối pay là 1 bảng khác nhau)
		//sau khi dừng giao diện thì sẽ reset table về 0
//          model.setRowCount(0);
	}
	
	
}
