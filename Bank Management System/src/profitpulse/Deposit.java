package profitpulse;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.*;

import javax.swing.*;

public class Deposit extends JFrame implements ActionListener {
	
	JTextField amount;
	JButton deposit, back;
	String pinNumber;
	
	Deposit(String pinNumber) {
		setTitle("Deposit");
		setLayout(null);
		this.pinNumber = pinNumber;
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 900, 900);
		add(image);
		
		// Heading
		JLabel text = new JLabel("Enter the amount you want to deposit: ");
		text.setBounds(180, 300, 400, 20);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("Raleway", Font.BOLD, 16));
		image.add(text);
		
		JLabel dollars = new JLabel("$");
		dollars.setBounds(170, 350, 400, 20);
		dollars.setForeground(Color.WHITE);
		dollars.setFont(new Font("Raleway", Font.BOLD, 16));
		image.add(dollars);
		
		// Amount Text Field
		amount = new JTextField();
		amount.setFont(new Font("Raleway", Font.BOLD, 22));
		amount.setBounds(180, 350, 320, 25);
		image.add(amount);
		
		// Deposit Button
		deposit = new JButton("Deposit");
		deposit.setBounds(355, 485, 150, 35);
		deposit.addActionListener(this);
		image.add(deposit);
		
		// Back Button
		back = new JButton("Back");
		back.setBounds(355, 520, 150, 35);
		back.addActionListener(this);
		image.add(back);
		
		getContentPane().setBackground(Color.WHITE);
		setSize(900, 900);
		setLocation(300, 0);
		setUndecorated(true);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Deposit("");
	}

	// Actions after buttons clicked
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == deposit) {
			String number = amount.getText();
			Date date = new Date();
			if (number.equals("")) {
				JOptionPane.showMessageDialog(null, "Please enter the amount you want to deposit.");
			}
			else {
				try {
					Connection c = new Connection();
					String query = "INSERT INTO bank VALUES ('"+pinNumber+"', '"+date+"', 'Deposit', '"+number+"')";
					c.s.executeUpdate(query);
					JOptionPane.showMessageDialog(null, "$" + number + " Deposited Successfully.");
					setVisible(false);
					new Transactions(pinNumber).setVisible(true);
				} catch (SQLException e) {
					System.out.println(e);
				}
			}
		}
		else if(ae.getSource() == back) {
			setVisible(false);
			new Transactions(pinNumber).setVisible(true);
		}
	}

}
