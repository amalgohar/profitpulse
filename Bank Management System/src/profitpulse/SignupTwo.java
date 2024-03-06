package profitpulse;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignupTwo extends JFrame implements ActionListener {
	
	JComboBox citizenshipOption, raceOption, incomeOption, occupationOption; 
	JTextField ssnTextField, licenseTextField;
	JRadioButton sYes, sNo, eYes, eNo;
	JButton next;
	JDateChooser dateChooser;
	String formNo; 
	
	SignupTwo(String formno) {
		this.formNo = formno;
		setLayout(null);
	    
	    // Title
	    setTitle("New Account Application Form - Page 2");
		
		// Additional Details
		JLabel additionalDetails = new JLabel("Page 2: Additional Details");
		additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
		additionalDetails.setBounds(290, 60, 400, 30);
		add(additionalDetails);
		
		// Citizenship Status
		JLabel citizenship = new JLabel("Citizenship Status:");
		citizenship.setFont(new Font("Raleway", Font.BOLD, 20));
		citizenship.setBounds(100, 140, 200, 30);
		add(citizenship);	
		
		String valCitizenship[] = {"",
							"US Citizen", 
							"Permanent Resident", 
							"Non-Resident Alien", 
							"Temporary Visa Holder", 
							"Dual Citizen", 
							"Other"};
		citizenshipOption = new JComboBox(valCitizenship);
		citizenshipOption.setBounds(300, 140, 400, 30);
		add(citizenshipOption);
		
		// Race:
		JLabel race = new JLabel("Race:");
		race.setFont(new Font("Raleway", Font.BOLD, 20));
		race.setBounds(100, 190, 200, 30);
		add(race);

		String valRace[] = {"",
							"White", 
							"Black or African American", 
							"Asian", "Hispanic or Latino", 
							"Native American or Alaska Native", 
							"Native Hawaiian or Other Pacific Islander", 
							"Other"};
		raceOption = new JComboBox(valRace);
		raceOption.setBounds(300, 190, 400, 30);
		add(raceOption);
		
		// Income:
		JLabel income = new JLabel("Income:");
		income.setFont(new Font("Raleway", Font.BOLD, 20));
		income.setBounds(100, 240, 200, 30);
		add(income);
		
		String[] valIncome = {"",
			    "Less than $25,000",
			    "$25,000 - $49,999",
			    "$50,000 - $74,999",
			    "$75,000 - $99,999",
			    "$100,000 - $149,999",
			    "$150,000 or more"  
			};
		incomeOption = new JComboBox(valIncome);
		incomeOption.setBounds(300, 240, 400, 30);
		add(incomeOption);
		
		// Occupation:
		JLabel occupation = new JLabel("Occupation:");
		occupation.setFont(new Font("Raleway", Font.BOLD, 20));
		occupation.setBounds(100, 290, 200, 30);
		add(occupation);  
		
		String[] valOccupation = {"", 
			    "Student",
			    "Employed (Full-time)",
			    "Employed (Part-time)",
			    "Self-employed / Entrepeneur",
			    "Unemployed",
			    "Retired",
			    "Homemaker",
			    "Military",
			    "Other"
			};
		occupationOption = new JComboBox(valOccupation);
		occupationOption.setBounds(300, 290, 400, 30);
		add(occupationOption);
		
		// SSN Number 
		JLabel ssn = new JLabel("SSN Number:");
		ssn.setFont(new Font("Raleway", Font.BOLD, 20));
		ssn.setBounds(100, 340, 200, 30);
		add(ssn);
		
		ssnTextField = new JTextField();
		ssnTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		ssnTextField.setBounds(300, 340, 400, 30);
		add(ssnTextField);

		// Senior Citizen
		JLabel seniorCitizen = new JLabel("Senior Citizen:");
		seniorCitizen.setFont(new Font("Raleway", Font.BOLD, 20));
		seniorCitizen.setBounds(100, 390, 200, 30);
		add(seniorCitizen);
		
		sYes = new JRadioButton("Yes");
		sYes.setBounds(300, 390, 100, 30);
		sYes.setBackground(Color.WHITE);
		add(sYes);
		
		sNo = new JRadioButton("No");
		sNo.setBounds(450, 390, 100, 30);
		sNo.setBackground(Color.WHITE);
		add(sNo);
		
		ButtonGroup seniorGroup = new ButtonGroup(); 
		seniorGroup.add(sYes);
		seniorGroup.add(sNo);
		
		// Drivers License No.
		JLabel license = new JLabel("Drivers License:");
		license.setFont(new Font("Raleway", Font.BOLD, 20));
		license.setBounds(100, 440, 250, 30);
		add(license);
		
		licenseTextField = new JTextField();
		licenseTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		licenseTextField.setBounds(300, 440, 400, 30);
		add(licenseTextField);
		
		// Existing Account
		JLabel existingAccount = new JLabel("Existing Account:");
		existingAccount.setFont(new Font("Raleway", Font.BOLD, 20));
		existingAccount.setBounds(100, 490, 200, 30);
		add(existingAccount);
		
		eYes = new JRadioButton("Yes");
		eYes.setBounds(300, 490, 100, 30);
		eYes.setBackground(Color.WHITE);
		add(eYes);
		
		eNo = new JRadioButton("No");
		eNo.setBounds(450, 490, 100, 30);
		eNo.setBackground(Color.WHITE); 
		add(eNo);
		
		ButtonGroup existingAccountGroup = new ButtonGroup(); 
		existingAccountGroup.add(eYes); 
		existingAccountGroup.add(eNo);
		
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
		// Citizenship, Race, Income, Occupation Assigning
		String sCitizenship = (String) citizenshipOption.getSelectedItem();
		String sRace = (String) raceOption.getSelectedItem();
		String sIncome = (String) incomeOption.getSelectedItem();
		String sOccupation = (String) occupationOption.getSelectedItem();
		
		// SSN Assigning
		String sSSN = ssnTextField.getText();
		
		// Senior Citizen Assigning
		String sSeniorCitizen = null;
		if (sYes.isSelected()) {
			sSeniorCitizen = "Yes";
		}
		else if (sNo.isSelected()) {
			sSeniorCitizen = "No";
		}

		// Drivers License No Assigning
		String sLicense = licenseTextField.getText();
		
		// Existing Account Assigning
		String sExistingAccount = null;
		if (eYes.isSelected()) {
			sExistingAccount = "Yes";
		}
		else if (eNo.isSelected()) {
			sExistingAccount = "No";
		}
		 
		// Validation
		try {
			if (sCitizenship.equals("")) {
				JOptionPane.showMessageDialog(null, "Citizenship is required.");
			}
			else {
				// SQL Connection
				Connection c = new Connection();
				String query = "INSERT INTO signuptwo VALUES('"+formNo+"','"+sCitizenship+"', '"+sRace+"', '"+sIncome+"', '"+sOccupation+"', '"+sSSN+"', '"+sSeniorCitizen+"', '"+sLicense+"', '"+sExistingAccount+"')";
				c.s.executeUpdate(query);
				
				// Signup3 Object 
				setVisible(false);
				new SignupThree(formNo).setVisible(true);;
			}  
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

	public static void main(String[] args) {
		new SignupTwo("");
	}

}
