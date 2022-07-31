package csvmodifier;

public class CSVInfo implements Comparable<CSVInfo> { //Sets up Class to take in CSV parameters and separate into individual variables to be used by program.
	private String userID;
	private String firstName;
	private String lastName;
	private int version;
	private String insCompany;
	
	public CSVInfo(String userID, String firstName, String lastName, int version, String insCompany) { //Constructor for CSVInfo objects that take in parameters and assigns instance variables as the parameter values.
		super();
		this.userID = userID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.version = version;
		this.insCompany = insCompany;
	}
	
	public String toString() { //Combines all variables into a single String.
		return userID + "," + firstName + "," + lastName + "," + version + "," + insCompany;
	}
	
	public int compareTo(CSVInfo info) { //Compares last names to sort by when writing info to new files.
		return this.getLastName().compareTo(info.getLastName());
	}
	
	public String getUserID() {
		return userID;
	}
	
	public void setUserID(String userID) {
		this.userID = userID;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public int getVersion() {
		return version;
	}
	
	public void setVersion(int version) {
		this.version = version;
	}
	
	public String getInsCompany() {
		return insCompany;
	}
	
	public void setInsCompany(String insCompany) {
		this.insCompany = insCompany;
	}
}
