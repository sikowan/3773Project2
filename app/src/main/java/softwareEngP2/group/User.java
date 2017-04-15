package softwareEngP2.group;

import java.util.ArrayList;
import java.util.Random;

/**
 *	User: 
 *		DESCRIPTION GOES HERE~!
 * 
 * @author Team 5
 * 			Felan, Ernesto
 * 			Goins, Trenton
 * 			Mueller, Victoria
 * 			Olivares, Austin
 * 			Woodal, Jennifer
 */
public class User {

	private String lastName;
	private String firstName;
	private String id;
	private String password;
	private String username;
	private ArrayList<User> userList; 
	
	/**
	 * User:
	 * 		Constructor.
	 */
	public User(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		generateID();
		generatePW();
	}
	
	/**
	 * generateID:
	 * 		Randomly generates a number 10-15 digits long.
	 * 		Calls checkID method to ensure ID fits criteria.
	 */
	public void generateID() {
		Random rand = new Random();
		id = "";		
		int numDigits = rand.nextInt(6) + 10;
		
		for(int i = 0; i < numDigits; i++){
			id += (char) ((char)rand.nextInt(10) + '0');
		}
		
		// If generated ID is determined to be invalid, will regenerate ID
		if(!checkID(id))
			generateID();
	}
	
	/**
	 * generatePW:
	 * 		Randomly generates a password with the following criteria:
	 * 			16+ chars long, at least one: digit, special character, uppercase letter, lowercase letter.
	 * 		Calls checkPW method to ensure pw fits criteria.
	 */
	public void generatePW() {
		Random rand = new Random();
		password = "";
		int pwLength = rand.nextInt(6) + 16;
		/*
		char chars[] = {'0','1','2','3','4','5','6','7','8','9',
				'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
				'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z',
				'!','@','#','$','%','^','&','*'
		};*/
		int numDigits;
		int numUpper;
		int numLower;
		int numChars;
		
		
	}
	
	/**
	 * deleteUser:
	 * 		Delete user from database. 
	 * 		Should free allocated memory.
	 * @param id
	 */
	public void deleteUser(int id) {
		userList.remove(this); 
	}
	
	/**
	 * freezeUser:
	 * 		Freezes user account.
	 * @param id
	 */
	public void freezeUser(int id) {
		
	}
	
	/**
	 * unfreezeUser:
	 * 		Unfreezes user account.
	 * @param id
	 */
	public void unfreezeUser(int id) {
		
	}
	
	/**
	 * setUsername:
	 * 		Select unique username. 
	 * 		Should be a combination of first and last name.
	 * 		Calls checkUsername method to ensure username is not currently in use.
	 */
	public void setUsername() {
		
	}
	
	/**
	 * changePW:
	 * 		Allows admins to change password with the following constraints:
	 * 			16+ chars long, at least one: digit, number, special character, uppercase letter, lowercase letter.
	 */
	public void changePW() {
		
	}
	
	/**
	 * checkID:
	 * 		Checks if ID has the following criteria:
	 * 			10-15 digits long, not currently in use.
	 * 		Returns true if ID fits criteria.
	 * 		Returns false if ID does not fit criteria.
	 * @param id
	 * @return
	 */
	public boolean checkID(String id) {
		boolean status = true;
		
		// Checks to see if length is valid
		if((id.length() < 10) || (id.length() > 15))
			status = false;
		
		// Checks to see if characters are integers
		for(int i = 0; i < id.length(); i++)
		{
			if((id.charAt(i) < '0') || (id.charAt(i) > '9'))
				status = false;
		}
		
		// Checks other users to see if ID matches any other existing ID
		
		/**
		 * Commented out temporarily, causes error now since userList is empty
		 *
		for(User temp : userList)
		{
			if(temp.getID().equals(id))
				status = false;
		}
		 */
		return status;
	}
	
	/**
	 * checkPW:
	 * 		Checks if password has the following criteria:
	 * 			16+ chars long, at least one: digit, number, special character, uppercase letter, lowercase letter.
	 * 		Returns true if password fits criteria.
	 * 		Returns false if password does not fit criteria.
	 * @param password
	 * @return
	 */
	public boolean checkPW(String password) {
		return false;
	}
	
	/**
	 * checkUsername:
	 * 		Checks if username already exists.
	 * 			Returns true if the username is not taken and can be used.
	 * 			Returns false if the username is already taken and cannot be used.
	 * @param id
	 * @return
	 */
	public String checkUsername(int id) {
		return username; // just returning a string for no errors
	}
	
	/**
	 * displayUserList:
	 * 		Prints list of users. 
	 */
	public void displayUserList() {
		// should we display account status as well?
	}
	
	/**
	 * getID:
	 * 		Returns id.
	 * @return
	 */
	public String getID() {
		return id;
	}
	
	/**
	 * getUsername:
	 * 		Returns username.
	 * @return
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * getPassword:
	 * 		Returns password.
	 * @return
	 */
	public String getPassword() {
		return password;
	}

}
