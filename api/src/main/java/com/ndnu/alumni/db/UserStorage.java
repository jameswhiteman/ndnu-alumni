
/**
 * Class: ProjectsBackend.java
 * Developer: Rich Hoggan
 * Creation Date: 02-22-2015
 * Description: Handles all back end communication with the database to the Users table.
 */

//Package Declarations
package com.ndnu.alumni.db;

//Import Directives
import com.ndnu.alumni.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;
import java.util.List;
import java.util.ArrayList;

//import jdbc_session3.DBConnection;

public class UserStorage
{
	////Data Members////
	private Connection connection;

	////Constructors////
	/**
	 * Method Description: Creates a new ProjectsBackend object on instantiation
	 * and gets a connection to the database.
	 */
	public UserStorage() throws SQLException
	{
        DBConnection dbc = new DBConnection();
        connection = dbc.getConnection();

        // Use the default DB.
        Statement statement = connection.createStatement();
		String query = "use ndnualumni;";
        statement.executeQuery(query);
	}

	/**
	 * Method Description: Inserts a project into the web application.
	 * Data that is passed includes: the project's name, the year the project was implemented,
	 * and the project's abstract.
	 * @param projectName
	 * @param projectYear
	 * @param projectAbstract
	 */
	public void createUser(String first, String last, String email, int year, String major, String phone, String about) throws SQLException
    {
        //Variable declarations
        String query = "insert into users (FirstName,LastName,Email,GradYear,Major,PhoneNumber,Description) values (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, first);
        statement.setString(2, last);
        statement.setString(3, email);
        statement.setInt(4, year);
        statement.setString(5, major);
        statement.setString(6, phone);
        statement.setString(7, about);
        statement.executeUpdate();
	}

	/**
	 * Method Description: Returns all attributes associated with a project based on the
	 * project name.
	 * @param id - the user's ID
	 * @return the User object model for the given ID
	 */
	public User readUser(String id) throws SQLException
	{
        String query = "select * from users where UserId=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, id);
        ResultSet resultSet = statement.executeQuery();
        User user = null;
        while (resultSet.next())
        {
            String projectId = resultSet.getInt(2) + "";
            String first = resultSet.getString(3);
            String last = resultSet.getString(4);
            int year = resultSet.getInt(5);
            String major = resultSet.getString(6);
            String phone = resultSet.getString(7);
            String email = resultSet.getString(8);
            String city = resultSet.getString(9);
            String state = resultSet.getString(10);
            String about = resultSet.getString(11);
            String page = resultSet.getString(12);
            user = new User(id, first, last, year, major, phone, email, city, state, about, page);
        }
        return user;
	}
}