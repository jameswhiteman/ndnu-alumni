/**
 * Class Name: Feedback.java
 * Developer: Ryan Bollier
 * Modified by from Document.java by Rich Hogan
 * Creation Date: 02-27-2015
 * Description: This class describes feedback within the context of the AlumniNetwork web application.
 */

//Package Declarations
package com.ndnu.alumni.model;

public class Feedback
{
	////Data Members////
	private int questionID;
	private int questionOne;
	private int questionTwo;
	private int questionThree;
	private int questionFour;
	private int questionFive;
	private String comments;

	////Constructors////
	/**
	 * Method Description: Sets the questionID data member to -1 initially
	 * and sets the other data members to null.
	 */
	public Feedback()
	{
		this.questionID = -1;
		this.questionOne = 0;
		this.questionTwo = 0;
		this.questionThree = 0;
		this.questionFour = 0;
		this.questionFive = 0;
		this.comments = "";
	}

	////Getters and Setters////
	/**
	 * Method Description: Sets the documentID data member.
	 * @param questionID
	 */
	public void setQuestionID(int questionID)
	{
		this.questionID = questionID;
	}

	/**
	 * Method Description: Sets the questionOne data member.
	 * @param questionOne
	 */
	public void setQuestionOne(int questionOne)
	{
		this.questionOne = questionOne;
	}

	/**
	 * Method Description: Sets the questionTwo data member.
	 * @param questionTwo
	 */
	public void setQuestionTwo(int questionTwo)
	{
		this.questionTwo = questionTwo;
	}

	/**
	 * Method Description: Sets the questionThree data member.
	 * @param questionThree
	 */
	public void setQuestionThree(int questionThree)
	{
		this.questionThree = questionThree;
	}

	/**
	 * Method Description: Sets the questionFour data member.
	 * @param questionFour
	 */
	public void setQuestionFour(int questionFour)
	{
		this.questionFour = questionFour;
	}

	/**
	 * Method Description: Sets the questionFive data member.
	 * @param questionFive
	 */
	public void setQuestionFive(int questionFive)
	{
		this.questionFive = questionFive;
	}

	/**
	 * Method Description: Sets the comments data member.
	 * @param comments
	 */
	public void setComments(String comments)
	{
		this.comments = comments;
	}

	/**
	 * Method Description: Returns the questionID data member.
	 * @return questionID
	 */
	public int getQuestionID()
	{
		return this.questionID;
	}

	/**
	 * Method Description: Returns the questionOne data member.
	 * @return questionOne
	 */
	public int getQuestionOne()
	{
		return this.questionOne;
	}

	/**
	 * Method Description: Returns the questionTwo data member.
	 * @return questionTwo
	 */
	public int getQuestionTwo()
	{
		return this.questionTwo;
	}

	/**
	 * Method Description: Returns the questionThree data member.
	 * @return questionThree
	 */
	public int getQuestionThree()
	{
		return this.questionThree;
	}

	/**
	 * Method Description: Returns the questionFour data member.
	 * @return questionFour
	 */
	public int getQuestionFour()
	{
		return this.questionFour;
	}

	/**
	 * Method Description: Returns the questionfive data member.
	 * @return questionfive
	 */
	public int getQuestionFive()
	{
		return this.questionFive;
	}

	/**
	 * Method Description: Returns the comments data member.
	 * @return comments
	 */
	public String getComments()
	{
		return this.comments;
	}

	////Printing Methods////
	/**
	 * Method Description: Method override of the toString() method for returning data member
	 * references.
	 */
	public String toString()
	{
		return("Question ID: " + this.questionID + "\n"
				+ "Question One: " + this.questionOne + "\n"
				+ "Question Two: " + this.questionTwo + "\n"
				+ "Question Three: " + this.questionThree + "\n"
				+ "Question Four: " + this.questionFour + "\n"
				+ "Question Five: " + this.questionFive + "\n"
				+ "Comments: " + this.comments + "\n");
	}
}
