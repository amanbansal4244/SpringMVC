/*
 * 1. import ---> java.sql
 * 2. load and register the driver --> com.mysql.jdbc.Driver
 * 3. create connection ----> Connection
 * 4. create a statement ----> Statement
 * 5. execute the query ->
 * 6. process the results ->
 * 7. close the connection.

*/

import java.sql.*;

import com.sun.corba.se.impl.ior.GenericTaggedComponent;
public class DemoClass {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		String url ="jdbc:mysql://127.0.0.1:3306/test"; // test -> database name, 3306: port no, 127.0.0.1: IP of installed db server, mysql: we are using mysql, jdbc -> working with JDBC
		String uname ="root"; // root: by default user name when we installed mysql server
		String pass ="Proxy_11";
		String query ="select * from login";
		
		Class.forName("com.mysql.jdbc.Driver"); //for name is a method which will help you to load the drivers.
		Connection con = DriverManager.getConnection(url, uname, pass); // getConnection() is a static method of 'DriverManager' class which gives instance of Connection(class- which implements the 'Connection' interface)
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		
		while(rs.next()){
			String userName= rs.getString("username");
			String password= rs.getString("password");
			
			System.out.println("username:" + userName + " and " + "Password:" + password);
		}
		stmt.close();
		con.close();
		
	}
}
