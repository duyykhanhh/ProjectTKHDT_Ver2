package MilkTeaStore;

public class Alarm {
	private int number;
	private boolean available;
	public Alarm(int number, boolean available) {
		super();
		this.number = number;
		this.available = available;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	
	public void ring() {
		System.out.println("ring ring ring ring...");
	}
}
