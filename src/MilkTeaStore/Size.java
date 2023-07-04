package MilkTeaStore;

import view.Home;

public class Size {
	private static FileRW filePrice = new FileRW(Home.getUrlRoot() +"/priceUnit");
	private static double s= filePrice.readPriceUnit("small");
	private static double m= filePrice.readPriceUnit("medium");
	private static double l= filePrice.readPriceUnit("large");

	
public static String getDescription(Object o) {
	if(o instanceof Small) {
		return "size S";
	}
	else if(o instanceof Medium) {
		 return "size M";
	}
	else if(o instanceof Large) {
		return "size L";
	}
	return null;
	
}
public static double getPrice(Object o) {
//	double result=1;
	if(o instanceof Small) {
//		return filePrice.readPriceUnit("small");
//		result = filePrice.readPriceUnit("small");
//		return small;
		return 1;
	}
	else if(o instanceof Medium) {
//		return filePrice.readPriceUnit("medium");
		return 1.2;
	}
	else if(o instanceof Large) {
//		return filePrice.readPriceUnit("large");
		return 1.5;
	}
	return 0;
}
}
