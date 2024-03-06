package profitpulse;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {
	
	JButton twenty, forty, sixty, eighty, oneHundred, twoHundred, back;
	String pinNumber;
	
	FastCash(String pinNumber) {
		setTitle("Fast Cash"); 
		this.pinNumber = pinNumber;
		
		// ATM Image
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 900, 900);
		add(image);
		
		// Heading 
		JLabel text = new JLabel("Select withdrawal amount:");
		text.setBounds(230, 240, 700, 20);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("Raleway", Font.BOLD, 16));
		image.add(text);
		
		// Deposit Button
		twenty = new JButton("$20");
		twenty.setBounds(170, 340, 150, 35);
		twenty.addActionListener(this);
		image.add(twenty);
		
		// Withdrawal Button 
		forty = new JButton("$40");
		forty.setBounds(170, 375, 150, 35);
		forty.addActionListener(this);
		image.add(forty);
		
		// Fast Cash Button 
		sixty = new JButton("$60");
		sixty.setBounds(170, 410, 150, 35);
		sixty.addActionListener(this);
		image.add(sixty);
		
		// Recent Transactions Button 
		eighty = new JButton("$80");
		eighty.setBounds(350, 340, 150, 35);
		eighty.addActionListener(this);
		image.add(eighty);
		
		// Change PIN Button 
		oneHundred = new JButton("$100");
		oneHundred.setBounds(350, 375, 150, 35);
		oneHundred.addActionListener(this);
		image.add(oneHundred);
		 
		// Balance Inquiry Button 
		twoHundred = new JButton("$200");
		twoHundred.setBounds(350, 410, 150, 35);
		twoHundred.addActionListener(this);
		image.add(twoHundred);
		
		// Exit Button 
		back = new JButton("Back");
		back.setBounds(350, 445, 150, 35);
		back.addActionListener(this);
		image.add(back);
		
		getContentPane().setBackground(Color.WHITE);
		setSize(900, 900);
		setLocation(300, 0);
		setVisible(true);
	}

	public static void main(String[] args) {
		new FastCash("");

	}

	// Actions after buttons clicked
	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == back) {
			setVisible(false);
			new Transactions(pinNumber).setVisible(true);
		}
		else {
			String amount = ((JButton)ae.getSource()).getText().substring(1);
			Connection c = new Connection();
			try {
				ResultSet rs = c.s.executeQuery("SELECT * FROM bank WHERE pinNumber = '"+pinNumber+"'");
				int balance = 0;
				while (rs.next()) {
					if(rs.getString("type").equals("Deposit")) {
						// Compute total balance
						// Adding deposits
						balance += Integer.parseInt(rs.getString("amount"));
					}
					else {
						// Subtracting withdrawals
						balance -= Integer.parseInt(rs.getString("amount"));
					}
				}
				// Validation: Checks if there is enough money in bank
				if (ae.getSource() != back && balance < Integer.parseInt(amount)) {
					JOptionPane.showMessageDialog(null, "Insufficient Balance.");
					return;
				}
				
				Date date = new Date();
				String query = "INSERT INTO bank VALUES('"+pinNumber+"', '"+date+"', 'Withdrawal', '"+amount+"')";
				c.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "$" + amount + " Debited Successfully");
				
				setVisible(false);
				new Transactions(pinNumber).setVisible(true);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

}
