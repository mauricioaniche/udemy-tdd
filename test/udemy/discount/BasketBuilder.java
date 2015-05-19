package udemy.discount;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class BasketBuilder {

	private List<Item> items;
	private Calendar date;
	
	public BasketBuilder() {
		this.items = new ArrayList<Item>();
		date = Calendar.getInstance();
	}
	
	public BasketBuilder w(String name, double price) {
		return w(name, 1, price);
	}

	public BasketBuilder w(String name, int qty, double price) {
		items.add(new Item(name, qty, price));
		return this;
	}

	public Basket build() {
		return new Basket(items, date);
	}

}
