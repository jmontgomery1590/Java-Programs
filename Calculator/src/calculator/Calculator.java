package calculator;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Calculator extends JFrame implements ActionListener {
	static JFrame frame;
	static JTextField textField;
	String str0, str1, str2;
	
	Calculator() {
		str0 = str1 = str2 = "";
	}
	
	public static void main(String[] args) {
		frame = new JFrame("Calculator");
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		Calculator calc = new Calculator();
		textField = new JTextField(16);
		Dimension dimT = new Dimension(500, 60);
		textField.setPreferredSize(dimT);
		textField.setEditable(false);
		textField.setFont(new Font("Arial", Font.PLAIN, 30));
		
		JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, ba, bs, bm, bd, beq, bp, bc;
		
		b0 = new JButton("0");
		b1 = new JButton("1");
		b2 = new JButton("2");
		b3 = new JButton("3");
		b4 = new JButton("4");
		b5 = new JButton("5");
		b6 = new JButton("6");
		b7 = new JButton("7");
		b8 = new JButton("8");
		b9 = new JButton("9");
		ba = new JButton("+");
		bs = new JButton("-");
		bm = new JButton("*");
		bd = new JButton("/");
		beq = new JButton("=");
		bp = new JButton(".");
		bc = new JButton("C");
		
		JPanel panel = new JPanel();
		
		b0.addActionListener(calc);
		b1.addActionListener(calc);
		b2.addActionListener(calc);
		b3.addActionListener(calc);
		b4.addActionListener(calc);
		b5.addActionListener(calc);
		b6.addActionListener(calc);
		b7.addActionListener(calc);
		b8.addActionListener(calc);
		b9.addActionListener(calc);
		ba.addActionListener(calc);
		bs.addActionListener(calc);
		bm.addActionListener(calc);
		bd.addActionListener(calc);
		beq.addActionListener(calc);
		bp.addActionListener(calc);
		bc.addActionListener(calc);
		
		panel.add(textField);
		panel.add(b7);
		panel.add(b8);
		panel.add(b9);
		panel.add(bd);
		panel.add(b4);
		panel.add(b5);
		panel.add(b6);
		panel.add(bm);
		panel.add(b1);
		panel.add(b2);
		panel.add(b3);
		panel.add(bs);
		panel.add(bc);
		panel.add(b0);
		panel.add(bp);
		panel.add(ba);
		panel.add(beq);
		
		Dimension dim1 = new Dimension(100, 60);
		b0.setPreferredSize(dim1);
		b1.setPreferredSize(dim1);
		b2.setPreferredSize(dim1);
		b3.setPreferredSize(dim1);
		b4.setPreferredSize(dim1);
		b5.setPreferredSize(dim1);
		b6.setPreferredSize(dim1);
		b7.setPreferredSize(dim1);
		b8.setPreferredSize(dim1);
		b9.setPreferredSize(dim1);
		ba.setPreferredSize(dim1);
		bs.setPreferredSize(dim1);
		bm.setPreferredSize(dim1);
		bd.setPreferredSize(dim1);
		bp.setPreferredSize(dim1);
		bc.setPreferredSize(dim1);
		
		Dimension dim2 = new Dimension(150, 60);
		beq.setPreferredSize(dim2);
		
		b0.setFont(new Font("Arial", Font.PLAIN, 24));
		b1.setFont(new Font("Arial", Font.PLAIN, 24));
		b2.setFont(new Font("Arial", Font.PLAIN, 24));
		b3.setFont(new Font("Arial", Font.PLAIN, 24));
		b4.setFont(new Font("Arial", Font.PLAIN, 24));
		b5.setFont(new Font("Arial", Font.PLAIN, 24));
		b6.setFont(new Font("Arial", Font.PLAIN, 24));
		b7.setFont(new Font("Arial", Font.PLAIN, 24));
		b8.setFont(new Font("Arial", Font.PLAIN, 24));
		b9.setFont(new Font("Arial", Font.PLAIN, 24));
		ba.setFont(new Font("Arial", Font.PLAIN, 24));
		bs.setFont(new Font("Arial", Font.PLAIN, 24));
		bd.setFont(new Font("Arial", Font.PLAIN, 24));
		bp.setFont(new Font("Arial", Font.PLAIN, 24));
		bc.setFont(new Font("Arial", Font.PLAIN, 24));
		beq.setFont(new Font("Arial", Font.PLAIN, 24));
		
		panel.setBackground(Color.RED);
		
		frame.add(panel);
		frame.setSize(450, 475);
		frame.setResizable(true);
		frame.show();
	}
	
	public void actionPerformed(ActionEvent ae) {
		String str = ae.getActionCommand();
		
		if((str.charAt(0) >= '0' && str.charAt(0) <= '9') || str.charAt(0) == '.') {
			if (!str1.equals(""))
				str2 += str;
			else
				str0 += str;
			textField.setText(str0 + str1 + str2);
			
		} else if (str.charAt(0) == 'C') {
			str0 = str1 = str2 = "";
			textField.setText(str0 + str1 + str2);
			
		} else if (str.charAt(0) == '=') {
			double te;
			
			if (str1.equals("+"))
				te = (Double.parseDouble(str0) + Double.parseDouble(str2));
			else if (str1.equals("-"))
				te = (Double.parseDouble(str0) - Double.parseDouble(str2));
			else if (str1.equals("/"))
				te = (Double.parseDouble(str0) / Double.parseDouble(str2));
			else
				te = (Double.parseDouble(str0) * Double.parseDouble(str2));
			
			textField.setText(str0 + str1 + str2 + "=" + te);
			str0 = Double.toString(te);
			str1 = str2 = "";
		} 
		else {
			if (str1.equals("") || str2.equals("")) 
				str1 = str;
			else {
				double te;
				
				if (str1.equals("+"))
					te = (Double.parseDouble(str0) + Double.parseDouble(str2));
				else if (str1.equals("-"))
					te = (Double.parseDouble(str0) - Double.parseDouble(str2));
				else if (str1.equals("/"))
					te = (Double.parseDouble(str0) / Double.parseDouble(str2));
				else
					te = (Double.parseDouble(str0) * Double.parseDouble(str2));
				
				str0 = Double.toString(te);
				str1 = str;
				str2 = "";
			}
			
			textField.setText(str0 + str1 + str2);
		}
	}
}
