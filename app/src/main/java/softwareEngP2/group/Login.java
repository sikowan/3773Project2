package softwareEngP2.group;

/**
 *	Login: 
 *		DESCRIPTION GOES HERE~!
 * 
 * @author Team 5
 * 			Felan, Ernesto
 * 			Goins, Trenton
 * 			Mueller, Victoria
 * 			Olivares, Austin
 * 			Woodal, Jennifer
 */
public class Login {
	
	private User user; 
	private int id;
	private String password;
	private String enteredPassword;
	private int numTimesWrong;

	/**
	 * Login:
	 * 		Constructor.
	 */
	public Login() {



		// if login is first, prompt selectPassword.
	}
	
	/**
	 * enterPassword:
	 * 		Allows user to enter password.
	 * 		Should call upon checkPassword method of User class to ensure password fits criteria.
	 */
	public void enterPassword() {
		
	}
	
	/**
	 * verifyPassword:
	 * 		Checks entered password with actual password.
	 * 		Returns true if passwords match.
	 * 		Returns false if passwords do not match.
	 * @param password
	 * @param enteredPassword
	 * @return
	 */
	public boolean verifyPassword(String password, String enteredPassword) {
		if (password.equals(enteredPassword)) {
			return true;
		} else {
			numTimesWrong++;
			incorrectPassword(numTimesWrong);
		}
		return false;
	}
	
	/**
	 * firstTime:
	 * 		Checks if this is the first time id has been logged into.
	 * 		Returns true if it is first time.
	 * 		Returns false if it is not first time.
	 * @param id
	 * @return
	 */
	public boolean firstTime(int id) {
		// if this is the first time logging in, return true;
		// else
		return false;
	}
	
	/**
	 * selectPassword:
	 * 		If firstTime returns true, allows user to change password with the following criteria:
	 * 			16+ chars long, at least one: digit, number, special character, uppercase letter, lowercase letter.
	 */
	public void selectPassword() {
		// need to verify selected password follows letter/num/symbol/case/length rules.
	}
	
	/**
	 * incorrectPassword:
	 * 		Counts the amount of times the password is wrong.
	 * 		After three attempts, alerts admin and freezes account.
	 * @param numTimesWrong
	 */
	public void incorrectPassword(int numTimesWrong) {
		if (numTimesWrong < 3) {
			System.out.println("You have entered the wrong password " + numTimesWrong + " times.\n" +
					"Please be aware that accounts are locked after three incorrect attempts. " +
					"To have your password reset, please contact your system administrator.");
		}
		if (numTimesWrong >= 3) {
			// lock account, message to admin.
			System.out.println("Your account has been locked due to 3 unsuccessful login attempts.");
		}
	}

}
