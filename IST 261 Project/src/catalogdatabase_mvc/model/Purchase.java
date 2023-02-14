package catalogdatabase_mvc.model;
public class Purchase {
	private double price;
	private int quantity;
	
	public Purchase(double price, int quantity) {
		this.price = price;
		this.quantity = quantity;
	}
	
	public Purchase() {
		price = 0.0;
		quantity = 0;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return "Purchased Price: " + price + "\nQuantity Purchased: " + quantity;
	}
}
