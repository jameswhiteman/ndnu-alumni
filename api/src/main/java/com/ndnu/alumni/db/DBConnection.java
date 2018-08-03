//Code Attribution: CIS2278 Rolly
package com.ndnu.alumni.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection
{
	private Connection conn;
	private String url;
	private String driver;
	private String login;

	public DBConnection() {
		conn = null;
		getConnectionInfo();
	}

	private void getConnectionInfo() {
		url = "jdbc:mysql://localhost:3306";
		driver = "com.mysql.jdbc.Driver";
		login = "root";
	}

	public Connection getConnection()
	{
		try
		{
		     Class.forName(driver).newInstance();
	             conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", null);
		}catch (ClassNotFoundException e) {
	           e.printStackTrace();
	  	}catch (SQLException sqlex) {
	           sqlex.printStackTrace();
	  	}catch (Exception ex) {
	           ex.printStackTrace();
	  	}

		return conn;
	}


    public void closeConnection() {
        try {
            conn.close();
        }catch (SQLException sqlex){
            sqlex.printStackTrace();
        }
    }
}
