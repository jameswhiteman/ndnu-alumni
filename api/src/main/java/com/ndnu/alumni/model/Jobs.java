/**
 * Class: Jobs.java
 * Developer: Eric Cardona
 * Creation Date: 02-12-2015
 * Description: The data class for Jobs in the AlumniNetwork application.
 *
 * @author Eric Cardona
 */

//Package Declarations
package com.ndnu.alumni.model;

public class Jobs
{
	////Data Members////
	private int JobID;
	private int UserID;
	private String JobTitle;
	private String CompanyName;
	private double Salary;
	private String Description;
	private String JobType;
	private String StartDate;
	private String EndDate;

	////Class Constructors////
	/**
	 * Method Description: Empty constructor that sets data members to null values.
	 *
	 */
	public Jobs()
	{
		this.JobID = 0;
		this.UserID = 0;
		this.JobTitle = "";
		this.CompanyName = "";
		this.Salary = 0.0;
		this.Description = "";
		this.JobType = "";
		this.StartDate = "";
		this.EndDate = "";
	}

	/**
	 * Method Description: Constructor that sets data members to user supplied input.
	 * @param JobID
	 * @param UserID
	 * @param JobTitle
	 * @param CompanyName
	 * @param Salary
	 * @param Description
	 * @param JobType
	 * @param StartDate
	 * @param EndDate
	 */
	public Jobs(int JobID, int UserID, String JobTitle,
			String CompanyName, double Salary, String Description, String JobType,
			String StartDate, String EndDate)
	{
		this.JobID = JobID;
		this.UserID = UserID;
		this.JobTitle = JobTitle;
		this.CompanyName = CompanyName;
		this.Salary = Salary;
		this.Description = Description;
		this.JobType = JobType;
		this.StartDate = StartDate;
		this.EndDate = EndDate;
	}

	////Getters and Setters////
	/**
	 * Method Description: Sets the JobID data member.
	 * @param JobID
	 */
	public void setJobID(int JobID)
	{
		this.JobID = JobID;
	}

	/**
	 * Method Description: Sets the UserID data member.
	 * @param UserID
	 */
	public void setUserID(int UserID)
	{
		this.UserID = UserID;
	}

	/**
	 * Method Description: Sets the JobTitle data member.
	 * @param JobTitle
	 */
	public void setJobTitle(String JobTitle)
	{
		this.JobTitle = JobTitle;
	}

	/**
	 * Method Description: Sets the CompanyName data member.
	 * @param CompanyName
	 */
	public void setCompanyName(String CompanyName)
	{
		this.CompanyName = CompanyName;
	}

	/**
	 * Method Description: Sets the Salary data member.
	 * @param Salary
	 */
	public void setSalary(double Salary)
	{
		this.Salary = Salary;
	}

	/**
	 * Method Description: Sets the Description data member.
	 * @param Description
	 */
	public void setDescription(String Description)
	{
		this.Description = Description;
	}

	/**
	 * Method Description: Sets the JobType data member.
	 * @param JobType
	 */
	public void setJobType(String JobType)
	{
		this.JobType = JobType;
	}

	/**
	 * Method Description: Sets the StartDate data member.
	 * @param StartDate
	 */
	public void setStartDate(String StartDate)
	{
		this.StartDate = StartDate;
	}

	/**
	 * Method Description: Sets the EndDate data member.
	 * @param EndDate
	 */
	public void setEndDate(String EndDate)
	{
		this.EndDate = EndDate;
	}

	/**
	 * Method Description: Returns a reference to the JobID data member.
	 * @return JobID
	 */
	public int getJobID()
	{
		return this.JobID;
	}

	/**
	 * Method Description: Returns a reference to the UserID data member.
	 * @return UserID
	 */
	public int getUserID()
	{
		return this.UserID;
	}

	/**
	 * Method Description: Returns a reference to the JobTitle data member.
	 * @return JobTitle
	 */
	public String getJobTitle()
	{
		return this.JobTitle;
	}

	/**
	 * Method Description: Returns a reference to the CompanyName data member.
	 * @return CompanyName
	 */
	public String getCompanyName()
	{
		return this.CompanyName;
	}

	/**
	 * Method Description: Returns a reference to the Salary data member.
	 * @return Salary
	 */
	public double getSalary()
	{
		return this.Salary;
	}

	/**
	 * Method Description: Returns a reference to the Description data member.
	 * @return Description
	 */
	public String getDescription()
	{
		return this.Description;
	}

	/**
	 * Method Description: Returns a reference to the JobType data member.
	 * @return JobType
	 */
	public String getJobType()
	{
		return this.JobType;
	}

	/**
	 * Method Description: Returns a reference to the StartDate data member.
	 * @return StartDate
	 */
	public String getStartDate()
	{
		return this.StartDate;
	}

	/**
	 * Method Description: Returns a reference to the EndDate data member.
	 * @return EndDate
	 */
	public String getEndDate()
	{
		return this.EndDate;
	}

	////Returning Methods////
	/**
	 * Method Description: Override of toString
	 * @return all data members
	 */
	public String toString()
	{
		return (this.JobID + "\n" + this.UserID + "\n" +
				this.JobTitle + "\n" + this.CompanyName + "\n" + this.Salary + "\n"  +
				this.Description + "\n" + this.JobType + "\n" + this.StartDate + "\n" +
				this.EndDate + "\n");
	}
}
