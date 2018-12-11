package com.aman;

import java.sql.*;

public class LogInService {

	public boolean checkCredentials(String uname, String pass) throws ClassNotFoundException, SQLException {
		String url ="jdbc:mysql://127.0.0.1:3306/test"; // test -> database name, 3306: port no, 127.0.0.1: IP of installed db server, mysql: we are using mysql, jdbc -> working with JDBC
		String u ="root"; // root: by default user name when we installed mysql server
		String p ="Proxy_11";
		String query ="select * from login";
		
		Class.forName("com.mysql.jdbc.Driver"); //for name is a method which will help you to load the class.
		Connection con = DriverManager.getConnection(url, u, p); // getConnection() is a static method of 'DriverManager' class which gives instance of Connection(class- which implements the 'Connection' interface)
		PreparedStatement pst = con.prepareStatement("select * from login where username =? and password =?");
		pst.setString(1, uname);
		pst.setString(2, pass);
		
		ResultSet rs = pst.executeQuery();
		
		if(rs.next()){
			return true; // returns true when credentials gets matched and return true value to 'Login' controller
		}
		pst.close();
		con.close();
		return false;
	}
}
