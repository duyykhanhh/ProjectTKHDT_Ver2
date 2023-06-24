package MilkTeaStore;

import view.Home;

public class ManagementModel {
	private Home home;
	private ManagementModel management;
	private Ingredient ingredient;
	private Employee employee;
//	private Customer customer;
	public ManagementModel(Home home, ManagementModel management, Ingredient ingredient, Employee employee) {
		super();
		this.home = home;
		this.management = management;
		this.ingredient = ingredient;
		this.employee = employee;

	}
	
	
}
