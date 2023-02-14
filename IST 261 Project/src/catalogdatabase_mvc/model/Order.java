package catalogdatabase_mvc.model;

import java.io.Serializable;
import java.util.LinkedList;

public class Order implements Serializable {
	private String orderNum = "";
	private String  username= "";
	private String total = "";
	public LinkedList<Products> products;
	
	public Order(String orderNum, String username, String total) {
		this.orderNum = orderNum;
		this.username = username;
		this.total = total;
	}

	public String getOrderNum() {
		return orderNum;
	}
	
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getTotal() {
		return total;
	}
	
	public void setTotal(String total) {
		this.total = total;
	}
	
	public String getOrderDetails() {
		return("Order Info" + "\nOrder Number: " + getOrderNum() + "\nUser Name: " + getUsername() + "\nOrder Total: " + getTotal());
	}
	
	public String toString() {
		return ("Order Number: " + orderNum + "\nUser Name: " + username + "\nOrder Total: " + total);
	}
}
