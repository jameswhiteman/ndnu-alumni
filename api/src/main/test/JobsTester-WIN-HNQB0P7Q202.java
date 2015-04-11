//More comments
//Code


//Package Declarations
package senior_project;

//Import Declarations
public class JobsTester 
{
	public static void main(String[] args)
	{
		//Variable declarations
		Jobs JobsTest = new Jobs();
		
		//Set values
		System.out.println("Setting test values...");
		System.out.println("Testing setter methods...");
		JobsTest.setJobID("00011");
		JobsTest.setUserID("00008);
		JobsTest.setJobTitle("Desktop Engineer");
		JobsTest.setCompanyName("Sun Mircosystems");
		JobsTest.setSalary("65000.00");
		JobsTest.setDescription("Install Programs on PCs");
		JobsTest.setJobType("FTE");
		JobsTest.setStartDate("2015-01-01");
		JobsTest.setEndDate("2020-01-01");
		System.out.println("");
		
		//Test getter methods
		System.out.println("Testing getter methods...");
		System.out.println("Job ID: " + JobsTest.getJobID());
		System.out.println("User ID: " + JobsTest.getUserID());
		System.out.println("Job Title: " + JobsTest.getJobTitle());
		System.out.println("Company Name: " + JobsTest.getCompanyName());
		System.out.println("Salary: " + JobsTest.getSalary());
		System.out.println("Description: " + JobsTest.getDescription());
		System.out.println("Job Type: " +  JobsTest.getJobType());
		System.out.println("Start Date: " + JobsTest.getStartDate());
		System.out.println("End Date: " + JobsTest.getEndDate());
		
		
		//Test toString() method
		System.out.println("");
		System.out.println("Testing toString() method...");
		System.out.println(JobsTest);
	}
}