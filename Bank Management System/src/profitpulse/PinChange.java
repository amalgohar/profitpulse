package profitpulse;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PinChange extends JFrame implements ActionListener {

	JPasswordField newPin, reEnterPin;
	JButton change, back;
	String pinNumber;

	PinChange(String pinNumber) {
		setTitle("Pin Change");
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
		JLabel text = new JLabel("Change your PIN:");
		text.setBounds(260, 300, 500, 35);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("Raleway", Font.BOLD, 16));
		image.add(text);

		// New Pin
		JLabel pinText = new JLabel("New PIN:");
		pinText.setBounds(165, 340, 180, 25);
		pinText.setForeground(Color.WHITE);
		pinText.setFont(new Font("Raleway", Font.BOLD, 16));
		image.add(pinText);

		// New Pin Text Field
		newPin = new JPasswordField();
		newPin.setBounds(330, 340, 180, 25);
		image.add(newPin);

		// Re-enter New Pin
		JLabel reEnter = new JLabel("Re-Enter New PIN:");
		reEnter.setBounds(165, 380, 180, 25);
		reEnter.setForeground(Color.WHITE);
		reEnter.setFont(new Font("Raleway", Font.BOLD, 16));
		image.add(reEnter);

		// Re-enter New Pin Text Field
		reEnterPin = new JPasswordField();
		reEnterPin.setBounds(330, 380, 180, 25);
		image.add(reEnterPin);

		// Change Button
		change = new JButton("Change");
		change.setBounds(355, 485, 150, 35);
		change.addActionListener(this);
		image.add(change);

		// Back Button
		back = new JButton("Back");
		back.setBounds(355, 520, 150, 35);
		back.addActionListener(this);
		image.add(back);

		getContentPane().setBackground(Color.WHITE);
		setSize(900, 900);
		setLocation(300, 0);
		setVisible(true);
	}

	public static void main(String[] args) {
		new PinChange("").setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == change) {
			try {
				String nPin = newPin.getText();
				String rPin = reEnterPin.getText();

				if (!nPin.equals(rPin)) {
					JOptionPane.showMessageDialog(null, "Entered PIN does not match.");
					return;
				}
				
				// Validation: If nothing is entered
				if(nPin.equals("")) {
					JOptionPane.showMessageDialog(null, "Please enter a new PIN.");
					return;
				}
				if(rPin.equals("")) {
					JOptionPane.showMessageDialog(null, "Please re-enter new PIN.");
					return;
				}
				
				// Update and change new pin in all previously existing tables 
				Connection c = new Connection();
				String query1 = "UPDATE bank SET pinNumber = '"+rPin+"' WHERE pinNumber = '"+pinNumber+"'";
				String query2 = "UPDATE login SET pinNumber = '"+rPin+"' WHERE pinNumber = '"+pinNumber+"'";
				String query3 = "UPDATE signupthree SET pinNumber = '"+rPin+"' WHERE pinNumber = '"+pinNumber+"'";
			
				c.s.executeUpdate(query1);
				c.s.executeUpdate(query2);
				c.s.executeUpdate(query3);
				
				JOptionPane.showMessageDialog(null, "PIN changed successfully.");
				
				setVisible(false);
				new Transactions(rPin).setVisible(true);
			} catch (Exception e) {
				System.out.println(e);
			}
		} else {
			setVisible(false);
			new Transactions(pinNumber).setVisible(true);
		}

	}
}
