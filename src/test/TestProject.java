package test;

import MilkTeaStore.OrderData;
import view.Bartender;
import view.Home;
import view.PayView;

public class TestProject {
	public TestProject() {
		
//		NEN KIEM TRA DUONG DAN DEN FILE DATA TRUOC KHI CHAY THU CODE
		
//		duong dan den folder data tren window, eclipse : "src/data"
		String urlRoot="src/data";
		Home.setUrlRoot(urlRoot);
		Home home = new Home();
		home.setUrlRoot(urlRoot);
		home.setVisible(true);
		OrderData orderData = new OrderData();
		PayView.setOrderData(orderData);
		Bartender ba = new Bartender();
//		ba.setUrlRoot(urlRoot);
		ba.setVisible(true);
	}
public static void main(String[] args) {
	TestProject test = new TestProject();
	}
}
