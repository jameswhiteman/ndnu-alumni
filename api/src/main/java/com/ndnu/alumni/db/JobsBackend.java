/**
 * Class: JobsBackend.java
 * Developer: Ryan Bollier
 * Creation Date: 03-18-2015
 * Description: Handles all back end communication with the database to the Jobs table.
 */

//Package Declarations
package com.ndnu.alumni.db;

//Import Directives
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ndnu.alumni.model.*;

//import jdbc_session3.DBConnection;

public class JobsBackend
{
	////Data Members////
	private Connection connectionObject;
	private Statement statementObject;

	////Constructors////
	/**
	 * Method Description: Creates a new JobsBackend object on instantiation
	 * and gets a connection to the database.
	 */
	public JobsBackend()
	{
	   DBConnection dbc = new DBConnection();
	   connectionObject = dbc.getConnection();
	   try
	   {
		   statementObject = connectionObject.createStatement();
	   }
	   catch (SQLException sqlex)
	   {
		   sqlex.printStackTrace();
	   }
	}

		/**
	 * Method Description: Inserts a Job into the web application.
	 * Data that is passed includes: the job's title, the company name, the salary,
	 * a description of the job, a job type, start date, and end date.
	 * @param jobID
	 * @param userID
	 * @param jobTitle
	 * @param companyName
	 * @param salary
	 * @param description
	 * @param jobType
	 * @param startDate
	 * @param endDate
	 */
	public void addJob(int jobID, int userID, String jobTitle, String companyName, double salary,
		String description, String jobType, String startDate, String endDate)
	{
		//Variable declarations
		String addJobQuery = "";
		PreparedStatement preparedStatementObject = null;

		//Validate the arguments have values before attempting to
		//pass to the database
		if (!jobTitle.equals("") && !companyName.equals("") && salary != 0 && !description.equals("") &&
			!jobType.equals("") && !startDate.equals("") && !endDate.equals(""))
		{
			//Set the addJobQuery
			addJobQuery = "insert into Jobs values (?, ?, ?, ?, ?, ?, ?, ?, ?)";

			try
			{
				preparedStatementObject = connectionObject.prepareStatement(addJobQuery);
				preparedStatementObject.setInt(1, jobID);
				preparedStatementObject.setInt(2, userID);
				preparedStatementObject.setString(3, jobTitle);
				preparedStatementObject.setString(4, companyName);
				preparedStatementObject.setDouble(5, salary);
				preparedStatementObject.setString(6, description);
				preparedStatementObject.setString(7, jobType);
				preparedStatementObject.setString(8, startDate);
				preparedStatementObject.setString(9, endDate);
				preparedStatementObject.executeUpdate();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
				System.out.println("Unable to add job.");
				System.out.println("The database could not be quired.");
			}
		}
	}

	/**
	 * Method Description: Returns all attributes associated with a job
	 * based on the job name.
	 * @param name - the job's name
	 * @return jobs object
	 */
	public Jobs getJobs(String name)
	{
		//Variable declarations
		String getJobsQuery = "";
		Jobs jobs = new Jobs();
		PreparedStatement preparedStatementObject = null;
		ResultSet resultSetObject = null;
		int jobID = 0;
		int userID = 0;
		String jobTitle = "";
		String companyName = "";
		double salary = 0;
		String description = "";
		String jobType = "";
		String startDate = "";
		String endDate = "";

		//Validate the arguments before attempting to pass to the database
		if (!name.equals(""))
		{
			//Set the getJobsQuery
			getJobsQuery = "select * from Jobs where jobName = ?";

			try
			{
				preparedStatementObject = connectionObject.prepareStatement(getJobsQuery);
				preparedStatementObject.setString(1, name);
				resultSetObject = preparedStatementObject.executeQuery();
				while (resultSetObject.next())
				{
					//Get row data
					jobID = resultSetObject.getInt(1);
					userID = resultSetObject.getInt(2);
					jobTitle = resultSetObject.getString(3);
					companyName = resultSetObject.getString(4);
					salary = resultSetObject.getDouble(5);
					description = resultSetObject.getString(6);
					jobType = resultSetObject.getString(7);
					startDate = resultSetObject.getString(8);
					endDate = resultSetObject.getString(9);

					//Set job object
					jobs.setJobID(jobID);
					jobs.setUserID(userID);
					jobs.setJobTitle(jobTitle);
					jobs.setCompanyName(companyName);
					jobs.setSalary(salary);
					jobs.setDescription(description);
					jobs.setJobType(jobType);
					jobs.setStartDate(startDate);
					jobs.setEndDate(endDate);
				}
			}
			catch (SQLException e)
			{
				e.printStackTrace();
				System.out.println("Unable to add job.");
				System.out.println("The database could not be quired.");
			}
		}

		return jobs;
	}

	/**
	 * Method Description: Returns an ArrayList of all Jobs including their title,
	 * company name, salary, description, type, start date, and end date.
	 * @param name - the job's name
	 * @return ArrayList<Jobs>
	 */
	public ArrayList<Jobs> getAllProjectNamesAndYears()
	{
		//Variable declarations
		String getProjectNamesYearsQuery = "";
		ResultSet resultSetObject = null;
		int projectID = 0;
		String projectName = "";
		int projectYear = 0;
		String projectAbstract = "";
		ArrayList<Jobs> projectNamesAndYears = new ArrayList<Jobs>();

		//Validate the arguments before attempting to pass to the database
		//Set the getProjectQuery
		getProjectNamesYearsQuery = "select ProjectName, ProjectYear from Jobs";

		try
		{
			resultSetObject = statementObject.executeQuery(getProjectNamesYearsQuery);
			while (resultSetObject.next())
			{
				Jobs proj = new Jobs();

			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			System.out.println("Unable to get all Jobs.");
			System.out.println("The database could not be quired.");
		}

		return projectNamesAndYears;
	}
}
