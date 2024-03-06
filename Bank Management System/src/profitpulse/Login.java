package profitpulse;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
	
	JTextField cardTextField;
	JPasswordField pinTextField;  // to hide sensitive content 
	JButton login, clear, signup;

    // User Interface
    Login() {
        setTitle("ProfitPulse");
        setLayout(null); // in order to allow the custom layout to work (our setBounds function)

        // Logo Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT); // to scale logo image
        ImageIcon i3 = new ImageIcon(i2); // change image back to image icon
        JLabel label = new JLabel(i3);
        label.setBounds(70, 10, 100, 100);
        add(label); // to place component on the frame

        // Welcome
        JLabel text = new JLabel("Welcome to ProfitPulse");
        text.setFont(new Font("Osward", Font.BOLD, 35));
        text.setBounds(200, 40, 450, 40); // have to define location specifically since setLayout is null
        add(text);

        // Panel for green background 
        JPanel loginPanel = new JPanel();
        loginPanel.setBackground(new Color(0, 204, 102));
        loginPanel.setBounds(0, 110, 750, 150); // Adjusted height to accommodate the button
        loginPanel.setLayout(null);
        add(loginPanel);

        // Card Number
        JLabel cardno = new JLabel("Card No:");
        cardno.setFont(new Font("Raleway", Font.BOLD, 28));
        cardno.setForeground(Color.WHITE);
        cardno.setBounds(170, 20, 150, 30); // left/right, down/up
        loginPanel.add(cardno);

        cardTextField = new JTextField();
        cardTextField.setBounds(310, 20, 250, 30);
        loginPanel.add(cardTextField);

        // PIN
        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD, 28));
        pin.setForeground(Color.WHITE);
        pin.setBounds(170, 90, 250, 30);
        loginPanel.add(pin);

        pinTextField = new JPasswordField();
        pinTextField.setBounds(310, 90, 250, 30);
        loginPanel.add(pinTextField);
        
        // Login Button
        login = new JButton("SIGN IN");
        login.setBounds(300, 280, 100, 30);
        login.addActionListener(this); // Action Listener allows for implementation of buttons  
        add(login); // Add the button directly to the frame, not the loginPanel
        
        // Clear Button
        clear = new JButton("CLEAR");
        clear.setBounds(430, 280, 100, 30); 
        clear.addActionListener(this);
        add(clear); 
         
        // Sign Up Button
        signup = new JButton("SIGN UP");
        signup.setBounds(300, 320, 230, 30); 
        signup.addActionListener(this);
        add(signup); 

        getContentPane().setBackground(Color.WHITE);

        setSize(750, 480);
        setVisible(true);
        setLocationRelativeTo(null); // Center the frame on the screen
    }
    
    @Override
	public void actionPerformed(ActionEvent ae) {
    	// Defines what happens after the buttons is clicked
		if(ae.getSource() == clear) {
			cardTextField.setText("");
			pinTextField.setText("");
		} 
		else if (ae.getSource() == login) {
			Connection c = new Connection();
			String cardNumber = cardTextField.getText();
			String pinNumber = pinTextField.getText();
			// To find a match in the database
			String query = "SELECT * FROM login WHERE cardNumber = '"+cardNumber+"' and pinNumber = '"+pinNumber+"' ";
			try {
				// Storing data retrieved
				ResultSet rs = c.s.executeQuery(query);
				// If successful login
				if (rs.next()) {
					setVisible(false);
					new Transactions(pinNumber).setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN.");
				}
			}
			catch (Exception e) {
				System.out.println(e);
			} 
		}
		else if (ae.getSource() == signup) {
			setVisible(false);
			new SignupOne().setVisible(true);
		}
	} 

    public static void main(String[] args) {
        new Login();
    }

}
