package MilkTeaStore;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class RevenueToday {
	private Timee time;
	private double money;

	public RevenueToday(double money) {
		super();
		time = new Timee();	
		this.money = money;
	}
	
	

	public RevenueToday(Timee time, double money) {
		super();
		this.time = time;
		this.money = money;
	}



	public Timee getTime() {
		return time;
	}

	public void setTime(Timee time) {
		this.time = time;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}
	
	public String toString() {
		return time.toString() +";" + money;
	}
	
}
	






