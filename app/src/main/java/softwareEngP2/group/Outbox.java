package softwareEngP2.group;

import java.util.ArrayList;

/**
 *	Outbox: 
 *		DESCRIPTION GOES HERE~!
 * 
 * @author Team 5
 * 			Felan, Ernesto
 * 			Goins, Trenton
 * 			Mueller, Victoria
 * 			Olivares, Austin
 * 			Woodal, Jennifer
 */
public class Outbox implements Box {

	private ArrayList<Message> messages;
	private int total;
	
	/**
	 * Outbox:
	 * 		Constructor.
	 */
	public Outbox() {
		
	}

	/**
	 *  selectMessage:
	 * 		Allows for selection of message.
	 */
	public void selectMessage() {
		
	}

	/**
	 * viewMessage: 
	 *  	Views selected message.
	 * @param message
	 */
	public void viewMessage(Message message) {
		
	}

	/**
	 * getTotalMailNum:
	 *  	Returns total number of messages in box.
	 * @return
	 */
	public int getTotalMailNum() {
		return total;
	}

}