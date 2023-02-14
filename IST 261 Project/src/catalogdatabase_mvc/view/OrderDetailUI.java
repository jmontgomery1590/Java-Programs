package catalogdatabase_mvc.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import catalogdatabase_mvc.model.Credentials;
import catalogdatabase_mvc.model.Order;

public class OrderDetailUI {
	public javax.swing.JFrame detailFrame;
	public javax.swing.JPanel buttonPanel;
	public javax.swing.JLabel numLabel;
	public javax.swing.JLabel nameLabel;
	public javax.swing.JLabel totalLabel;
	public javax.swing.JLabel titleLabel;
	public javax.swing.JLabel exitLabel;
	public javax.swing.JTextField numField;
	public javax.swing.JTextField nameField;
	public javax.swing.JTextField totalField;
	public javax.swing.JButton btnNext;
	public javax.swing.JButton btnPrevious;
	public javax.swing.JButton btnUpdate;
	public javax.swing.JButton btnDelete;
	public javax.swing.JButton btnQuit;
	String orderNum;
	String username;
	String total;
	int currentOrder = 0;
	
	public OrderDetailUI(LinkedHashSet<Credentials> credentialsSet, HashSet<Order> orderSet, int selectedOrder, int addOrderDialog) {
		ArrayList<Order> listOfOrders = new ArrayList<>(orderSet);
		currentOrder = selectedOrder;
		
		orderNum = listOfOrders.get(currentOrder).getOrderNum();
		username = listOfOrders.get(currentOrder).getUsername();
		total = listOfOrders.get(currentOrder).getTotal();
		
		detailFrame = new JFrame("Order List");
		detailFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		titleLabel = new JLabel("Order: " + (currentOrder + 1) + "/" + listOfOrders.size());
		titleLabel.setBounds(150, 50, 200, 30);
		
		numField = new JTextField(orderNum);
		numLabel = new JLabel("Order Number: ");
		numField.setBounds(90, 100, 200, 30);
		numLabel.setBounds(10, 100, 90, 30);
		
		nameField = new JTextField(username);
		nameLabel = new JLabel("Username: ");
		nameField.setBounds(90, 150, 200, 30);
		nameLabel.setBounds(10, 150, 90, 30);
		
		totalField = new JTextField(total);
		totalLabel = new JLabel("Order Total: ");
		totalField.setBounds(90, 200, 200, 30);
		totalLabel.setBounds(10, 200, 90, 30);
		
		
		btnNext = new JButton ("Next");
		btnNext.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				currentOrder++;
				orderNum = listOfOrders.get(currentOrder).getOrderNum();
				username = listOfOrders.get(currentOrder).getUsername();
				total = listOfOrders.get(currentOrder).getTotal();
				numField.setText(orderNum);
				nameField.setText(username);
				totalField.setText(total);
				
				btnPrevious.setEnabled(true);
				if(currentOrder == listOfOrders.size() - 1)
					btnNext.setEnabled(false);
				
				titleLabel.setText("Order: " + (currentOrder + 1) + "/" + listOfOrders.size());
			}
		});
		
		btnPrevious = new JButton ("Previous");
		btnPrevious.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				currentOrder--;
				orderNum = listOfOrders.get(currentOrder).getOrderNum();
				username = listOfOrders.get(currentOrder).getUsername();
				total = listOfOrders.get(currentOrder).getTotal();
				numField.setText(orderNum);
				nameField.setText(username);
				totalField.setText(total);
				
				btnNext.setEnabled(true);
				if(currentOrder == 0)
					btnPrevious.setEnabled(false);
				
				titleLabel.setText("Credentials: " + (currentOrder + 1) + "/" + listOfOrders.size());
			}
		});
		
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				orderNum = JOptionPane.showInputDialog(detailFrame, "Change Order Number" + "\nLeave Blank to Leave Unchanged");
				username = JOptionPane.showInputDialog(detailFrame, "Change Username" + "\nLeave Blank to Leave Unchanged");
				total = JOptionPane.showInputDialog(detailFrame, "Change Total" + "\nLeave Blank to Leave Unchanged");
				
				if(orderNum == null || username == null || total == null) 
					JOptionPane.showMessageDialog(detailFrame, "Cancelled", "Error", JOptionPane.ERROR_MESSAGE);
				else {
					if(!orderNum.isEmpty()) {
						listOfOrders.get(currentOrder).setOrderNum(orderNum);
						numField.setText(orderNum);
					}
					if(!username.isEmpty()) {
						listOfOrders.get(currentOrder).setUsername(username);
						nameField.setText(username);
					}
					if(!total.isEmpty()) {
						listOfOrders.get(currentOrder).setTotal(total);
						totalField.setText(total);
					}
				}
				titleLabel.setText("Order: " + (currentOrder + 1) + "/" + listOfOrders.size());
			}
		});
		
		btnQuit = new JButton("Back");
		btnQuit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				OrderListUI listUI = new OrderListUI(credentialsSet, orderSet);
				detailFrame.setVisible(false);
			}
		});
		
		if(addOrderDialog == 1) {
			
			orderNum = JOptionPane.showInputDialog(detailFrame, "New Order Number");
			username = JOptionPane.showInputDialog(detailFrame, "New Username");
			total = JOptionPane.showInputDialog(detailFrame, "New Total");
			
			if(orderNum == null || username == null || total == null) {
				JOptionPane.showMessageDialog(detailFrame, "Cancelled", "Error", JOptionPane.ERROR_MESSAGE);
			}
			else if(!orderNum.isEmpty() && !username.isEmpty() && !total.isEmpty()) {
				Order order = new Order(orderNum, username, total);
				listOfOrders.add(order);
				orderSet.add(order);
				numField.setText(orderNum);
				nameField.setText(username);
				totalField.setText(total);
				currentOrder = listOfOrders.size() - 1;
			
			
				if(listOfOrders.size() == 1) {
					btnNext.setEnabled(false);
					btnPrevious.setEnabled(false);
				}
			
				else {
					btnNext.setEnabled(false);
					btnPrevious.setEnabled(true);
				}
			}
		
			else {
				StringBuilder error = new StringBuilder();
				if(orderNum.isEmpty()) 
					error.append("Order Number");
				if(username.isEmpty())
					error.append("Username");
				if(total.isEmpty())
					error.append("Total");
			
				JOptionPane.showMessageDialog(detailFrame, "Fields Left Blank: " + error, "Error", JOptionPane.WARNING_MESSAGE);
			}
			titleLabel.setText("Credentials: " + (currentOrder + 1) + "/" + listOfOrders.size());
		}
	
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int choice = JOptionPane.showConfirmDialog(detailFrame, "Are you sure you want to delete this credential?", "Confirm delete", JOptionPane.YES_NO_OPTION);
				if(choice == 0) {
					if(listOfOrders.size() == 0 && choice == 0) {
						currentOrder--;
						numField.setText("null");
						nameField.setText("null");
						totalField.setText("null");
						btnDelete.setEnabled(false);
					}
					
					else if(currentOrder > 0) {
						credentialsSet.remove(listOfOrders.get(currentOrder));
						listOfOrders.remove(currentOrder);
						currentOrder--;
						orderNum = listOfOrders.get(currentOrder).getOrderNum();
						username = listOfOrders.get(currentOrder).getUsername();
						total = listOfOrders.get(currentOrder).getTotal();
						numField.setText(orderNum);
						nameField.setText(username);
						totalField.setText(total);
						
						if(currentOrder == 0)
							btnPrevious.setEnabled(false);
						if(listOfOrders.size() == 1) {
							btnNext.setEnabled(false);
						}
					}
					
					else {
						credentialsSet.remove(listOfOrders.get(currentOrder));
						listOfOrders.remove(currentOrder);
						currentOrder++;
						orderNum = listOfOrders.get(currentOrder).getOrderNum();
						username = listOfOrders.get(currentOrder).getUsername();
						total = listOfOrders.get(currentOrder).getTotal();
						numField.setText(orderNum);
						nameField.setText(username);
						totalField.setText(total);
						
						if(listOfOrders.size() == 1) {
							btnNext.setEnabled(false);
						}
					}
					titleLabel.setText("Credentials: " + (currentOrder + 1) + "/" + listOfOrders.size());
				}
			}
		});
		
		detailFrame.add(titleLabel);
		
		detailFrame.add(btnPrevious);
		btnPrevious.setBounds(10, 310, 110, 30);
		
		detailFrame.add(btnNext);
		btnNext.setBounds(140, 310, 110, 30);
		
		detailFrame.add(btnUpdate);
		btnUpdate.setBounds(10, 350, 110, 30);
		
		detailFrame.add(btnDelete);
		btnDelete.setBounds(140, 350, 110, 30);
		
		detailFrame.add(btnQuit);
		btnQuit.setBounds(270, 310, 110, 70);
		
		numField.setEditable(true);
		nameField.setEditable(true);
		totalField.setEditable(true);
		detailFrame.add(numField);
		detailFrame.add(nameField);
		detailFrame.add(totalField);
		
		detailFrame.add(numLabel);
		detailFrame.add(nameLabel);
		detailFrame.add(totalLabel);
		
		if(currentOrder == listOfOrders.size() - 1) 
			btnNext.setEnabled(false);
		if(currentOrder == 0)
			btnPrevious.setEnabled(false);
		
		detailFrame.setLayout(null);
		detailFrame.setSize(405,430);
		detailFrame.getContentPane().setBackground(Color.CYAN);
		detailFrame.setVisible(true);
	}
	
	public ArrayList<Order> returnList(ArrayList<Order> list) {
		return list;
	}
}
