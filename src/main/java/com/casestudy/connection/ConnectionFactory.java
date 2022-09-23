package com.casestudy.connection;
import java.sql.* ;

import java.util.ResourceBundle;

// a connection factory class to connect our application to the database
// it contains the user name and password of the database
public class ConnectionFactory {
	public static Connection getMySqlConnection() {
		Connection con = null ; 
		try
		{
			/* here application is the application.properties which contains the information required for 
			   connecting to the database */
			ResourceBundle bundle = ResourceBundle.getBundle("application") ; 
			
			// storing the URL
			String url = bundle.getString("url") ; 
			
			// storing the user name 
			String username = bundle.getString("username") ; 
			
			// storing the password
			String password = bundle.getString("password") ;
			
			// creating connection
			con = DriverManager.getConnection(url, username, password) ; 
		} 
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		
		return con ; 
	}
}
