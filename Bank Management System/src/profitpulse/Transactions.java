package profitpulse;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Transactions extends JFrame implements ActionListener {
	
	JButton deposit, withdrawal, fastCash, recentTransactions, changePIN, balanceInquiry, exit;
	String pinNumber;
	
	Transactions(String pinNumber) {
		this.pinNumber = pinNumber;
		
	    // Title
	    setTitle("ProfitPulse ATM");
		
		// ATM Image
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 900, 900);
		add(image);
		
		// Heading 
		JLabel text = new JLabel("Please select your Transaction:");
		text.setBounds(210, 240, 700, 20);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("Raleway", Font.BOLD, 16));
		image.add(text);
		
		// Deposit Button
		deposit = new JButton("Deposit");
		deposit.setBounds(170, 340, 150, 35);
		deposit.addActionListener(this);
		image.add(deposit);
		
		// Withdrawal Button 
		withdrawal = new JButton("Withdrawal");
		withdrawal.setBounds(350, 340, 150, 35);
		withdrawal.addActionListener(this);
		image.add(withdrawal);
		
		// Fast Cash Button 
		fastCash = new JButton("Fash Cash");
		fastCash.setBounds(170, 375, 150, 35);
		fastCash.addActionListener(this);
		image.add(fastCash);
		
		// Recent Transactions Button 
		recentTransactions = new JButton("Recent Transactions");
		recentTransactions.setBounds(350, 375, 150, 35);
		recentTransactions.addActionListener(this);
		image.add(recentTransactions);
		
		// Change PIN Button 
		changePIN = new JButton("Change PIN");
		changePIN.setBounds(170, 410, 150, 35);
		changePIN.addActionListener(this);
		image.add(changePIN);
		 
		// Balance Inquiry Button 
		balanceInquiry = new JButton("Balance Inquiry");
		balanceInquiry.setBounds(350, 410, 150, 35);
		balanceInquiry.addActionListener(this);
		image.add(balanceInquiry);
		
		// Exit Button 
		exit = new JButton("Exit");
		exit.setBounds(350, 445, 150, 35);
		exit.addActionListener(this);
		image.add(exit);
		
		getContentPane().setBackground(Color.WHITE);
		setSize(900, 900);
		setLocation(300, 0);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Transactions("");

	}

	// Actions after buttons clicked
	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == exit) {
			System.exit(0);
		}
		else if (ae.getSource() == deposit) {
			setVisible(false);
			new Deposit(pinNumber).setVisible(true);
		}
		else if (ae.getSource() == withdrawal) {
			setVisible(false);
			new Withdrawal(pinNumber).setVisible(true);
		}
		else if (ae.getSource() == fastCash) {
			setVisible(false);
			new FastCash(pinNumber).setVisible(true);
		}
		else if (ae.getSource() == changePIN) {
			setVisible(false);
			new PinChange(pinNumber).setVisible(true);
		}
		else if (ae.getSource() == balanceInquiry) {
			setVisible(false);
			new BalanceInquiry(pinNumber).setVisible(true);
		}
		else if (ae.getSource() == recentTransactions) {
			new RecentTransactions(pinNumber).setVisible(true);
		}
	}

}
