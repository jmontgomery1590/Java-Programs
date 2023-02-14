package catalogdatabase_mvc.model;

public class ConsumerCredentials extends Credentials implements Login {
	private int purchaseTotal;
	private String welcome;

	public ConsumerCredentials(String userType, String username, String password, String email, int purchaseTotal) {
		super(userType, username, password, email);
		this.purchaseTotal = purchaseTotal;
	}
	
	public int getPurchaseTotal() {
		return purchaseTotal;
	}
	
	public void setAccessLevel(int purchaseTotal) {
		this.purchaseTotal = purchaseTotal;
	}
	
	public void userType() {
		System.out.println("Consumer");
	}
	
	@Override
	public String toString() {
		return "\nUser {\n" + super.toString() + " " + "\nPurchase Total: " + purchaseTotal + "}";
	}

	@Override
	public void login() {
		welcome = "Welcome. Thank you for logging in.";
	}

	@Override
	public void loginSetup() {
		System.out.println(this.toString());
		System.out.println(welcome);
	}

}
