package MilkTeaStore;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class FileRW {
	private String url;

	public FileRW(String url) {
		super();
		this.url = url;
	}
	
	public static void main(String[] args) {
		List<Employee> test = new ArrayList<>();
		FileRW filetest= new FileRW("src/employee");
		test= filetest.readEm();
		for(Employee em: test) {
			System.out.println(em);
		}
//		Employee em = new Employee("hehe", "nguye thi he", 1, true, "hihi");
//		filetest.writeEm(em);
//		filetest.writeEm(em);
//		filetest.writeEm(em);
//		filetest.writeEm(em);
//		Date date = new Date();
//		Calendar time = Calendar.getInstance();
		FileRW filetest1= new FileRW("src/RevenueToday");
		RevenueToday today = new RevenueToday(10);
		List<RevenueToday> todays = new ArrayList<>();
		todays.add(today);
		filetest1.writeRevenueToday(today);
		todays = filetest1.readToday();
		for(RevenueToday today1 : todays) {
			System.out.println(today1);
		}
		
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	public void writeEm(Employee em) {
		try {
			FileWriter fw = new FileWriter(url,true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(em.toString());
			bw.newLine();
			bw.close();
			fw.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void writeEmNew(Employee em) {
		try {
			FileWriter fw = new FileWriter(url);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(em.toString());
			bw.newLine();
			bw.close();
			fw.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void reWriteEm(List<Employee> ems) {
		writeEmNew(ems.get(0));
		for(int i=1; i< ems.size();i++) {
			writeEm(ems.get(i));
		}
	}
	
	public List<Employee> readEm() {
		List<Employee> ems = new ArrayList<>();
		try {
			FileReader fr = new FileReader(url);
			BufferedReader br = new BufferedReader(fr);
			String line = "";
			while(true) {
				line = br.readLine();
				if(line == null)
					break;
				String info[] = line.split(";");
				String id = info[0];
				String name = info[1];
				int grade = Integer.parseInt(info[2]);
				String strWorking = info[3];
				boolean isWorking;
				if(strWorking.equals("true"))
					isWorking=true;
				else
					isWorking=false;
				String pwd = info[4];
				Employee em = new Employee(id, name, grade, isWorking, pwd);
				ems.add(em);
				
			}	
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return ems;
	}
	
	public void writeCus(Customer cus) {
		try {
			FileWriter fw = new FileWriter(url, true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(cus.toString());
			bw.newLine();
			bw.close();
			fw.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public List<Customer> readCus() {
		List<Customer> cuses = new ArrayList<>();
		try {
			FileReader fr = new FileReader(url);
			BufferedReader br = new BufferedReader(fr);
			String line="";
			while(true) {
				line = br.readLine();
				if(line == null)
					break;
				String info[] = line.split(";");
				String id = info[0];
				int point = Integer.parseInt(info[1]);
				String pwd = info[2];
				Customer cus = new Customer(id, point, pwd);
				cuses.add(cus);
			}
				
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return cuses;
	}
	
//	ingredient
	public void writeIngre(Ingredient in) {
		try {
			FileWriter fw = new FileWriter(url, true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(in.toString());
			bw.newLine();
			bw.close();
			fw.close();
		
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void writeIngreNew(Ingredient in) {
		try {
			FileWriter fw = new FileWriter(url);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(in.toString());
			bw.newLine();
			bw.close();
			fw.close();
		
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public List<Ingredient> readIngre() {
		List<Ingredient> ins = new ArrayList<>();
		try {
			FileReader fr = new FileReader(url);
			BufferedReader br = new BufferedReader(fr);
			String line="";
			while(true) {
				line = br.readLine();
				if(line == null)
					break;
				String info[] = line.split(";");
				String name = info[0];
				double amount = Double.parseDouble(info[1]);
				String unit = info[2];
				String txt = info[3];
				boolean stock;
				if(txt.equals("true"))
					stock = true;
				else 
					stock = false;
				Ingredient in = new Ingredient(name, amount, unit, stock);
				ins.add(in);
				
				
			}
	
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return ins;
	}
	
	public void writeRevenueToday(RevenueToday today) {
		try {
			FileWriter fw = new FileWriter(url,true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(today.toString());
			bw.newLine();
			bw.close();
			fw.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public List<RevenueToday> readToday(){
		List<RevenueToday> todays = new ArrayList<>();
		try {
			FileReader fr =  new FileReader(url);
			BufferedReader br =  new BufferedReader(fr);
			String line="";
			while(true) {
				line = br.readLine();
				if(line == null)
					break;
				String info[] = line.split(";");
				String time[] = info[0].split(":");
				int hour = Integer.parseInt(time[0]);
				int minute = Integer.parseInt(time[1]);
				int second = Integer.parseInt(time[2]);
				Timee timee = new Timee(hour, minute, second);
				
				double money = Double.parseDouble(info[1]);
				
				RevenueToday today = new RevenueToday(timee, money);		
				todays.add(today);
				

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return todays;
	}
	
	public void writeNewRevenueDay() {
		try {
			RevenueToday today = new RevenueToday(0);
			FileWriter fw = new FileWriter(url);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(today.toString());
			bw.newLine();
			bw.close();
			fw.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void writeRevenueTotal(RevenueTotal total) {
		try {
			FileWriter fw = new FileWriter(url,true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(total.toString());
			bw.newLine();
			bw.close();
			fw.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public List<RevenueTotal> readTotal() {
		List<RevenueTotal> totals = new ArrayList<>();
		try {
			FileReader fr = new FileReader(url);
			BufferedReader br = new BufferedReader(fr);
			String line="";
			while(true) {
				line = br.readLine();
				if(line == null)
					break;
				String info[] = line.split(";");
				String date[] = info[0].split("/");
				int day = Integer.parseInt(date[0]);
				int month = Integer.parseInt(date[1]);
				int year = Integer.parseInt(date[2]);
				
				Datee datee = new Datee(day, month, year);
				double money = Double.parseDouble(info[1]);
				
				RevenueTotal total = new RevenueTotal(datee, money);
				totals.add(total);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return totals;
	}

}
