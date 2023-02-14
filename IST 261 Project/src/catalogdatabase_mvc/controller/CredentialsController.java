package catalogdatabase_mvc.controller;

import java.util.HashSet;
import java.util.LinkedHashSet;
import catalogdatabase_mvc.model.Credentials;
import catalogdatabase_mvc.model.CredentialsList;
import catalogdatabase_mvc.model.Order;
import catalogdatabase_mvc.view.CredentialsDetailUI;
import catalogdatabase_mvc.view.CredentialsListUI;

public class CredentialsController {

	public LinkedHashSet<Credentials> credentialsSet;
	public CredentialsList list;
	
	public void getCredentialsListUI(LinkedHashSet<Credentials> credentialsSet, HashSet<Order> orderSet) {
		CredentialsListUI listUI = new CredentialsListUI(credentialsSet, orderSet);
	}
	
	public LinkedHashSet<Credentials> getCredentialsDetails(LinkedHashSet<Credentials> credentialsSet, HashSet<Order> orderSet, int index, int addCredentialsDialog) {
		CredentialsDetailUI detailUI = new CredentialsDetailUI(credentialsSet, orderSet, index, addCredentialsDialog);
		return credentialsSet;
	}
}
