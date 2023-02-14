package catalogdatabase_mvc.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.LinkedHashSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import catalogdatabase_mvc.controller.CredentialsController;
import catalogdatabase_mvc.controller.OrderController;
import catalogdatabase_mvc.model.Credentials;
import catalogdatabase_mvc.model.Order;

public class HomepageUI {
	
	public javax.swing.JFrame homeFrame;
	public javax.swing.JButton viewCredentials;
	public javax.swing.JButton viewOrders;
	public javax.swing.JPanel buttonPanel;
	public javax.swing.JLabel appName;
    
	public HomepageUI (LinkedHashSet<Credentials> credentialsList, HashSet<Order> orderSet) {
		homeFrame = new JFrame("Home");
		homeFrame.getContentPane().setBackground(Color.BLACK);
		homeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		appName = new JLabel("Store Database", SwingConstants.CENTER);
		appName.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		appName.setForeground(Color.WHITE);
		
		viewCredentials = new JButton("View Credentials");
		viewOrders = new JButton("View Orders");
		
		viewCredentials.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent E) {
				CredentialsController credentialsCntl = new CredentialsController();
				credentialsCntl.getCredentialsListUI(credentialsList, orderSet);
				homeFrame.setVisible(false);
			}
		});
		
		viewOrders.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent E) {
				OrderController orderCntl = new OrderController();
				orderCntl.getOrderListUI(credentialsList, orderSet);
				homeFrame.setVisible(false);
			}
		});
		
		buttonPanel = new JPanel(new GridLayout(1,4));
		buttonPanel.add(viewCredentials);
		buttonPanel.add(viewOrders);
		
		homeFrame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
		homeFrame.getContentPane().add(appName, BorderLayout.NORTH);
		homeFrame.setSize(450, 300);
		homeFrame.setVisible(true);
	}
}
