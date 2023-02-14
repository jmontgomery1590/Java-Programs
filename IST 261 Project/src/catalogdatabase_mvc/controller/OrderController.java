package catalogdatabase_mvc.controller;

import java.util.HashSet;
import java.util.LinkedHashSet;
import catalogdatabase_mvc.model.Credentials;
import catalogdatabase_mvc.model.Order;
import catalogdatabase_mvc.model.OrderList;
import catalogdatabase_mvc.view.OrderDetailUI;
import catalogdatabase_mvc.view.OrderListUI;

public class OrderController {
	
	public HashSet<Order> orderSet;
	public OrderList list;
	
	public void getOrderListUI(LinkedHashSet<Credentials> credentialsSet, HashSet<Order> orderSet) {
		OrderListUI listUI = new OrderListUI(credentialsSet, orderSet);
	}
	
	public HashSet<Order> getOrderDetails(LinkedHashSet<Credentials> credentialsSet, HashSet<Order> orderSet, int index, int addOrderDialog) {
		OrderDetailUI detailUI = new OrderDetailUI(credentialsSet, orderSet, index, addOrderDialog);
		return orderSet;
	}
}
