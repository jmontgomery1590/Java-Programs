package catalogdatabase_mvc.model;
public class User {
	private String name, location, contactInfo;
	
	public User(String name, String location, String contactInfo) {
		this.name = name;
		this.location = location;
		this.contactInfo = contactInfo;
	}
	
	public User() {
		name = "name";
		location = "location";
		contactInfo = "contact info";
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	public String getContactInfo() {
		return contactInfo;
	}
	
	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}
	
	@Override
	public String toString() {
		return "User's Name: " + name + "\nUser's Location: " + location + "\nContact Information: " + contactInfo;
	}
}
