package catalogdatabase_mvc.model;

public class VendorCredentials extends Credentials implements Login {
	private String accessLevel;
	private String welcome;

	public VendorCredentials(String userType, String username, String password, String email, String accessLevel) {
		super(userType, username, password, email);
		this.accessLevel = accessLevel;
	}
	
	public String getAccessLevel() {
		return accessLevel;
	}
	
	public void setAccessLevel(String accessLevel) {
		this.accessLevel = accessLevel;
	}
	
	public void userType() {
		System.out.println("Vendor");
	}
	
	@Override
	public String toString() {
		return "\nUser {\n" + super.toString() + " " + "\nAccess Level: " + accessLevel + "}";
	}

	@Override
	public void login() {
		welcome = "Thank you for logging in. You now have vendor access over your catalog.";
	}

	@Override
	public void loginSetup() {
		System.out.println(this.toString());
		System.out.println(welcome);
	}
}
