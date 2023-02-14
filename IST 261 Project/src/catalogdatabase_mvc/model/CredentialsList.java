package catalogdatabase_mvc.model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedHashSet;

public class CredentialsList implements Serializable{
	private LinkedHashSet<Credentials> setOfCredentials = new LinkedHashSet<>();
	private String credentialsFileName = "listOfCredentials.ser";
			
	public CredentialsList() {
		this.readFile();
		if(setOfCredentials.isEmpty() || setOfCredentials == null) {
			this.createTestCredentials();
			this.writeFile();
			this.readFile();
		}
	}
	
	public LinkedHashSet<Credentials> getSet() {
		return setOfCredentials;
	}
	
	public void createTestCredentials() {
		for (int i = 0; i < 10; i++) {
			int i2 = (i + 1);
			setOfCredentials.add(new Credentials("Credential Type " + i2, "User " + i2, "Password " + i2, "Email " + i2));	
		}
	}
	
	public void readFile() {
	    FileInputStream fileIn = null;
	    ObjectInputStream objIn = null;
	    try {
	        fileIn = new FileInputStream(credentialsFileName);
	        objIn = new ObjectInputStream(fileIn);
	        setOfCredentials = (LinkedHashSet<Credentials>)objIn.readObject();
	        objIn.close();
	    } catch (FileNotFoundException fnfe) {
	        System.out.println("File was not found, a new one will be created");
	    } catch (IOException ex) {
	        ex.printStackTrace();
	    } catch (ClassNotFoundException cnfe) {
	        cnfe.printStackTrace();
	    }
	}
	
	public void writeFile() {
	    FileOutputStream fileOut = null;
	    ObjectOutputStream objOut = null;
	    
	    try {
	        fileOut = new FileOutputStream(credentialsFileName);
	        objOut = new ObjectOutputStream(fileOut);
	        objOut.writeObject(setOfCredentials);
	        objOut.close();
	    } catch (IOException ex) {
	        ex.printStackTrace();
	    }
	}
}
