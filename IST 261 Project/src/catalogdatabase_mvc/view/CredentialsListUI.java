package catalogdatabase_mvc.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import catalogdatabase_mvc.controller.CredentialsController;
import catalogdatabase_mvc.model.Credentials;
import catalogdatabase_mvc.model.Order;

public class CredentialsListUI {
	public LinkedHashSet<Credentials> credentialsList;
	public HashSet<Order> orderList;
	public DefaultTableModel tableModel;
	
	public javax.swing.JFrame listFrame;
	public javax.swing.JPanel buttonPanel;
	public javax.swing.JTable credentialsTable;
	public javax.swing.JButton btnAdd;
	public javax.swing.JButton btnSearch;
	public javax.swing.JButton btnQuit;
	public javax.swing.JButton btnDetails;
	public javax.swing.JScrollPane scrollPane;
	public javax.swing.JTextField searchField;
	int currentCredentials = 0;
	Credentials tempCred;
	
	public CredentialsListUI(LinkedHashSet<Credentials> credentialsSet, HashSet<Order> orderSet) {
		credentialsList = new LinkedHashSet<Credentials>(credentialsSet);
		
		listFrame = new JFrame();
		listFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		listFrame.getContentPane().setBackground(Color.RED);
		
		Object columnNames[] = {"Type", "Username", "Email"};
		Object rowData [][] = {};
		
		tableModel = new DefaultTableModel(rowData, columnNames);
		credentialsTable = new JTable(tableModel);
		Iterator<Credentials> iterator = credentialsSet.iterator();
		
		for (int i = 0; i < credentialsList.size(); i++) {
			Credentials cList;
			while(iterator.hasNext()) {
				cList = iterator.next();
				String type = cList.getUserType();
				String name = cList.getUsername();
				String email = cList.getEmail();
			
			tableModel.insertRow(credentialsTable.getRowCount(), new Object[] {type, name, email});
			}
		}
		
		btnAdd = new JButton("Add New");
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CredentialsController addCredentials = new CredentialsController();
				credentialsList = addCredentials.getCredentialsDetails(credentialsList, orderList, 0, 1);
				listFrame.setVisible(false);
			}
		});
		
		
		searchField = new JTextField("Please enter your exact match search");
		searchField.setBounds(210, 250, 250, 30);
		listFrame.add(searchField);
		
		btnSearch = new JButton("Search Credentials");
		btnSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int cIndex = -1;
				int curIndex = 0;
				String searchString = searchField.getText();
				for (Credentials cList : credentialsList) {
					if (cList.getUserType().equals(searchString) || cList.getUsername().equals(searchString) || cList.getEmail().equals(searchString)) {
						cIndex = curIndex;
						CredentialsController newCredentials = new CredentialsController();
						newCredentials.getCredentialsDetails(credentialsSet, orderSet, cIndex, curIndex);
						listFrame.setVisible(false);
						System.out.println(curIndex);
					}
					curIndex++;
				}
				if(cIndex == -1) {
					JOptionPane.showMessageDialog(listFrame,  "No Credentials matched your search", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnSearch.setBounds(260, 200, 100, 30);
		listFrame.add(btnSearch);
		
				
		btnDetails = new JButton("Details");
		btnDetails.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedCredentials = credentialsTable.getSelectedRow();
				if(selectedCredentials == -1) {
					selectedCredentials = 0;
				} else {
					CredentialsController credentialsDetails = new CredentialsController();
					credentialsDetails.getCredentialsDetails(credentialsList, orderSet, selectedCredentials, 0);
					listFrame.setVisible(false);
				}
			}
		});
		
		btnQuit = new JButton("Back");
		btnQuit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				HomepageUI homeUI = new HomepageUI(credentialsSet, orderSet);
				listFrame.setVisible(false);			
			}
		});
		
		buttonPanel = new JPanel(new GridLayout(1,4));
		buttonPanel.add(btnAdd);
		buttonPanel.add(btnSearch);
		buttonPanel.add(btnDetails);
		buttonPanel.add(btnQuit);

		listFrame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
		
		scrollPane = new JScrollPane(credentialsTable);
		listFrame.add(scrollPane, BorderLayout.CENTER);
		listFrame.setSize(700, 420);
		listFrame.setVisible(true);
	}
}