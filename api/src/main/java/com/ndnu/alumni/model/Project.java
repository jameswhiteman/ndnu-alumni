/**
 * Class: Projects.java
 * Developer: Ryan Bollier
 * Creation Date: 02-20-2015
 * Description: Addapted from Users.java by Rich Hoggan The data class for Projects in the AlumniNetwork application.
 * Uodated: added the command char
 *
 * @Ryan Bollier
 */

//Package Declarations
package com.ndnu.alumni.model;

public class Project
{
	////Data Members////
	private int projectId;
	private String projectName;
	private int projectYear;
	private String projectAbstract;
	private char command;

	////Class Constructors////
	/**
	 * Method Description: Empty constructor that sets data members to null values.
	 *
	 */
	public Project()
	{
		this.projectId = 0;
		this.projectName = "";
		this.projectYear = 0;
		this.projectAbstract = "";
	}

	public Project(int projectId, String projectName, int projectYear,
			String projectAbstract)
	{
		this.projectId = projectId;
		this.projectName = projectName;
		this.projectYear = projectYear;
		this.projectAbstract = projectAbstract;
		this.command = 'q';
	}

	/**
	 * Method Description: Constructor that sets data members to user supplied input.
	 * @param projectId
	 * @param projectName
	 * @param projectYear
	 * @param projectAbstract
	 */
	public Project(int projectId, String projectName, int projectYear,
			String projectAbstract, char action)
	{
		this.projectId = projectId;
		this.projectName = projectName;
		this.projectYear = projectYear;
		this.projectAbstract = projectAbstract;
		this.command = action;
	}

	////Getters and Setters////

	//BEGIN SETTERS//
	/**
	 * Method Description: Sets the projectId data member.
	 * @param prjectId
	 */
	public void setProjectId(int projectId)
	{
		this.projectId = projectId;
	}

	/**
	 * Method Description: Sets the projectName data member.
	 * @param projectName
	 */
	public void setProjectName(String projectName)
	{
		this.projectName = projectName;
	}

	/**
	 * Method Description: Sets the projectYear data member.
	 * @param prijectYear
	 */
	public void setProjectYear(int projectYear)
	{
		this.projectYear = projectYear;
	}

	/**
	 * Method Description: Sets the projectAbstract data member.
	 * @param projectAbstract
	 */
	public void setProjectAbstract(String projectAbstract)
	{
		this.projectAbstract = projectAbstract;
	}

	//BEGIN GETTERS//
	/**
	 * Method Description: Returns a reference to the projectId data member.
	 * @return projectId
	 */
	public int getProjectId()
	{
		return this.projectId;
	}

	/**
	 * Method Description: Returns a reference to the projectName data member.
	 * @return projectName
	 */
	public String getProjectName()
	{
		return this.projectName;
	}

	/**
	 * Method Description: Returns a reference to the projectYear data member.
	 * @return projectYear
	 */
	public int getProjectYear()
	{
		return this.projectYear;
	}

	/**
	 * Method Description: Returns a reference to the projectAbstract data member.
	 * @return projectAbstract
	 */
	public String getProjectAbstract()
	{
		return this.projectAbstract;
	}

	////Returning Methods////
	/**
	 * Method Description: Override of toString
	 * @return all data members
	 */
	public String toString()
	{
		return (this.projectId + "\n" + this.projectName + "\n"
				+ this.projectYear + "\n" + this.projectAbstract + "\n");
	}
}
