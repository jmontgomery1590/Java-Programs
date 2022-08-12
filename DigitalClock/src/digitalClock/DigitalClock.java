package digitalClock;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.*;
import java.awt.*;

public class DigitalClock extends JFrame {
	Calendar calendar;
	SimpleDateFormat timeFormat;
	SimpleDateFormat dayFormat;
	SimpleDateFormat dateFormat;
	
	JLabel timeLabel;
	JLabel dayLabel;
	JLabel dateLabel;
	
	String time;
	String day;
	String date;
	
	DigitalClock() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Digital Clock");
		this.setLayout(new FlowLayout());
		this.setSize(400, 250);
		this.setResizable(false);
		
		timeFormat = new SimpleDateFormat("hh:mm:ss a");
		dayFormat = new SimpleDateFormat("EEEE");
		dateFormat = new SimpleDateFormat("MMMMM dd, yyyy");
		
		timeLabel = new JLabel();
		timeLabel.setFont(new Font("Times New Roman", Font.PLAIN, 65));
		timeLabel.setBackground(Color.BLACK);
		timeLabel.setForeground(Color.WHITE);
		timeLabel.setOpaque(true);
		
		dayLabel = new JLabel();
		dayLabel.setFont(new Font("Arial", Font.PLAIN, 40));
		dayLabel.setForeground(Color.RED);
		dayLabel.setOpaque(true);

		dateLabel = new JLabel();
		dateLabel.setFont(new Font("Arial", Font.PLAIN, 30));
		dateLabel.setForeground(Color.BLUE);
		dateLabel.setOpaque(true);
				
		this.add(timeLabel);
		this.add(dayLabel);
		this.add(dateLabel);
		this.setVisible(true);
		
		setTime();
	}
	
	public void setTime() {
		while (true) {
			time = timeFormat.format(Calendar.getInstance().getTime());
			timeLabel.setText(time);
			
			day = dayFormat.format(Calendar.getInstance().getTime());
			dayLabel.setText(day);
			
			date = dateFormat.format(Calendar.getInstance().getTime());
			dateLabel.setText(date);
			
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.getStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		new DigitalClock();
	}
}
