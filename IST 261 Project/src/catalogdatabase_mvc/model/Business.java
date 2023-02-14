package catalogdatabase_mvc.model;

public class Business {
	private String name, industry, location;
	int numProducts;
	
	public Business(String name, String industry, String location, int numProducts) {
		this.name = name;
		this.industry = industry;
		this.location = location;
		this.numProducts = numProducts;
	}
	
	public Business() {
		name = "name";
		industry = "industry";
		location = "location";
		numProducts = 0;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getIndustry() {
		return industry;
	}
	
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	public int getNumProducts() {
		return numProducts;
	}
	
	public void setNumProducts(int numProducts) {
		this.numProducts = numProducts;
	}
	
	@Override
	public String toString() {
		return "Business Name: " + name + "\nBusiness Industry: " + industry + "\nBusiness Location; " + location + "\nNumber of Products: " + numProducts;
	}
}
