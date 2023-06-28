package MilkTeaStore;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MilkTeaStore {
	private List<Ingredient> ins = new ArrayList<>();
	private List<Employee> ems = new ArrayList<>();
	private List<Customer> cuses = new ArrayList<>();
	private List<RevenueToday> todays = new ArrayList<>();
	private List<RevenueTotal> totals = new ArrayList<>();
	public MilkTeaStore() {
		super();
	}
	public List<Ingredient> getIns() {
		return ins;
	}
	public void setIns(List<Ingredient> ins) {
		this.ins = ins;
	}
	public List<Employee> getEms() {
		return ems;
	}
	public void setEms(List<Employee> ems) {
		this.ems = ems;
	}
	public List<Customer> getCuses() {
		return cuses;
	}
	public void setCuses(List<Customer> cuses) {
		this.cuses = cuses;
	}
	public List<RevenueToday> getTodays() {
		return todays;
	}
	public void setTodays(List<RevenueToday> todays) {
		this.todays = todays;
	}
	public List<RevenueTotal> getTotals() {
		return totals;
	}
	public void setTotals(List<RevenueTotal> totals) {
		this.totals = totals;
	}
	
	
	

}
