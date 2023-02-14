package catalogdatabase_mvc;

import java.util.HashSet;
import java.util.LinkedHashSet;
import catalogdatabase_mvc.controller.OrderController;
import catalogdatabase_mvc.model.Credentials;
import catalogdatabase_mvc.model.CredentialsList;
import catalogdatabase_mvc.model.Order;
import catalogdatabase_mvc.model.OrderList;
import catalogdatabase_mvc.controller.CredentialsController;
import catalogdatabase_mvc.view.HomepageUI;

public class Main {

	public static void main(String[] args) {
		CredentialsList credentialsList = new CredentialsList();
		OrderList orderList = new OrderList();
		
		LinkedHashSet<Credentials> credentialsSet = credentialsList.getSet();
		HashSet<Order> orderSet = orderList.getSet();
		
		CredentialsController credentialsCntl = new CredentialsController();
		OrderController orderCntl = new OrderController();
		
		HomepageUI homeUI = new HomepageUI(credentialsSet, orderSet);
	}
}
