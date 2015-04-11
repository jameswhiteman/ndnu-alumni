/**
 * Class: DocumentTester.java
 * Developer: Rich Hoggan
 * Creation Date: 02-22-2015
 * Description: This class tests the Document class and all necessary methods.
 */

//Package Declarations
package senior_project;

public class DocumentTester 
{
	public static void main(String[] args)
	{
		//Variable declarations
		Document documentTester = new Document();
		
		//Set values
		System.out.println("Setting test values...");
		System.out.println("Testing setter methods...");
		documentTester.setDocumentID(1);
		documentTester.setProjectID(10);
		documentTester.setDocumentName("TesterDocument.pdf");
		documentTester.setDocumentType("PDF");
		documentTester.setDocumentLocation("../WebAppContent/Documents/TesterDocument/");
		
		System.out.println("");
		
		//Test getter methods
		System.out.println("Testing getter methods...");
		System.out.println("Document ID: " + documentTester.getDocumentID());
		System.out.println("Project ID: " + documentTester.getProjectID());
		System.out.println("Document Name: " + documentTester.getDocumentName());
		System.out.println("Document Type: " + documentTester.getDocumentType());
		System.out.println("Document Location: " + documentTester.getDocumentLocation());
		
		//Test toString() method
		System.out.println("");
		System.out.println("Testing toString() method...");
		System.out.println(documentTester);
	}
}
