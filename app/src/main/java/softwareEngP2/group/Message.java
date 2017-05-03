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

	private long timeout; //TODO: incorporate timer.
	private String message;
	private String username;
	private boolean read;//false = unread, true = read
	private InboxActivity inbox;

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

	// Counts down, exits loop when time complete
	public void timeoutMessage() throws InterruptedException {
		timeout = timeout * 60 * 1000;
		while(timeout != 0)
		{
			Thread.sleep(1000);
			timeout = timeout - 1000;
		}
	}

	public String getUsername(){
		return username;

	}
	public String getMessage(){
		return message;

	}
	public long getTimeout(){
		return timeout;
	}


}
