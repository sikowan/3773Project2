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

	private Timer timer;
	private String message;
	private String username;
	private boolean read;//false = unread, true = read
	private Key key;
	
	/**
	 * Message:
	 * 		Constructor.
	 */
	public Message(String message) {
		this.message = message;
		read = false;
		
	}
	
	/**
	 * send:
	 * 		Sends message with selected key.
	 * @param message
	 * @param key
	 */
	public void send(Message message, Key key) {
		
	}
	
	/**
	 * receive:
	 * 		Receives messages sent to user.
	 * @param message
	 */
	public void receive(Message message) {
		
	}
	
	/**
	 * view:
	 * 		Views message sent to user.
	 * 		Should ask for key first, key should be confirmed before viewing is allowed.
	 * @param message
	 * @param key
	 */
	public void view(Message message, Key key) {
		
	}
	
	/**
	 * delete:
	 * 		Deletes selected message.
	 * @param message
	 */
	public void delete(Message message) {
		
	}
}
