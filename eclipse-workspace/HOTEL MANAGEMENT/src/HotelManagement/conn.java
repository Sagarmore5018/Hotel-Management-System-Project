package HotelManagement;

import java.sql.*;

public class conn {
	Connection c;
	Statement s;
	
	public conn() {
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/projecthms","root","vIJAY@5321");
			s = c.createStatement();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}