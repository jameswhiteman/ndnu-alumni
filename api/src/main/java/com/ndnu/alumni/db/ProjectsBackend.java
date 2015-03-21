/**
 * Class: ProjectsBackend.java
 * Developer: Rich Hoggan
 * Creation Date: 02-22-2015
 * Description: Handles all back end communication with the database to the Projects table.
 */

//Package Declarations
package com.ndnu.alumni.db;

//Import Directives
import com.ndnu.alumni.model.Project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;
import java.util.List;
import java.util.ArrayList;

//import jdbc_session3.DBConnection;

public class ProjectsBackend
{
	////Data Members////
	private Connection connectionObject;
	private Statement statementObject;
    private String host = "jdbc:mysql://localhost:3306";
    private String user = "root";
    private String password = "american";

	////Constructors////
	/**
	 * Method Description: Creates a new ProjectsBackend object on instantiation
	 * and gets a connection to the database.
	 */
	public ProjectsBackend() throws SQLException
	{
        DBConnection dbc = new DBConnection();
        connectionObject = dbc.getConnection();
        statementObject = connectionObject.createStatement();
		String query = "use ndnualumni;";
        statementObject.executeQuery(query);
	}

	/**
	 * Method Description: Inserts a project into the web application.
	 * Data that is passed includes: the project's name, the year the project was implemented,
	 * and the project's abstract.
	 * @param projectName
	 * @param projectYear
	 * @param projectAbstract
	 */
	public void addProject(int projectID, String projectName, int projectYear, String projectAbstract)
	{
		//Variable declarations
		String addProjectQuery = "";
		PreparedStatement preparedStatementObject = null;

		//Validate the arguments have values before attempting to
		//pass to the database
		if (!projectName.equals("") && projectYear != 0 && !projectAbstract.equals(""))
		{
			//Set the addProjectQuery
			addProjectQuery = "insert into Projects values (?, ?, ?, ?)";

			try
			{
				preparedStatementObject = connectionObject.prepareStatement(addProjectQuery);
				preparedStatementObject.setInt(1, projectID);
				preparedStatementObject.setString(2, projectName);
				preparedStatementObject.setInt(3, projectYear);
				preparedStatementObject.setString(4, projectAbstract);
				preparedStatementObject.executeUpdate();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
				System.out.println("Unable to add project.");
				System.out.println("The database could not be quired.");
			}
		}
	}

	/**
	 * Method Description: Returns all attributes associated with a project based on the
	 * project name.
	 * @param name - the project's name
	 * @return Projects object
	 */
	public Project getProject(String name)
	{
		//Variable declarations
		String getProjectQuery = "";
		Project proj = new Project();
		PreparedStatement preparedStatementObject = null;
		ResultSet resultSetObject = null;
		int projectID = 0;
		String projectName = "";
		int projectYear = 0;
		String projectAbstract = "";

		//Validate the arguments before attempting to pass to the database
		if (!name.equals(""))
		{
			//Set the getProjectQuery
			getProjectQuery = "select * from Projects where projectName = ?";

			try
			{
				preparedStatementObject = connectionObject.prepareStatement(getProjectQuery);
				preparedStatementObject.setString(1, name);
				resultSetObject = preparedStatementObject.executeQuery();
				while (resultSetObject.next())
				{
					//Get row data
					projectID = resultSetObject.getInt(1);
					projectName = resultSetObject.getString(2);
					projectYear = resultSetObject.getInt(3);
					projectAbstract = resultSetObject.getString(4);

					//Set project object
					proj.setProjectId(projectID);
					proj.setProjectName(projectName);
					proj.setProjectYear(projectYear);
					proj.setProjectAbstract(projectAbstract);
				}
			}
			catch (SQLException e)
			{
				e.printStackTrace();
				System.out.println("Unable to add project.");
				System.out.println("The database could not be quired.");
			}
		}

		return proj;
	}

	/**
	 * Method Description: Returns an ArrayList of all projects including their names
	 * and completion years.
	 * @param name - the project's name
	 * @return List<Project>
	 */
	public List<Project> getAllProjectNamesAndYears()
	{
		//Variable declarations
		String getProjectNamesYearsQuery = "";
		ResultSet resultSetObject = null;
		int projectID = 0;
		String projectName = "";
		int projectYear = 0;
		String projectAbstract = "";
		List<Project> projectNamesAndYears = new ArrayList<Project>();

		//Validate the arguments before attempting to pass to the database
		//Set the getProjectQuery
		getProjectNamesYearsQuery = "select ProjectName, ProjectYear from Projects";

		try
		{
			resultSetObject = statementObject.executeQuery(getProjectNamesYearsQuery);
			while (resultSetObject.next())
			{
				Project proj = new Project();

				//Get row data
				projectName = resultSetObject.getString("ProjectName");
				projectYear = resultSetObject.getInt("ProjectYear");

				//Set project object
				proj.setProjectId(projectID);
				proj.setProjectName(projectName);
				proj.setProjectYear(projectYear);
				proj.setProjectAbstract(projectAbstract);

				//Add each to the array list
				projectNamesAndYears.add(proj);
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			System.out.println("Unable to get all projects.");
			System.out.println("The database could not be quired.");
		}

		return projectNamesAndYears;
	}
}
