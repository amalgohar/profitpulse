package profitpulse;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class BalanceInquiry extends JFrame implements ActionListener {

	JButton back;
	String pinNumber;

	BalanceInquiry(String pinNumber) {
		setTitle("Balance Inquiry");
		this.pinNumber = pinNumber;
		setLayout(null);
		
		// ATM Image
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 900, 900);
		add(image);
		
		// Heading
		JLabel text = new JLabel("Your current Account Balance is:");
		text.setBounds(190, 300, 400, 35);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("Raleway", Font.BOLD, 16));
		image.add(text);
		
		// To Retrieve Balance from Database
		Connection c = new Connection();
		int balance = 0;
		try {
			ResultSet rs = c.s.executeQuery("SELECT * FROM bank WHERE pinNumber = '" + pinNumber + "'");

			while (rs.next()) {
				if (rs.getString("type").equals("Deposit")) {
					// Compute total balance
					// Adding deposits
					balance += Integer.parseInt(rs.getString("amount"));
				} else {
					// Subtracting withdrawals
					balance -= Integer.parseInt(rs.getString("amount"));
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		// Balance Amount Displayed
		JLabel amount = new JLabel("$" + balance);
		amount.setBounds(190, 330, 400, 35);
		amount.setForeground(Color.WHITE);
		amount.setFont(new Font("Raleway", Font.BOLD, 16));
		image.add(amount);
		
		// Back Button
		back = new JButton("Back");
		back.setBounds(355, 485, 150, 35);
		back.addActionListener(this);
		image.add(back);
		
		getContentPane().setBackground(Color.WHITE);
		setSize(900, 900);
		setLocation(300, 0);
		setVisible(true);
	}

	public static void main(String[] args) {
		new BalanceInquiry("");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		setVisible(false);
		new Transactions(pinNumber).setVisible(true);

	}

}
