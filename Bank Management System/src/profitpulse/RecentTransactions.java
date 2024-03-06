package profitpulse;

import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class RecentTransactions extends JFrame {

	RecentTransactions(String pinNumber) {
		setTitle("Recent Transactions");
		setLayout(null);

		// Bank Name
		JLabel bank = new JLabel("ProfitPulse");
		bank.setBounds(155, 20, 100, 20);
		bank.setForeground(Color.BLACK);
		bank.setFont(new Font("Raleway", Font.BOLD, 16));
		add(bank);

		// Card
		JLabel card = new JLabel();
		card.setBounds(20, 80, 300, 20);
		card.setForeground(Color.BLACK);
		card.setFont(new Font("Raleway", Font.BOLD, 12));
		add(card);

		// Statement
		JLabel statement = new JLabel();
		statement.setBounds(20, 140, 400, 220);
		statement.setForeground(Color.BLACK);
		statement.setFont(new Font("Raleway", Font.BOLD, 12));
		add(statement);

		// Balance
		JLabel balance = new JLabel();
		balance.setBounds(20, 400, 300, 20);
		balance.setForeground(Color.BLACK);
		balance.setFont(new Font("Raleway", Font.BOLD, 12));
		add(balance);

		// Retrieve Card Number from Login Table
		try {
			Connection c = new Connection();
			ResultSet rs = c.s.executeQuery("SELECT * FROM login WHERE pinNumber = '" + pinNumber + "'");
			while (rs.next()) {
				card.setText("Card Number: " + rs.getString("cardNumber").substring(0, 4) + "-XXXX-XXXX-"
						+ rs.getString("cardNumber").substring(12));
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		// Retrieve Values from Bank Table
		try {
			Connection c = new Connection();
			int bal = 0;
			ResultSet rs = c.s.executeQuery("SELECT * FROM bank WHERE pinNumber = '" + pinNumber + "'");
			while (rs.next()) {
				statement.setText(
						statement.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
								+ rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
								+ rs.getString("amount") + "<br><br><html>");
				if (rs.getString("type").equals("Deposit")) {
					// Compute total balance
					// Adding deposits
					bal += Integer.parseInt(rs.getString("amount"));
				} else {
					// Subtracting withdrawals
					bal -= Integer.parseInt(rs.getString("amount"));
				}
			}
			balance.setText("Your current account balance is $" + bal + ".");
		} catch (Exception e) {
			System.out.println(e);
		}

		getContentPane().setBackground(Color.WHITE);
		setSize(400, 600);
		setLocation(20, 20);
		setVisible(true);
	}

	public static void main(String[] args) {
		new RecentTransactions("");
	}
}
