package udemy.discount;

public class Item {

	private final String name;
	private final int qty;
	private final double unitPrice;
	
	public Item(String name, int qty, double price) {
		this.name = name;
		this.qty = qty;
		this.unitPrice = price;
	}
	public String getName() {
		return name;
	}
	public int getQty() {
		return qty;
	}
	public double getUnitPrice() {
		return unitPrice;
	}

	public double getTotalPrice() {
		return unitPrice * qty;
	}
	
}