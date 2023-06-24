package MilkTeaStore;

public class Ingredient {
	private String name;
	private double amount;
	private String unit;
	private boolean stock;
	public Ingredient(String name, double amount, String unit, boolean stock) {
		super();
		this.name = name;
		this.amount = amount;
		this.unit = unit;
		this.stock = stock;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public boolean isStock() {
		return stock;
	}
	public void setStock(boolean stock) {
		this.stock = stock;
	}
	
	public String toString() {
		return name + ";" + amount +";" + unit +";" + stock;
	}
	
}
