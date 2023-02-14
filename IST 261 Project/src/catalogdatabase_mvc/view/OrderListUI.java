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

import catalogdatabase_mvc.controller.OrderController;
import catalogdatabase_mvc.model.Credentials;
import catalogdatabase_mvc.model.Order;

public class OrderListUI {
	public LinkedHashSet<Credentials> credentialsList;
	public HashSet<Order> orderList;
	public DefaultTableModel tableModel;
	
	public javax.swing.JFrame listFrame;
	public javax.swing.JPanel buttonPanel;
	public javax.swing.JTable orderTable;
	public javax.swing.JButton btnAdd;
	public javax.swing.JButton btnSearch;
	public javax.swing.JButton btnQuit;
	public javax.swing.JButton btnDetails;
	public javax.swing.JScrollPane scrollPane;
	public javax.swing.JTextField searchField;
	int currentOrder = 0;
	Order tempOrder;
	
	public OrderListUI(LinkedHashSet<Credentials> credentialsSet, HashSet<Order> orderSet) {
		orderList = new HashSet<Order>(orderSet);
		
		listFrame = new JFrame();
		listFrame.getContentPane().setBackground(Color.BLUE);
		listFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Object columnNames[] = {"Order Number", "Username", "Order Total"};
		Object rowData [][] = {};
		tableModel = new DefaultTableModel(rowData, columnNames);
		orderTable = new JTable(tableModel);
		Iterator<Order> iterator = orderSet.iterator();
		
		for (int i = 0; i < orderList.size(); i++) {
			Order oList;
			while(iterator.hasNext()) {
				oList = iterator.next();
				String orderNum =oList.getOrderNum();
				String name = oList.getUsername();
				String total = oList.getTotal();
			
			tableModel.insertRow(orderTable.getRowCount(), new Object[] {orderNum, name, total});
			}
		}
		
		btnAdd = new JButton("Add New");
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				OrderController addOrder = new OrderController();
				orderList = addOrder.getOrderDetails(credentialsList, orderList, 0, 1);
				listFrame.setVisible(false);
			}
		});
		
		
		searchField = new JTextField("Please enter your exact match search");
		searchField.setBounds(210, 250, 250, 30);
		listFrame.add(searchField);
		
		btnSearch = new JButton("Search Orders");
		btnSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int oIndex = -1;
				int curIndex = 0;
				String searchString = searchField.getText();
				for (Order oList : orderList) {
					if (oList.getOrderNum().equals(searchString) || oList.getUsername().equals(searchString) || oList.getTotal().equals(searchString)) {
						oIndex = curIndex;
						OrderController newOrder = new OrderController();
						newOrder.getOrderDetails(credentialsSet, orderSet, oIndex, curIndex);
						listFrame.setVisible(false);
						System.out.println(curIndex);
					}
					curIndex++;
				}
				if(oIndex == -1) {
					JOptionPane.showMessageDialog(listFrame,  "No Orders matched your search", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnSearch.setBounds(260, 200, 100, 30);
		listFrame.add(btnSearch);
		
		btnDetails = new JButton("Details");
		btnDetails.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedOrder = orderTable.getSelectedRow();
				if(selectedOrder == -1) {
					selectedOrder = 0;
				} else {
					OrderController orderDetails = new OrderController();
					orderDetails.getOrderDetails(credentialsList, orderSet, selectedOrder, 0);
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
		
		scrollPane = new JScrollPane(orderTable);
		listFrame.add(scrollPane, BorderLayout.CENTER);
		listFrame.setSize(700, 420);
		listFrame.setVisible(true);
	}
}
