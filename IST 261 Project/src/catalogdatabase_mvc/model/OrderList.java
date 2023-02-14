package catalogdatabase_mvc.model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashSet;

public class OrderList implements Serializable{
	private Order order;
	private HashSet<Order> listOfOrders = new HashSet<Order>();
	private String ordersFileName = "listOfOrders.ser";
	
	
	public OrderList() {
		this.readFile();
		if(listOfOrders.isEmpty() || listOfOrders == null) {
			this.createTestOrders();
			this.writeFile();
			this.readFile();
		}
	}
	
	public HashSet<Order> getSet() {
		return listOfOrders;
	}
	
	public void createTestOrders() {
		for (int i = 0; i < 10; i++) {
			int i2 = (i + 1);
			String i3 = String.format("%.2f", i2 * 9.99);
			listOfOrders.add(new Order("Order Number " + i2, "User " + i2, "$" + (i3)));
			
		}
	}
	
	public void readFile() {
	    FileInputStream fileIn = null;
	    ObjectInputStream objIn = null;
	    try {
	        fileIn = new FileInputStream(ordersFileName);
	        objIn = new ObjectInputStream(fileIn);
	        listOfOrders = (HashSet<Order>) objIn.readObject();
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
	        fileOut = new FileOutputStream(ordersFileName);
	        objOut = new ObjectOutputStream(fileOut);
	        objOut.writeObject(listOfOrders);
	        objOut.close();
	    } catch (IOException ex) {
	        ex.printStackTrace();
	    }
	}
}
