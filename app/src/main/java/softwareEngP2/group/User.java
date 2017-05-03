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
	private boolean acctStatus;
	private Contacts contacts;
	
	/**
	 * User:
	 * 		Constructor.
	 */
	public User(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		generateID();
		generatePW();
		setUsername();
		acctStatus = true;
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
        int numDigits, numUpper, numLower, numSpecial;
        int pwLength = 18;
        char special[] = {'!','@','#','$','%','?','&','*'};

        numLower = rand.nextInt(12);
        numUpper = 12 - numLower;
        numDigits = rand.nextInt(6);
        numSpecial = 6 - numDigits;

        while(pwLength != 0) {
            switch (rand.nextInt(4)) {
                case 0:
                    if (numLower == 0)
                        break;
                    password += (char) ('a' + (char) rand.nextInt(26));
                    numLower--;
                    pwLength--;
                    break;
                case 1:
                    if (numUpper == 0)
                        break;
                    password += (char) ('A' + (char) rand.nextInt(26));
                    numUpper--;
                    pwLength--;
                    break;
                case 2:
                    if (numDigits == 0)
                        break;
                    password += (char) ('0' + (char) rand.nextInt(10));
                    numDigits--;
                    pwLength--;
                    break;
                case 3:
                    if (numSpecial == 0)
                        break;
                    password += special[rand.nextInt(8)];
                    numSpecial--;
                    pwLength--;
                    break;
            }
        }

        // If generated password is determined to be invalid, will regenerate password
        if(!checkPW(password))
            generatePW();
    }

	/**
	 * freezeUser:
	 * 		Freezes user account.
	 *
	 */
	public void freezeUser() {
		acctStatus = false;
	}
	
	/**
	 * unfreezeUser:
	 * 		Unfreezes user account.
	 */
	public void unfreezeUser() {
		acctStatus = true;
	}
	
	/**
	 * setUsername:
	 * 		Select unique username. 
	 * 		Should be a combination of first and last name.
	 * 		Calls checkUsername method to ensure username is not currently in use.
	 */
	public void setUsername() {
		username = (firstName + " " + lastName);
	}
	
	/**
	 * changePW:
	 *      Allows admins to change password with the following constraints:
	 *          16+ chars long, at least one: digit, number, special character, uppercase letter, lowercase letter.
     * @param password pw input from admin
     * @return status true/false : password changed/password invalid
	 */
	public boolean changePW(String password) {
		if(checkPW(password)){
            this.password = password;
            return true;
        } else{
            return false;
        }
	}
	
	/**
	 * checkID:
	 * 		Checks if ID has the following criteria:
	 * 			10-15 digits long, not currently in use.
	 * 		Returns true if ID fits criteria.
	 * 		Returns false if ID does not fit criteria.
	 * @param id generated ID
	 * @return status true/false: valid/invalid
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
	 * @param password generated password
	 * @return status true/false:valid/invalid
	 */
    public boolean checkPW(String password) {
        boolean statusSpecial, status = true;
        int calcLength = 0;
        char special[] = {'!','@','#','$','%','?','&','*'};

        // Checks to see if length is valid
        if(password.length() < 16)
            status = false;

        // Checks each char to see if it's valid
        for(int i = 0; i < password.length(); i++){
            if((password.charAt(i) >= 'a') && (password.charAt(i) <= 'z')){
                calcLength++;
                continue;
            } else if ((password.charAt(i) >= 'A') && (password.charAt(i) <= 'Z')){
                calcLength++;
                continue;
            } else if ((password.charAt(i) >= '0') && (password.charAt(i) <= '9')){
                calcLength++;
                continue;
            } else{
                statusSpecial = false;
                for (char c : special) {
                    if(password.charAt(i) == c) {
                        statusSpecial = true;
                        calcLength++;
                        break;
                    }
                }
            }
            if(!statusSpecial){
                status = false;
            }
        }

        if(calcLength != password.length())
            status = false;

        return status;
    }

	/**
	 * checkUsername:
	 * 		Checks if username already exists.
	 * 			Returns true if the username is not taken and can be used.
	 * 			Returns false if the username is already taken and cannot be used.
	 * @param id generated id
	 * @return username for no errors
	 */
	public String checkUsername(String id) {
        //TODO: checkUsername()
		return username; // just returning a string for no errors
	}
	
	/**
	 * getID:
	 * 		Returns id.
	 * @return id ID of user
	 */
	public String getID() {
		return id;
	}
	
	/**
	 * getUsername:
	 * 		Returns username.
	 * @return username username of user
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * getPassword:
	 * 		Returns password.
	 * @return password password of user
	 */
	public String getPassword() {
		return password;
	}

    /**
     * getAcctStatus:
     *      Returns account status.
     * @return acctStatus status of user
     */
    public boolean getAcctStatus() {
        return acctStatus;
    }

    public String toString() {
        if (!acctStatus) {
            return getUsername() + "\nAccount Status: INACTIVE";
        } else {
            return getUsername() + "\nAccount Status: ACTIVE";
        }
    }
}
