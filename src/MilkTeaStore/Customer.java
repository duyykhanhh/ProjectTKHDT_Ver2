package MilkTeaStore;

public class Customer {
	private String cusId;
	private int point;
	private String pwd;
	public Customer(String cusId, int point, String pwd) {
		super();
		this.cusId = cusId;
		this.point = point;
		this.pwd = pwd;
	}
	public String getCusId() {
		return cusId;
	}
	public void setCusId(String cusId) {
		this.cusId = cusId;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String toString() {
		return cusId + ";" + point + ";" + pwd;
	}
	
	
}
