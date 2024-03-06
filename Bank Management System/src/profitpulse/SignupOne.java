package profitpulse;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignupOne extends JFrame implements ActionListener {
	
	long random;
	JTextField nameTextField, dobTextField, emailTextField, addressTextField, cityTextField, stateTextField, pincodeTextField;
	JButton next;
	JRadioButton male, female, nonbinary, married, unmarried, other;
	JDateChooser dateChooser;
	
	SignupOne() {
	
		setLayout(null);
		
		Random ran = new Random();
	    random = Math.abs((ran.nextLong() % 9000L) + 1000L);
	    
	    // Title
	    setTitle("New Account Application Form - Page 1");
		 
		// Application Form
		JLabel formNo = new JLabel("APPLICATION FORM NO. " + random);
		formNo.setFont(new Font("Raleway", Font.BOLD, 38));
		formNo.setBounds(140, 20, 600, 40);
		add(formNo);
		
		// Personal Details
		JLabel personDetails = new JLabel("Page 1: Personal Details");
		personDetails.setFont(new Font("Raleway", Font.BOLD, 22));
		personDetails.setBounds(290, 80, 400, 30);
		add(personDetails);
		
		// Name
		JLabel name = new JLabel("Name:");
		name.setFont(new Font("Raleway", Font.BOLD, 20));
		name.setBounds(100, 140, 100, 30);
		add(name);	
		
		nameTextField = new JTextField();
		nameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		nameTextField.setBounds(300, 140, 400, 30);
		add(nameTextField);
		
		// DOB
		JLabel dob = new JLabel("Date of Birth:");
		dob.setFont(new Font("Raleway", Font.BOLD, 20));
		dob.setBounds(100, 190, 200, 30);
		add(dob);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(300, 190, 400, 30);
		dateChooser.setForeground(new Color(105, 105, 105));
		add(dateChooser);
		
		// Gender
		JLabel gender = new JLabel("Gender:");
		gender.setFont(new Font("Raleway", Font.BOLD, 20));
		gender.setBounds(100, 240, 200, 30);
		add(gender);
		
		male = new JRadioButton("Male");
		male.setBounds(300, 240, 120, 30);
		male.setBackground(Color.WHITE);
		add(male);
		
		female = new JRadioButton("Female");
		female.setBounds(450, 240, 120, 30);
		female.setBackground(Color.WHITE);
		add(female);
		
		nonbinary = new JRadioButton("Non-Binary");
		nonbinary.setBounds(620, 240, 120, 30);
		nonbinary.setBackground(Color.WHITE);
		add(nonbinary);
		
		ButtonGroup genderGroup = new ButtonGroup(); // only allows for selection of only one button
		genderGroup.add(male);
		genderGroup.add(female);
		genderGroup.add(nonbinary);
		
		// Email
		JLabel email = new JLabel("Email:");
		email.setFont(new Font("Raleway", Font.BOLD, 20));
		email.setBounds(100, 290, 200, 30);
		add(email);
		
		emailTextField = new JTextField();
		emailTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		emailTextField.setBounds(300, 290, 400, 30);
		add(emailTextField);
		
		// Marital Status
		JLabel marital = new JLabel("Marital Status:");
		marital.setFont(new Font("Raleway", Font.BOLD, 20));
		marital.setBounds(100, 340, 200, 30);
		add(marital);
		
		married = new JRadioButton("Married");
		married.setBounds(300, 340, 120, 30);
		married.setBackground(Color.WHITE);
		add(married);
		
		unmarried = new JRadioButton("Unmarried");
		unmarried.setBounds(450, 340, 120, 30);
		unmarried.setBackground(Color.WHITE);
		add(unmarried);
		
		other = new JRadioButton("Other");
		other.setBounds(620, 340, 120, 30);
		other.setBackground(Color.WHITE);
		add(other);
	
		ButtonGroup maritalGroup = new ButtonGroup(); 
		maritalGroup.add(married);
		maritalGroup.add(unmarried);
		maritalGroup.add(other);

		// Address
		JLabel address = new JLabel("Address:");
		address.setFont(new Font("Raleway", Font.BOLD, 20));
		address.setBounds(100, 390, 200, 30);
		add(address);
		
		addressTextField = new JTextField();
		addressTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		addressTextField.setBounds(300, 390, 400, 30);
		add(addressTextField);
		
		// City
		JLabel city = new JLabel("City:");
		city.setFont(new Font("Raleway", Font.BOLD, 20));
		city.setBounds(100, 440, 200, 30);
		add(city);
		
		cityTextField = new JTextField();
		cityTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		cityTextField.setBounds(300, 440, 400, 30);
		add(cityTextField);
		
		// State
		JLabel state = new JLabel("State:");
		state.setFont(new Font("Raleway", Font.BOLD, 20));
		state.setBounds(100, 490, 200, 30);
		add(state);
		
		stateTextField = new JTextField();
		stateTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		stateTextField.setBounds(300, 490, 400, 30);
		add(stateTextField);
		
		// PinCode
		JLabel pincode = new JLabel("Pincode:");
		pincode.setFont(new Font("Raleway", Font.BOLD, 20));
		pincode.setBounds(100, 540, 200, 30);
		add(pincode);
		
		pincodeTextField = new JTextField();
		pincodeTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		pincodeTextField.setBounds(300, 540, 400, 30);
		add(pincodeTextField);
		
		// Next Button
		next = new JButton("NEXT");
		next.setFont(new Font("Raleway", Font.BOLD, 14));
		next.setBounds(620, 600, 80, 30);
		next.addActionListener(this);
		add(next);
		
		getContentPane().setBackground(Color.WHITE);
		setSize(850, 700);
		setLocation(350, 50);
		setVisible(true);
		
	}
	
	// Assigning values that user enters
	public void actionPerformed(ActionEvent ae) {
		String formNo = "" + random; // long value converted to String
		
		// Name Assigning
		String name = nameTextField.getText();
		
		// DOB Assigning
		String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
		
		// Gender Assigning
		String gender = null;
		if (male.isSelected()) {
			gender = "Male";
		}
		else if (female.isSelected()) {
			gender = "Female";
		}
		else if (nonbinary.isSelected()) {
			gender = "Non-Binary";
		}
		
		// Email Assigning
		String email = emailTextField.getText();
		
		// Marital Assigning
		String marital = null;
		if (married.isSelected()) {
			marital = "Married";
		}
		else if (unmarried.isSelected()) {
			marital = "Unmarried";
		}
		else if (other.isSelected()) {
			marital = "Other";
		}
		
		// Address and other Assigning
		String address = addressTextField.getText();
		String city = cityTextField.getText();
		String state = stateTextField.getText();
		String pincode = pincodeTextField.getText();
		
		// Validation
		try {
			if (name.equals("")) {
				JOptionPane.showMessageDialog(null, "Name is required.");
			}
			else {
				// SQL Connection
				Connection c = new Connection();
				String query = "INSERT INTO signup VALUES ('"+formNo+"', '"+name+"', '"+dob+"', '"+gender+"', '"+email+"', '"+marital+"', '"+address+"', '"+city+"', '"+state+"','"+pincode+"')";
				c.s.executeUpdate(query);
				
				// Singup Two
				setVisible(false);
				new SignupTwo(formNo).setVisible(true); 
			} 
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

	public static void main(String[] args) {
		new SignupOne();
	}

}
