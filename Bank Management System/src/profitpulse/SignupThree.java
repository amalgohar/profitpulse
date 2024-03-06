package profitpulse;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class SignupThree extends JFrame implements ActionListener {
	
	JRadioButton checkingAccount, savingsAccount, codAccount;
	JCheckBox ATM, onlineBanking, mobileBanking, alerts, checkBook, eStatement;
	JButton submit, cancel;
	String formNo;
	
	SignupThree(String formNo) {
		this.formNo = formNo;
		setLayout(null);
		
	    // Title
	    setTitle("New Account Application Form - Page 3");
	    
	    // Account Details
		JLabel accountDetails = new JLabel("Page 3: Account Details");
		accountDetails.setFont(new Font("Raleway", Font.BOLD, 22));
		accountDetails.setBounds(290, 60, 400, 40);
		add(accountDetails);
		
		// Account Type 
		JLabel type = new JLabel("Account Type:");
		type.setFont(new Font("Raleway", Font.BOLD, 22));
		type.setBounds(100, 110, 300, 30);
		add(type);
		
		// Radio Buttons for Account Type
		// Checking Account
		checkingAccount = new JRadioButton("Checking Account"); // AKA Current Account
		checkingAccount.setFont(new Font("Raleway", Font.BOLD, 16));
		checkingAccount.setBackground(Color.WHITE);
		checkingAccount.setBounds(100, 150, 200, 20);
		add(checkingAccount);
		
		// Savings Account
		savingsAccount = new JRadioButton("Savings Account"); 
		savingsAccount.setFont(new Font("Raleway", Font.BOLD, 16));
		savingsAccount.setBackground(Color.WHITE);
		savingsAccount.setBounds(100, 190, 200, 20);
		add(savingsAccount);

		// COD Account
		codAccount = new JRadioButton("Certificate of Deposit Account"); // AKA Fixed Deposit Account
		codAccount.setFont(new Font("Raleway", Font.BOLD, 16));
		codAccount.setBackground(Color.WHITE);
		codAccount.setBounds(100, 230, 280, 20);
		add(codAccount); 
		
		ButtonGroup groupAccount = new ButtonGroup();
		groupAccount.add(checkingAccount);
		groupAccount.add(savingsAccount);
		groupAccount.add(codAccount );
		
		// Card Number
		JLabel card = new JLabel("Card Number:");
		card.setFont(new Font("Raleway", Font.BOLD, 22));
		card.setBounds(100, 270, 200, 30);
		add(card);
		
		// Number Example
		JLabel number = new JLabel("3050-84XX-XXXX-XXXX");
		number.setFont(new Font("Raleway", Font.BOLD, 22));
		number.setBounds(330, 270, 300, 30);
		add(number);
		
		// Card Number Details 
		JLabel cardDetail = new JLabel("Your 16 Digit Card Number");
		cardDetail.setFont(new Font("Raleway", Font.BOLD, 14));
		cardDetail.setBounds(100, 300, 300, 30);
		add(cardDetail);
		
		// PIN
		JLabel pin = new JLabel("PIN:");
		pin.setFont(new Font("Raleway", Font.BOLD, 22));
		pin.setBounds(100, 340, 200, 30);
		add(pin);
		
		// PIN Number Example
		JLabel pnumber = new JLabel("XXXX");
		pnumber.setFont(new Font("Raleway", Font.BOLD, 22));
		pnumber.setBounds(330, 340, 300, 30);
		add(pnumber);
		
		// PIN Details 
		JLabel pinDetails = new JLabel("Your 4 Digit PIN");
		pinDetails.setFont(new Font("Raleway", Font.BOLD, 14));
		pinDetails.setBounds(100, 370, 300, 30);
		add(pinDetails);
		
		// Services Required 
		JLabel services = new JLabel("Services Required:");
		services.setFont(new Font("Raleway", Font.BOLD, 22));
		services.setBounds(100, 420, 250, 30);
		add(services);
		
		// ATM Card
		ATM = new JCheckBox("ATM Card");
		ATM.setBackground(Color.WHITE);
		ATM.setFont(new Font("Raleway", Font.BOLD, 16));
		ATM.setBounds(100, 470, 200, 30);
		add(ATM);
		
		// Online Banking
		onlineBanking = new JCheckBox("Online Banking");
		onlineBanking.setBackground(Color.WHITE);
		onlineBanking.setFont(new Font("Raleway", Font.BOLD, 16));
		onlineBanking.setBounds(350, 470, 200, 30);
		add(onlineBanking);
		
		// Mobile Banking
		mobileBanking = new JCheckBox("Mobile Banking");
		mobileBanking.setBackground(Color.WHITE);
		mobileBanking.setFont(new Font("Raleway", Font.BOLD, 16));
		mobileBanking.setBounds(100, 520, 200, 30);
		add(mobileBanking);
		
		// Email & SMS Alerts
		alerts = new JCheckBox("Email & SMS Alerts:");
		alerts.setBackground(Color.WHITE);
		alerts.setFont(new Font("Raleway", Font.BOLD, 16));
		alerts.setBounds(350, 520, 200, 30);
		add(alerts);
		
		// Check Book 
		checkBook = new JCheckBox("Check Book");
		checkBook.setBackground(Color.WHITE);
		checkBook.setFont(new Font("Raleway", Font.BOLD, 16));
		checkBook.setBounds(100, 570, 200, 30);
		add(checkBook);
		
		// E-Statement
		eStatement = new JCheckBox("E-Statement");
		eStatement.setBackground(Color.WHITE);
		eStatement.setFont(new Font("Raleway", Font.BOLD, 16));
		eStatement.setBounds(350, 570, 200, 30);
		add(eStatement);
		
		// Submit Button
		submit = new JButton("SUBMIT");
		submit.setFont(new Font("Raleway", Font.BOLD, 14));
		submit.setBounds(620, 600, 90, 30);
		submit.addActionListener(this);
		add(submit);
		
		// Cancel Button
		cancel = new JButton("CANCEL");
		cancel.setBackground(Color.BLACK);
		cancel.setFont(new Font("Raleway", Font.BOLD, 14));
		cancel.setBounds(710, 600, 90, 30);
		cancel.addActionListener(this);
		add(cancel);
		
		getContentPane().setBackground(Color.WHITE);
		setSize(850, 700);
		setLocation(350, 50);
		setVisible(true);
	}

	public static void main(String[] args) {
		new SignupThree("");

	}

	// Assigning values that user enters
	@Override
	public void actionPerformed(ActionEvent ae) {
		// Account Type Assigning
		if (ae.getSource() == submit) {
			String accountType = null;
			if(checkingAccount.isSelected()) {
				accountType = "Checking Account";
			}
			else if(savingsAccount.isSelected()) {
				accountType = "Savings Account";
			}
			else if(codAccount.isSelected()) {
				accountType = "Certificate of Deposit Account";
			}
			
			// Calculating Random Card Number and PIN
			Random random = new Random();
			String cardNumber = "" + Math.abs((random.nextLong() % 90000000L) + 3050845000000000L);
			
			String pinNumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L);
			
			// Services Selection
			String services = "";
			if(ATM.isSelected()) {
				services += " ATM Card";
			}
			else if(onlineBanking.isSelected()) {
				services += " Online Banking";
			}
			else if(mobileBanking.isSelected()) {
				services += " Mobile Banking";
			}
			else if(alerts.isSelected()) {
				services += " Email & SMS Alerts";
			}
			else if(checkBook.isSelected()) {
				services += " Check Book";
			}
			else if(eStatement.isSelected()) {
				services += " E-Statement";
			}
			
			// Validation
			try {
				if (accountType.equals("")) {
					JOptionPane.showMessageDialog(null, "Account Type is required.");
				}
				else {
					Connection c = new Connection();
					String query1 = "INSERT INTO signupthree VALUES('"+formNo+"', '"+accountType+"', '"+cardNumber+"', '"+pinNumber+"', '"+services+"')";
					String query2 = "INSERT INTO login VALUES('"+formNo+"', '"+cardNumber+"', '"+pinNumber+"')";
					c.s.executeUpdate(query1);
					c.s.executeUpdate(query2);
					
					JOptionPane.showMessageDialog(null, "Card Number: " + cardNumber + "\nPIN: " + pinNumber);
				}
				// Must deposit some amount in order to open an account
				setVisible(false);
				new Deposit(pinNumber).setVisible(false);
			} 
			catch (Exception e) {
				System.out.println(e);
			}
		}
		else if(ae.getSource() == cancel) {
			setVisible(false);
			new Login().setVisible(true);
		}
	}

}
