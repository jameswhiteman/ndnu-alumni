/**
 * Class: DocumentTester.java
 * Developer: Ryan Bollier
 * Modified by from DocumentTester.java by Rich Hogan
 * Creation Date: 02-27-2015
 * Description: This class tests the Document class and all necessary methods.
 */

//Package Declarations
package senior_project;

public class FeedbackTester 
{
	public static void main(String[] args)
	{
		//Variable declarations
		Feedback feedbackTester = new Feedback();
		
		//Set values
		System.out.println("Setting test values...");
		System.out.println("Testing setter methods...");
		documentTester.setQuestionID(1);
		documentTester.setQuestionOne(10);
		documentTester.setQuestionTwo(5);
		documentTester.setQuestionThree(7);
		documentTester.setQuestionFour(2);
		documentTester.setQuestionFive(6);
		documentTester.setComments("THIS IS A COMMENT");
		
		System.out.println("");
		
		//Test getter methods
		System.out.println("Testing getter methods...");
		System.out.println("Question ID: " + feedbackTester.getQuestionID());
		System.out.println("Question One: " + feedbackTester.getQuestionOne());
		System.out.println("Question Two: " + feedbackTester.getQuestionTwo());
		System.out.println("Question Three: " + feedbackTester.getQuestionThree());
		System.out.println("Question Four: " + feedbackTester.getQuestionFour());
		System.out.println("Question Five: " + feedbackTester.getQuestionFive());
		System.out.println("Comment: " + feedbackTester.getComments());
		
		//Test toString() method
		System.out.println("");
		System.out.println("Testing toString() method...");
		System.out.println(feedbackTester);
	}
}
