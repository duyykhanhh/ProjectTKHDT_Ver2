package MilkTeaStore;

public interface IPriceStrategy {
	public int getPrice(double price);
	public int getPoint(double price);
}
