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
	private String password;

	public DBConnection() {
		conn = null;
		getConnectionInfo();
	}

	private void getConnectionInfo() {
//		Properties props = new Properties();
//                // Be careful with the filepath for dbconnection.props
//		try {
//		   FileInputStream propsData =
//			new FileInputStream("./WebContent/WEB-INF/dbconnection3.props");
//		   props.load(propsData);
//		   propsData.close();
//		} catch (IOException e) {
//		  e.printStackTrace();
//		  return;
//		}
//
//		url = props.getProperty("jdbc:mysql://localhost:3306");
//		driver = props.getProperty("com.mysql.jdbc.Driver");
//		login = props.getProperty(“dbuser1”);
//		password = props.getProperty(“welcome”);

		url = "jdbc:mysql://localhost:3306";
		driver = "com.mysql.jdbc.Driver";
		login = "dbuser1";
		password = "welcome" ;
	}

	public Connection getConnection()
	{
		try
		{
		     Class.forName(driver).newInstance();
//	             conn = DriverManager.getConnection(url, login, password);
	             conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "dbuser1", "welcome");
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
