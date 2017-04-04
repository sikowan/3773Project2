import java.util.ArrayList;

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
	private int id;
	private String password;
	private String username;
	private ArrayList<User> userList; 
	
	/**
	 * User:
	 * 		Constructor.
	 */
	public User() {

	}
	
	/**
	 * generateID:
	 * 		Randomly generates a number 10-15 digits long.
	 * 		Calls checkID method to ensure ID fits criteria.
	 */
	public void generateID() {
		
	}
	
	/**
	 * generatePW:
	 * 		Randomly generates a password with the following criteria:
	 * 			16+ chars long, at least one: digit, number, special character, uppercase letter, lowercase letter.
	 * 		Calls checkPW method to ensure pw fits criteria.
	 */
	public void generatePW() {
		
	}
	
	/**
	 * deleteUser:
	 * 		Delete user from database. 
	 * 		Should free allocated memory.
	 * @param id
	 */
	public void deleteUser(int id) {
		
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
	public boolean checkID(int id) {
		return false;
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
	public int getID() {
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
