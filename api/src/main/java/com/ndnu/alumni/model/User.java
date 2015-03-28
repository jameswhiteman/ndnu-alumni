/**
 * Class: Users.java
 * Developer: Rich Hoggan
 * Creation Date: 02-12-2015
 * Description: The data class for users in the AlumniNetwork application.
 *
 * @author richhoggan
 */

//Package Declarations
package com.ndnu.alumni.model;

public class User
{
    public static enum Major
    {
        CS,ART,HST,REL,BUS,COMM
    }

	// Data Members
	private String id;
	private String firstName;
	private String lastName;
	private String email;
	private int year;
	private Major major;
	private String phone;
	private String city;
	private String state;
	private String description;
	private String page;

	////Class Constructors////
	/**
	 * Method Description: Empty constructor that sets data members to null values.
	 *
	 */
	public User()
	{
		this.id = "";
		this.firstName = "";
		this.lastName = "";
		this.email = "";
		this.year = 0;
		this.major = Major.CS;
		this.phone = "";
		this.city = "";
		this.state = "";
		this.description = "";
		this.page = "";
	}

	/**
	 * Method Description: Constructor that sets data members to user supplied input.
	 * @param id
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
    public User(String id, String firstName, String lastName, int year, Major major,
            String phone, String email, String city, String state,
            String description, String page)
	{
        this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.year = year;
		this.major = major;
		this.phone = phone;
		this.city = city;
		this.state = state;
		this.description = description;
		this.page = page;
	}

    // Convenience
    public static Major getMajorForString(String value)
    {
        if (value.equals("Software Engineering") ||
                value.equals("Management Information Systems") ||
                value.equals("cs"))
        {
            return Major.CS;
        }
        return Major.CS;
    }

	////Getters and Setters////
	/**
	 * Method Description: Sets the username data member.
	 * @param username
	 */
	public void setId(String id)
	{
		this.id = id;
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
	 * @param email
	 */
	public void setEmail(String email)
	{
		this.email = email;
	}

	/**
	 * Method Description: Sets the graduationYear data member.
	 * @param year
	 */
	public void setYear(int year)
	{
		this.year = year;
	}

	/**
	 * Method Description: Sets the major data member.
	 * @param major
	 */
	public void setMajor(Major major)
	{
		this.major = major;
	}

	/**
	 * Method Description: Sets the phoneNumber data member.
	 * @param phone
	 */
	public void setPhone(String phone)
	{
		this.phone = phone;
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
	 * @return id
	 */
	public String getId()
	{
		return this.id;
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
	 * @return email
	 */
	public String getEmail()
	{
		return this.email;
	}

	/**
	 * Method Description: Returns a reference to the graduationYear data member.
	 * @return year
	 */
	public int getYear()
	{
		return this.year;
	}

	/**
	 * Method Description: Returns a reference to the major data member.
	 * @return major
	 */
	public Major getMajor()
	{
		return this.major;
	}

	/**
	 * Method Description: Returns a reference to the phoneNumber data member.
	 * @return phoneNumber
	 */
	public String getPhone()
	{
		return this.phone;
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
		return (this.id + "\n" + this.firstName + "\n" + this.lastName + "\n" + this.email + "\n"
				+ this.year + "\n" + this.major + "\n" + this.phone + "\n"
				+ this.city + "\n" + this.state + "\n" + this.description + "\n" + this.page + "\n");
	}
}
