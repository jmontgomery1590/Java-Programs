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

public class CredentialsDetailUI {
	public javax.swing.JFrame detailFrame;
	public javax.swing.JPanel buttonPanel;
	public javax.swing.JLabel typeLabel;
	public javax.swing.JLabel nameLabel;
	public javax.swing.JLabel emailLabel;
	public javax.swing.JLabel titleLabel;
	public javax.swing.JLabel exitLabel;
	public javax.swing.JTextField typeField;
	public javax.swing.JTextField nameField;
	public javax.swing.JTextField emailField;
	public javax.swing.JButton btnNext;
	public javax.swing.JButton btnPrevious;
	public javax.swing.JButton btnUpdate;
	public javax.swing.JButton btnDelete;
	public javax.swing.JButton btnQuit;
	String usertype;
	String username;
	String password;
	String email;
	int currentCredentials = 0;
	
	public CredentialsDetailUI(LinkedHashSet<Credentials> credentialsSet, HashSet<Order> orderSet, int selectedCredentials, int addCredentialsDialog) {
		ArrayList<Credentials> listOfCredentials = new ArrayList<>(credentialsSet);
		currentCredentials = selectedCredentials;
		
		usertype = listOfCredentials.get(currentCredentials).getUserType();
		username = listOfCredentials.get(currentCredentials).getUsername();
		email = listOfCredentials.get(currentCredentials).getEmail();
		
		detailFrame = new JFrame("Credentials List");
		detailFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		titleLabel = new JLabel("Credentials: " + (currentCredentials + 1) + "/" + listOfCredentials.size());
		titleLabel.setBounds(150, 50, 200, 30);
		
		typeField = new JTextField(usertype);
		typeLabel = new JLabel("User type: ");
		typeField.setBounds(90, 100, 200, 30);
		typeLabel.setBounds(10, 100, 90, 30);
		
		nameField = new JTextField(username);
		nameLabel = new JLabel("Username: ");
		nameField.setBounds(90, 150, 200, 30);
		nameLabel.setBounds(10, 150, 90, 30);
		
		emailField = new JTextField(email);
		emailLabel = new JLabel("Email: ");
		emailField.setBounds(90, 200, 200, 30);
		emailLabel.setBounds(10, 200, 90, 30);
		
		btnNext = new JButton ("Next");
		btnNext.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				currentCredentials++;
				usertype = listOfCredentials.get(currentCredentials).getUserType();
				username = listOfCredentials.get(currentCredentials).getUsername();
				email = listOfCredentials.get(currentCredentials).getEmail();
				typeField.setText(usertype);
				nameField.setText(username);
				emailField.setText(email);
				
				btnPrevious.setEnabled(true);
				if(currentCredentials == listOfCredentials.size() - 1)
					btnNext.setEnabled(false);
				
				titleLabel.setText("Credentials: " + (currentCredentials + 1) + "/" + listOfCredentials.size());
			}
		});
		
		btnPrevious = new JButton ("Previous");
		btnPrevious.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				currentCredentials--;
				usertype = listOfCredentials.get(currentCredentials).getUserType();
				username = listOfCredentials.get(currentCredentials).getUsername();
				email = listOfCredentials.get(currentCredentials).getEmail();
				typeField.setText(usertype);
				nameField.setText(username);
				emailField.setText(email);
				
				btnNext.setEnabled(true);
				if(currentCredentials == 0)
					btnPrevious.setEnabled(false);
				
				titleLabel.setText("Credentials: " + (currentCredentials + 1) + "/" + listOfCredentials.size());
			}
		});
		
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				usertype = JOptionPane.showInputDialog(detailFrame, "Change Usertype" + "\nLeave Blank to Leave Unchanged");
				username = JOptionPane.showInputDialog(detailFrame, "Change Username" + "\nLeave Blank to Leave Unchanged");
				email = JOptionPane.showInputDialog(detailFrame, "Change Email" + "\nLeave Blank to Leave Unchanged");
				
				if(usertype == null || username == null || email == null) 
					JOptionPane.showMessageDialog(detailFrame, "Cancelled", "Error", JOptionPane.ERROR_MESSAGE);
				else {
					if(!usertype.isEmpty()) {
						listOfCredentials.get(currentCredentials).setUserType(usertype);
						typeField.setText(usertype);
					}
					if(!username.isEmpty()) {
						listOfCredentials.get(currentCredentials).setUsername(username);
						nameField.setText(username);
					}
					if(!email.isEmpty()) {
						listOfCredentials.get(currentCredentials).setEmail(email);
						emailField.setText(email);
					}
				}
				titleLabel.setText("Credentials: " + (currentCredentials + 1) + "/" + listOfCredentials.size());
			}
		});
		
		btnQuit = new JButton("Back");
		btnQuit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CredentialsListUI listUI = new CredentialsListUI(credentialsSet, orderSet);
				detailFrame.setVisible(false);
			}
		});
		
		if(addCredentialsDialog == 1) {
			usertype = JOptionPane.showInputDialog(detailFrame, "New User Type");
			username = JOptionPane.showInputDialog(detailFrame, "New Username");
			email = JOptionPane.showInputDialog(detailFrame, "New Email");
			
			if(usertype == null || username == null || email == null) {
				JOptionPane.showMessageDialog(detailFrame, "Cancelled", "Error", JOptionPane.ERROR_MESSAGE);
			}
			else if(!usertype.isEmpty() && !username.isEmpty() && !email.isEmpty()) {
				Credentials credentials = new Credentials(usertype, username, password, email);
				listOfCredentials.add(credentials);
				credentialsSet.add(credentials);
				typeField.setText(usertype);
				nameField.setText(username);
				emailField.setText(email);
				currentCredentials = listOfCredentials.size() - 1;
			
			
				if(listOfCredentials.size() == 1) {
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
				if(usertype.isEmpty()) 
					error.append("User Type");
				if(username.isEmpty())
					error.append("Username");
				if(email.isEmpty())
					error.append("Email");
			
				JOptionPane.showMessageDialog(detailFrame, "Fields Left Blank: " + error, "Error", JOptionPane.WARNING_MESSAGE);
			}
			titleLabel.setText("Credentials: " + (currentCredentials + 1) + "/" + listOfCredentials.size());
		}
	
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int choice = JOptionPane.showConfirmDialog(detailFrame, "Are you sure you want to delete this credential?", "Confirm delete", JOptionPane.YES_NO_OPTION);
				if(choice == 0) {
					if(listOfCredentials.size() == 0 && choice == 0) {
						currentCredentials--;
						typeField.setText("null");
						nameField.setText("null");
						emailField.setText("null");
						btnDelete.setEnabled(false);
					}
					
					else if(currentCredentials > 0) {
						credentialsSet.remove(listOfCredentials.get(currentCredentials));
						listOfCredentials.remove(currentCredentials);
						currentCredentials--;
						usertype = listOfCredentials.get(currentCredentials).getUserType();
						username = listOfCredentials.get(currentCredentials).getUsername();
						email = listOfCredentials.get(currentCredentials).getEmail();
						typeField.setText(usertype);
						nameField.setText(username);
						emailField.setText(email);
						
						if(currentCredentials == 0)
							btnPrevious.setEnabled(false);
						if(listOfCredentials.size() == 1) {
							btnNext.setEnabled(false);
						}
					}
					
					else {
						credentialsSet.remove(listOfCredentials.get(currentCredentials));
						listOfCredentials.remove(currentCredentials);
						currentCredentials++;
						usertype = listOfCredentials.get(currentCredentials).getUserType();
						username = listOfCredentials.get(currentCredentials).getUsername();
						email = listOfCredentials.get(currentCredentials).getEmail();
						typeField.setText(usertype);
						nameField.setText(username);
						emailField.setText(email);
						
						if(listOfCredentials.size() == 1) {
							btnNext.setEnabled(false);
						}
					}
					titleLabel.setText("Credentials: " + (currentCredentials + 1) + "/" + listOfCredentials.size());
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
		
		typeField.setEditable(true);
		nameField.setEditable(true);
		emailField.setEditable(true);
		detailFrame.add(typeField);
		detailFrame.add(nameField);
		detailFrame.add(emailField);
		
		detailFrame.add(typeLabel);
		detailFrame.add(nameLabel);
		detailFrame.add(emailLabel);
		
		if(currentCredentials == listOfCredentials.size() - 1) 
			btnNext.setEnabled(false);
		if(currentCredentials == 0)
			btnPrevious.setEnabled(false);
		
		detailFrame.setLayout(null);
		detailFrame.setSize(405,430);
		detailFrame.getContentPane().setBackground(Color.RED);
		detailFrame.setVisible(true);
	}
	
	public ArrayList<Credentials> returnList(ArrayList<Credentials> list) {
		return list;
	}
}
