package catalogdatabase_mvc.model;

public class Products {
	private int productNum = 0;
	private int quantity = 0;
	private String productName = "";
	private String productDesc = "";
	private double price = 0;
	
	public Products(int productNum , String productName, double price, int quantity, String productDesc) {
		this.productNum = productNum;
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
		this.productDesc = productDesc;
	}
	
	public int getProductNum() {
		return productNum;
	}
	
	public void setProductNum(int productNum) {
		this.productNum = productNum;
	}
	
	public String getProductName() {
		return productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
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
	
	public String getProductDesc() {
		return productDesc;
	}
	
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	
	public String getProductDetails() {
		return("Product Info" + "\nProduct Number: " + getProductNum() + "\nProduct Name: " + getProductName() + "\nPrice: " + getPrice() + "\nQuantity: " + getQuantity() + "\nDescription" + getProductDesc()); 
	}
	
	public String toString() {
		return "Product Number: " + productNum + "\nProduct Name: " + productName + "\nProduct Price: " + price + "\nQuantity Available: " + quantity + "\nProduct Description: " + productDesc;
	}	
}
