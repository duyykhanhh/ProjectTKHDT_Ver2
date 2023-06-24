package MilkTeaStore;

public class Employee {
	private String emID, emName;
	private int emGrade;
	private boolean isWork;
	private String pwd;
	public Employee(String emID, String emName, int emGrade, boolean isWork, String pwd) {
		super();
		this.emID = emID;
		this.emName = emName;
		this.emGrade = emGrade;
		this.isWork = isWork;
		this.pwd = pwd;
	}
	public String getEmID() {
		return emID;
	}
	public void setEmID(String emID) {
		this.emID = emID;
	}
	public String getEmName() {
		return emName;
	}
	public void setEmName(String emName) {
		this.emName = emName;
	}
	public int getEmGrade() {
		return emGrade;
	}
	public void setEmGrade(int emGrade) {
		this.emGrade = emGrade;
	}
	public boolean isWork() {
		return isWork;
	}
	public void setWork(boolean isWork) {
		this.isWork = isWork;
	}
	
	
	

	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String toString() {
		return emID + ";" + emName + ";" + emGrade +";" + isWork +";" + pwd;  
	}
	
}
