package MilkTeaStore;

public class Voucher {
	private String str;
	private boolean available;
	public Voucher(String str, boolean available) {
		super();
		this.str = str;
		this.available = available;
	}
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	
	public String toString() {
		return str +";" + available;
	}
}
