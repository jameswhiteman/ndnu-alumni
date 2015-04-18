/**
 * Class: ProjectBackend.java
 * Developer: Rich Hoggan
 * Creation Date: 02-22-2015
 * Description: Handles all back end communication with the database to the Project table. 
 * Updated 4/17/15 by Ryan Bollier - added the insert, select, update, and delete cases
 */

//Package Declarations
package senior_project;

//Import Directives
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
	
	////Constructors////
	/**
	 * Method Description: Creates a new ProjectBackend object on instantiation
	 * and gets a connection to the database.
	 */
	public ProjectsBackend()
	{
	   DBConnection dbc = new DBConnection();
	   conn = dbc.getConnection();
	   try 
	   {
		   stmt = conn.createStatement();
	   }
	   catch (SQLException sqlex) 
	   {
		   sqlex.printStackTrace();
	   }
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
		Statement stmt = getStatement();

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

	/**
	 * Method Description: Returns all attributes associated with a project based on the 
	 * project name.
	 * @param name - the project's name
	 * @return Project object
	 */
	public Project getProject(String name) 
	{
		//Variable declarations
		String getProjectQuery = "";
		Project proj = new Project();
		PreparedStatement preparedStmt = null;
		ResultSet resultSetObject = null;
		int projectID = 0;
		String projectName = "";
		int projectYear = 0;
		String projectAbstract = "";
		
		//Validate the arguments before attempting to pass to the database
		if (!name.equals(""))
		{
			//Set the getProjectQuery
			getProjectQuery = "select * from Project where projectName = ?";
			
			try
			{
				preparedStmt = conn.prepareStatement(getProjectQuery);
				preparedStmt.setString(1, name);
				resultSetObject = preparedStmt.executeQuery();
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
	 * Method Description: Returns an ArrayList of all Project including their names
	 * and completion years.
	 * @param name - the project's name
	 * @return ArrayList<Project>
	 */

	/*
	public ArrayList<Project> getAllProjectNamesAndYears() 
	{
		//Variable declarations
		String getProjectNamesYearsQuery = "";
		ResultSet resultSetObject = null;
		int projectID = 0;
		String projectName = "";
		int projectYear = 0;
		String projectAbstract = "";
		ArrayList<Project> projectNamesAndYears = new ArrayList<Project>();
		
		//Validate the arguments before attempting to pass to the database
		//Set the getProjectQuery
		getProjectNamesYearsQuery = "select ProjectName, ProjectYear from Project";
		
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
			System.out.println("Unable to get all Project.");
			System.out.println("The database could not be quired.");
		}
		
		return projectNamesAndYears;
	}
	*/
}