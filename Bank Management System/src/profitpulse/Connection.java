package profitpulse;

import java.sql.*;

public class Connection {
	
		// JDBC: Register Driver, Create Connection, Create Statement, Execute Query, Close Connection
	
	java.sql.Connection c; 
	Statement s;
	public Connection() {
		// Exception Handling for Runtime errors
		try {
			// Create Connection
			c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "PUT PASSWORD HERE");
			s = c.createStatement();
		}
		catch (Exception e) {
			System.out.println(e);
		}  
	}
	
}
