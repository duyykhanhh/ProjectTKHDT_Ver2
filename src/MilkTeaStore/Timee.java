package MilkTeaStore;

import java.util.Calendar;

public class Timee {
	private int hour, minute, second;
	private Calendar cal = Calendar.getInstance();

	public Timee() {
		super();
		this.hour = cal.getTime().getHours();	
		this.minute = cal.getTime().getMinutes();
		this.second = cal.getTime().getSeconds();
	}
	
	

	public Timee(int hour, int minute, int second) {
		super();
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}



	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		this.second = second;
	}
	
	public String toString() {
		String hh,mm,ss;
		if(hour<10)
			hh="0" + hour;
		else 
			hh=hour+"";
		
		if(minute<10)
			mm="0" + minute;
		else 
			mm=minute+"";
		
		if(second <10)
			ss= "0" + second;
		else 
			ss=second+"";
		
		return hh+":"+mm+":"+ss;
	}
	
	public static void main(String[] args) {
		Timee time = new Timee();
		System.out.println(time);
	}
}
