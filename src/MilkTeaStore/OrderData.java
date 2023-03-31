package MilkTeaStore;

import java.beans.Customizer;
import java.util.List;

public class OrderData implements IServiceObservable{
	private String cusId;
	private List<Drink> drinks;
	private String table;
	private List<IServiceObserver> services;
	public OrderData(String cusId, List<Drink> drinks, String table, List<IServiceObserver> services) {
		super();
		this.cusId = cusId;
		this.drinks = drinks;
		this.table = table;
		this.services = services;
	}
	@Override
	public void registerServer(IServiceObserver service) {
		// TODO Auto-generated method stub
		services.add(service);
	}
	@Override
	public void removeServer(IServiceObserver service) {
		// TODO Auto-generated method stub
		services.remove(service);
	}
	
	
	public String getCusId() {
		return cusId;
	}
	public List<Drink> getDrinks() {
		return drinks;
	}
	public String getTable() {
		return table;
	}
	@Override
	public void nofity() {
		// TODO Auto-generated method stub
		for(IServiceObserver oser: services)
			oser.update(getCusId(), getDrinks(), getTable());
	}
	public void setCusId(String cusId) {
		this.cusId = cusId;
	}
	public void setDrinks(List<Drink> drinks) {
		this.drinks = drinks;
	}
	public void setTable(String table) {
		this.table = table;
	}
	
	public void orderChanged() {
		notify();
	}
	
}
