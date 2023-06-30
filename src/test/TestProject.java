package test;

import MilkTeaStore.OrderData;
import view.Bartender;
import view.Home;
import view.PayView;

public class TestProject {
	public TestProject() {
		Home home = new Home();
		home.setVisible(true);
		OrderData orderData = new OrderData();
		PayView.setOrderData(orderData);
		Bartender ba = new Bartender();
		ba.setVisible(true);
	}
public static void main(String[] args) {
	TestProject test = new TestProject();
	}
}
