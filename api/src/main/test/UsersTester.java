//More comments
//Code


//Package Declarations
package senior_project;

//Import Declarations
public class UsersTester 
{
	public static void main(String[] args)
	{
		//Variable declarations
		Users usersTest = new Users();
		
		//Set values
		System.out.println("Setting test values...");
		System.out.println("Testing setter methods...");
		usersTest.setUsername("richhoggan");
		usersTest.setPassword("thisisapassword");
		usersTest.setFirstName("Rich");
		usersTest.setLastName("Hoggan");
		usersTest.setEmailAddress("rhoggan@student.ndnu.edu");
		usersTest.setGraduationYear(2015);
		usersTest.setMajor("Computer Science");
		usersTest.setPhoneNumber("650-464-7134");
		usersTest.setCity("San Mateo");
		usersTest.setState("CA");
		usersTest.setDescription("This is a description...");
		usersTest.setPage("http://www.richhoggan.com");
		System.out.println("");
		
		//Test getter methods
		System.out.println("Testing getter methods...");
		System.out.println("Username: " + usersTest.getUsername());
		System.out.println("Password: " + usersTest.getPassword());
		System.out.println("First Name: " + usersTest.getFirstName());
		System.out.println("Last Name: " + usersTest.getLastName());
		System.out.println("Email Address: " + usersTest.getEmailAddress());
		System.out.println("Graduation Year: " + usersTest.getGraduationYear());
		System.out.println("Major: " +  usersTest.getMajor());
		System.out.println("Phone Number: " + usersTest.getPhoneNumber());
		System.out.println("City: " + usersTest.getCity());
		System.out.println("State: " + usersTest.getState());
		System.out.println("Description: " + usersTest.getDescription());
		System.out.println("Page: " + usersTest.getPage());
		
		//Test toString() method
		System.out.println("");
		System.out.println("Testing toString() method...");
		System.out.println(usersTest);
	}
}