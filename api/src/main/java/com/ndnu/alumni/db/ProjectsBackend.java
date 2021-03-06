/**
 * Class: ProjectBackend.java
 * Developer: Rich Hoggan
 * Creation Date: 02-22-2015
 * Description: Handles all back end communication with the database to the Project table.
 * Updated 4/17/15 by Ryan Bollier - added the insert, select, update, and delete cases
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
import java.util.List;

import com.ndnu.alumni.model.Project;

//import jdbc_session3.DBConnection;

public class ProjectsBackend
{
	public final static char QUERY = 'S';
	public final static char UPDATE = 'U';
	public final static char DELETE = 'D';
	public final static char INSERT = 'I';

	////Data Members////
	private Connection conn;
	private Statement stmt;
    private DBConnection dbc;

	////Constructors////
	/**
	 * Method Description: Creates a new ProjectBackend object on instantiation
	 * and gets a connection to the database.
	 */
	public ProjectsBackend() throws SQLException
	{
        dbc = new DBConnection();
	}

	public Statement getStatement() {
		   Statement stmt = null;
		   try {
		     // In order to get an updatable result set, the Statement
		     // object we create must be updatable.
			   stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
				     		 ResultSet.CONCUR_UPDATABLE);
		   }catch (SQLException ex) {
		       ex.printStackTrace();
		   }

		   return stmt;
		}

	/**
	 * Method Description: Inserts a project into the web application.
	 * Data that is passed includes: the project's name, the year the project was implemented,
	 * and the project's abstract.
	 * @param projectName
	 * @param projectID
	 * @param projectYear
	 * @param projectAbstract
	 */
	public void processProject(Project project, char command)
	{
		//Variable declarations
		String query = "Select projectID, projectName, projectYear, projectAbstracts from Projects";
		try {
			ResultSet rs = stmt.executeQuery(query);

			switch (command) {
				case QUERY:
				int row1 = 1;
				while (rs.next()) {
					if (rs.getInt("projectID") == project.getProjectId()) {
						rs.absolute(row1);
						project.setProjectId(rs.getInt(1));
						project.setProjectName(rs.getString(2));
						project.setProjectYear(rs.getInt(3));
						project.setProjectAbstract(rs.getString(4));

						System.out.println(project.getProjectId() + "\t" + project.getProjectName()
							+ "\t" + project.getProjectYear() + "\t" + project.getProjectAbstract());
					}
					++row1;
				}
				break;

				case UPDATE:
				int row = 1;
				while (rs.next()) {
					if (rs.getInt("projectID") == project.getProjectId()) {
						rs.absolute(row);
						rs.updateInt("ProjectID", project.getProjectId());
						rs.updateString("ProjectName", project.getProjectName());
						rs.updateInt("ProjectYear", project.getProjectYear());
						rs.updateString("ProjectAbstracts", project.getProjectAbstract());
						rs.updateRow();
					}
					++row;
				}
				break;

				case DELETE:
				while (rs.next()) {
					if (rs.getInt("projectID") == project.getProjectId()) {
						//The cursor is already positioned to the row
	 					//we want to delete.
	 					rs.deleteRow();
					}
				}
				break;

				case INSERT:
				rs.moveToInsertRow();
				rs.updateInt("ProjectID", project.getProjectId());
				rs.updateString("ProjectName", project.getProjectName());
				rs.updateInt("ProjectYear", project.getProjectYear());
				rs.updateString("ProjectAbstracts", project.getProjectAbstract());
				rs.insertRow();
				break;
			}
			rs.close();
		}

		catch (SQLException ex) {
	 	       ex.printStackTrace();
	 	   }

	 	finally {

	 	   // Explicit closure of Statement object, instead of
	 	   // waiting for automatic closure.
	 	   try {
	 		   conn.close();
	 	       stmt.close();
	 	   }

	 	   catch (SQLException ex) {
	 	       ex.printStackTrace();
	 	   }
	 	}

	}


	public List<Project> readProjects() throws SQLException
	{
        Connection conn = dbc.getConnection();
        String query = "select * from ndnualumni.projects order by ProjectYear";
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        List<Project> projects = new ArrayList<Project>();
        while (resultSet.next())
        {
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            int year = resultSet.getInt(3);
            String description = resultSet.getString(4);
            Project project = new Project(id, name, year, description);
            projects.add(project);
        }
        dbc.closeConnection();
        return projects;
    }

    public void createProject(String name, int year, String description) throws SQLException
    {
        Connection conn = dbc.getConnection();
        String query = "insert into ndnualumni.projects (ProjectName, ProjectYear, ProjectAbstracts) values (?, ?, ?)";
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setString(1, name);
        statement.setInt(2, year);
        statement.setString(3, description);
        statement.executeUpdate();
        dbc.closeConnection();
    }
}
