/**
 * Class: Users.java
 * Developer: Rich Hoggan
 * Creation Date: 02-12-2015
 * Description: The data class for users in the AlumniNetwork application.
 * 
 * @author richhoggan
 */

//Package Declarations
package UserClasses;

public class Users 
{
	////Data Members////
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String emailAddress;
	private int graduationYear;
	private String major;
	private String phoneNumber;
	private String city;
	private String state;
	private String description;
	private String page;
	
	////Class Constructors////
	/**
	 * Method Description: Empty constructor that sets data members to null values.
	 * 
	 */
	public Users()
	{
		this.username = "";
		this.password = "";
		this.firstName = "";
		this.lastName = "";
		this.emailAddress = "";
		this.graduationYear = 0;
		this.major = "";
		this.phoneNumber = "";
		this.city = "";
		this.state = "";
		this.description = "";
		this.page = "";
	}
	
	/**
	 * Method Description: Constructor that sets data members to user supplied input.
	 * @param username
	 * @param password
	 * @param firstName
	 * @param lastName
	 * @param emailAddress
	 * @param graduationYear
	 * @param major
	 * @param phoneNumber
	 * @param city
	 * @param state
	 * @param description
	 * @param page
	 */
	public Users(String username, String password, String firstName, 
			String lastName, String emailAddress, int graduationYear, String major,
			String phoneNumber, String city, String state, String description, 
			String page)
	{
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.graduationYear = graduationYear;
		this.major = major;
		this.phoneNumber = phoneNumber;
		this.city = city;
		this.state = state;
		this.description = description;
		this.page = page;
	}
	
	////Getters and Setters////
	/**
	 * Method Description: Sets the username data member.
	 * @param username
	 */
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	/**
	 * Method Description: Sets the password data member.
	 * @param password
	 */
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	/**
	 * Method Description: Sets the firstName data member.
	 * @param firstName
	 */
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	
	/**
	 * Method Description: Sets the lastName data member.
	 * @param lastName
	 */
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	
	/**
	 * Method Description: Sets the emailAddress data member.
	 * @param emailAddress
	 */
	public void setEmailAddress(String emailAddress)
	{
		this.emailAddress = emailAddress;
	}
	
	/**
	 * Method Description: Sets the graduationYear data member.
	 * @param graduationYear
	 */
	public void setGraduationYear(int graduationYear)
	{
		this.graduationYear = graduationYear;
	}
	
	/**
	 * Method Description: Sets the major data member.
	 * @param major
	 */
	public void setMajor(String major)
	{
		this.major = major;
	}
	
	/**
	 * Method Description: Sets the phoneNumber data member.
	 * @param phoneNumber
	 */
	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}
	
	/**
	 * Method Description: Sets the city data member.
	 * @param city
	 */
	public void setCity(String city)
	{
		this.city = city;
	}
	
	/**
	 * Method Description: Sets the state data member.
	 * @param state
	 */
	public void setState(String state)
	{
		this.state = state;
	}
	
	/**
	 * Method Description: Sets the description data member.
	 * @param description
	 */
	public void setDescription(String description)
	{
		this.description = description;
	}
	
	/**
	 * Method Description: Sets the page data member.
	 * @param page
	 */
	public void setPage(String page)
	{
		this.page = page;
	}
	
	/**
	 * Method Description: Returns a reference to the username data member.
	 * @return username
	 */
	public String getUsername()
	{
		return this.username;
	}
	
	/**
	 * Method Description: Returns a reference to the password data member.
	 * @return password
	 */
	public String getPassword()
	{
		return this.password;
	}
	
	/**
	 * Method Description: Returns a reference to the firstName data member.
	 * @return firstName
	 */
	public String getFirstName()
	{
		return this.firstName;
	}
	
	/**
	 * Method Description: Returns a reference to the lastName data member.
	 * @return lastName
	 */
	public String getLastName()
	{
		return this.lastName;
	}
	
	/**
	 * Method Description: Returns a reference to the emailAddress data member.
	 * @return emailAddress
	 */
	public String getEmailAddress()
	{
		return this.emailAddress;
	}
	
	/**
	 * Method Description: Returns a reference to the graduationYear data member.
	 * @return graduationYear
	 */
	public int getGraduationYear()
	{
		return this.graduationYear;
	}
	
	/**
	 * Method Description: Returns a reference to the major data member.
	 * @return major
	 */
	public String getMajor()
	{
		return this.major;
	}
	
	/**
	 * Method Description: Returns a reference to the phoneNumber data member.
	 * @return phoneNumber
	 */
	public String getPhoneNumber()
	{
		return this.phoneNumber;
	}
	
	/**
	 * Method Description: Returns a reference to the city data member.
	 * @return city
	 */
	public String getCity()
	{
		return this.city;
	}
	
	/**
	 * Method Description: Returns a reference to the state data member.
	 * @return state
	 */
	public String getState()
	{
		return this.state;
	}
	
	/**
	 * Method Description: Returns a reference to the description data member.
	 * @return description
	 */
	public String getDescription()
	{
		return this.description;
	}
	
	/**
	 * Method Description: Returns a reference to the page data member.
	 * @return page 
	 */
	public String getPage()
	{
		return this.page;
	}

	////Returning Methods////
	/**
	 * Method Description: Override of toString
	 * @return all data members
	 */
	public String toString()
	{
		return (this.username + "\n" + this.password + "\n"
				+ this.firstName + "\n" + this.lastName + "\n" + this.emailAddress + "\n" 
				+ this.graduationYear + "\n" + this.major + "\n" + this.phoneNumber + "\n"
				+ this.city + "\n" + this.state + "\n" + this.description + "\n" + this.page + "\n");
	}
}