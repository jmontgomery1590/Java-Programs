package catalogdatabase_mvc.model;

import java.io.Serializable;
import java.util.LinkedList;

public class Credentials implements Serializable{
	private String userType = "usertype";
	private String username = "username";
	private String password = "password";
	private String email = "email";
	private LinkedList<User> user;
	
	public Credentials(String userType, String username, String password, String email) {
		this.userType = userType;
		this.username = username;
		this.password = password;
		this.email = email;
	}

	public Credentials() {
		// TODO Auto-generated constructor stub
	}

	public String getUserType() {
		return userType;
	}
	
	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getCredentialsDetails() {
		return("Credential Info" + "\nUser Type: " + getUserType() + "\nUsername: " + getUsername() + "\nPassword: " + getPassword() + "\nEmail: " + getEmail()); 
	}
	
	@Override
	public String toString() {
		return "User Type: " + userType + "\nUsername: " + username + "\nPassword: " + password + "\nEmail: " + email;
	}
}
