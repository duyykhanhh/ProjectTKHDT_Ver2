package MilkTeaStore;

public class RevenueTotal {
	private Datee date;
	private double total;
	public RevenueTotal(Datee date, double total) {
		super();
		this.date = date;
		this.total = total;
	}
	public RevenueTotal(double total) {
		super();
		this.date = new Datee();
		this.total = total;
	}
	public Datee getDate() {
		return date;
	}
	public void setDate(Datee date) {
		this.date = date;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
	public String toString() {
		return date.toString() +";"+ total;
	}
	
	
}
