package softwareEngP2.group;

import java.util.Timer;

/**
 * 
 *	Message: 
 *		DESCRIPTION GOES HERE~!
 * 
 * @author Team 5
 * 			Felan, Ernesto
 * 			Goins, Trenton
 * 			Mueller, Victoria
 * 			Olivares, Austin
 * 			Woodal, Jennifer
 */
public class Message {

	private int timeout; //TODO: incorporate timer.
	private String message;
	private String username;
	private boolean read;//false = unread, true = read

	
	/**
	 * Message:
	 * 		Constructor.
	 */
	public Message(String user, String message, int timeout) {
		this.username = user;
		this.message = message;
        this.timeout= timeout;
		read=false;
		
	}

	public String getUsername(){
		return username;

	}
	public String getMessage(){
		return message;

	}
	public int getTimeout(){
		return timeout;

	}


}
