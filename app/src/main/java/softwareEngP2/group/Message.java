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

	private Timer timer; //TODO: incorporate timer.
	private String message;
	private String username;
	private boolean read;//false = unread, true = read
	private Key key;
	
	/**
	 * Message:
	 * 		Constructor.
	 */
	public Message(String message, Key key) {
		this.message = message;
		this.key = key;
		read = false;
		
	}
	
	/**
	 * toString:
	 * 		Views message sent to user.
	 * 		Should ask for key first, key should be confirmed before viewing is allowed.
	 * @param key receiver entered key
	 */
	public String toString(Key key) {
		if(this.key.keyMatch(key.getKey())){ //if keys match
			return message;
		}else{
            //TODO: throw exception for unmatched keys?
            return "";
        }
	}

}
