package udemy.discount;

import java.util.Calendar;
import java.util.List;

public class Basket {

	private double amount;
	private List<Item> items;
	private Calendar date;

	public Basket(List<Item> itemss, Calendar date) {
		this.items = itemss;
		this.date = date;
		sumItems();
	}
	
	private void sumItems() {
		for(Item item : items) {
			amount += item.getTotalPrice();
		}
		
	}
	
	public void subtract(double amount) {
		this.amount -= amount;
	}

	public double getAmount() {
		return amount;
	}

	public int qtyOfItems() {
		int qty = 0;
		for(Item item : items) {
			qty+= item.getQty();
		}
		return qty;
	}

	public boolean has(String product) {
		for(Item item : items) {
			if(item.getName().equals(product)) return true;
		}
		
		return false;
	}
	
}