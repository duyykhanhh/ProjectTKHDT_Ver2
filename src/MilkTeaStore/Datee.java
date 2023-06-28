package MilkTeaStore;

import java.util.Calendar;

public class Datee {
	private int day,month,year;
	private Calendar cal = Calendar.getInstance();
	
	public Datee() {
		super();
		this.day = cal.get(Calendar.DATE);
		this.month = cal.get(Calendar.MONDAY)+1;
		this.year = cal.get(Calendar.YEAR);
	}

	public Datee(int day, int month, int year) {
		super();
		this.day = day;
		this.month = month;
		this.year = year;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	public String toString() {
		String dd,mm;
		if(day < 10)
			dd= "0" + day;
		else
			dd=day+"";
		
		if(month < 10)
			mm= "0" + month;
		else
			mm=month+"";
	
		return dd + "/" + mm +"/" + year;
		
		
		
	}
	
	

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	public static void main(String[] args) {
		System.out.println(new Datee().toString());
	}
	
	
	
	
}
