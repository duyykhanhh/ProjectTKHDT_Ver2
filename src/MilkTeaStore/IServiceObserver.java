package MilkTeaStore;

import java.beans.Customizer;
import java.util.List;

public interface IServiceObserver {
	public void update(String cusId, List<Drink> drinks, String address);
}
