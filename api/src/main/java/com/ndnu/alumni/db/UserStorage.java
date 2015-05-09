
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

import org.mindrot.jbcrypt.BCrypt;

import static com.ndnu.alumni.model.User.Major;

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
	public void createUser(String first, String last, String email, String password, String type, int year, String major, String phone, String about, String image) throws SQLException
    {
        //Variable declarations
        String query = "insert into users (FirstName,LastName,Email,Password,UserType,GradYear,Major,PhoneNumber,Description,Image) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, first);
        statement.setString(2, last);
        statement.setString(3, email);
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        statement.setString(4, hashedPassword);
        statement.setString(5, type);
        statement.setInt(6, year);
        statement.setString(7, major);
        statement.setString(8, phone);
        statement.setString(9, about);
        statement.setString(10, image);
        statement.executeUpdate();
	}

    // Read users
	public List<User> readUsers() throws SQLException
	{
        String query = "select * from users";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        List<User> users = new ArrayList<User>();
        User user = null;
        while (resultSet.next())
        {
            String id = resultSet.getInt(1) + "";
            String first = resultSet.getString(2);
            String last = resultSet.getString(3);
            String type = resultSet.getString(6);
            String title = resultSet.getString(8);
            int year = resultSet.getInt(10);
            String rawMajor = resultSet.getString(11);
            String phone = resultSet.getString(12);
            String email = resultSet.getString(13);
            String city = resultSet.getString(14);
            String state = resultSet.getString(15);
            String about = resultSet.getString(16);
            String page = resultSet.getString(17);
            String image = resultSet.getString(18);
            Major major = User.getMajorForString(rawMajor);
            user = new User(id, first, last, type, title, year, major, phone, email, city, state, about, page, image);
            users.add(user);
        }
        return users;
	}

	/**
	 * Method Description: Returns all attributes associated with a project based on the
	 * project name.
	 * @param id - the user's ID
	 * @return the User object model for the given ID
	 */
	public User login(String identifier, String verifier) throws SQLException
	{
        String query = "select Password,UserId from users where Email=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, identifier);
        statement.executeQuery();
        ResultSet resultSet = statement.executeQuery();
        String id = "";
        while (resultSet.next())
        {
            String storedPassword = resultSet.getString(1);
            if (!BCrypt.checkpw(verifier, storedPassword))
            {
                throw new SQLException();
            }
            id = resultSet.getString(2);
        }

        // Get the user if password validates.
        query = "select * from users where UserId=?";
        statement = connection.prepareStatement(query);
        statement.setString(1, id);
        resultSet = statement.executeQuery();
        User user = null;
        while (resultSet.next())
        {
            id = resultSet.getInt(1) + "";
            String first = resultSet.getString(2);
            String last = resultSet.getString(3);
            String type = resultSet.getString(6);
            String title = resultSet.getString(8);
            int year = resultSet.getInt(10);
            String rawMajor = resultSet.getString(11);
            String phone = resultSet.getString(12);
            String email = resultSet.getString(13);
            String city = resultSet.getString(14);
            String state = resultSet.getString(15);
            String about = resultSet.getString(16);
            String page = resultSet.getString(17);
            String image = resultSet.getString(18);
            Major major = User.getMajorForString(rawMajor);
            user = new User(id, first, last, type, title, year, major, phone, email, city, state, about, page, image);
        }
        return user;
	}
}
