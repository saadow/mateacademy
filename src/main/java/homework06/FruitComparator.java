package homework06;

import java.util.Comparator;

public class FruitComparator implements Comparator<Fruit> {

	@Override
	public int compare(Fruit arg0, Fruit arg1) {
		return arg0.getPrice() - arg1.getPrice();
	}

}
