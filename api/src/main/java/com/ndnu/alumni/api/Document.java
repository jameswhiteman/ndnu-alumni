/**
 * Class Name: Document.java
 * Developer: Rich Hoggan
 * Creation Date: 02-20-2015
 * Description: This class describes a document within the context of the AlumniNetwork web application.
 */

//Package Declarations
package com.ndnu.alumni.api;

public class Document
{
	////Data Members////
	private int documentID;
	private int projectID;
	private String documentName;
	private String documentType;
	private String documentLocation;

	////Constructors////
	/**
	 * Method Description: Sets the documentID and projectID data members to -1 initially
	 * and sets the other data members to null.
	 */
	public Document()
	{
		this.documentID = -1;
		this.projectID = -1;
		this.documentName = "";
		this.documentType = "";
		this.documentLocation = "";
	}

	////Getters and Setters////
	/**
	 * Method Description: Sets the documentID data member.
	 * @param documentID
	 */
	public void setDocumentID(int documentID)
	{
		this.documentID = documentID;
	}

	/**
	 * Method Description: Sets the projectID data member.
	 * @param projectID
	 */
	public void setProjectID(int projectID)
	{
		this.projectID = projectID;
	}

	/**
	 * Method Description: Sets the documentName data member.
	 * @param documentName
	 */
	public void setDocumentName(String documentName)
	{
		this.documentName = documentName;
	}

	/**
	 * Method Description: Sets the documentType data member.
	 * @param documentType
	 */
	public void setDocumentType(String documentType)
	{
		this.documentType = documentType;
	}

	/**
	 * Method Description: Sets the documentLocation data member.
	 * @param documentLocation
	 */
	public void setDocumentLocation(String documentLocation)
	{
		this.documentLocation = documentLocation;
	}

	/**
	 * Method Description: Returns the documentID data member.
	 * @return documentID
	 */
	public int getDocumentID()
	{
		return this.documentID;
	}

	/**
	 * Method Description: Returns the projectID data member.
	 * @return projectID
	 */
	public int getProjectID()
	{
		return this.projectID;
	}

	/**
	 * Method Description: Returns the documentName data member.
	 * @return documentName
	 */
	public String getDocumentName()
	{
		return this.documentName;
	}

	/**
	 * Method Description: Returns the documentType data member.
	 * @return documentType
	 */
	public String getDocumentType()
	{
		return this.documentType;
	}

	/**
	 * Method Description: Returns the documentLocation data member.
	 * @return documentLocation
	 */
	public String getDocumentLocation()
	{
		return this.documentLocation;
	}

	////Printing Methods////
	/**
	 * Method Description: Method override of the toString() method for returning data member
	 * references.
	 */
	public String toString()
	{
		return("Document ID: " + this.documentID + "\n"
				+ "Project ID: " + this.projectID + "\n"
				+ "Document Name: " + this.documentName + "\n"
				+ "Document Type: " + this.documentType + "\n"
				+ "Document Location: " + this.documentLocation + "\n");
	}
}
