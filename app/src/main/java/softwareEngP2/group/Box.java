package softwareEngP2.group;

/**
 *	Box: 
 *		DESCRIPTION GOES HERE~!
 * 
 * @author Team 5
 * 			Felan, Ernesto
 * 			Goins, Trenton
 * 			Mueller, Victoria
 * 			Olivares, Austin
 * 			Woodal, Jennifer
 */
public interface Box {
	

	/**
	 *  selectMessage:
	 * 		Allows for selection of message.
	 */
	void selectMessage();
	
	/**
	 * viewMessage: 
	 *  	Views selected message.
	 * @param message
	 */
	void viewMessage(Message message);

	/**
	 * deleteMessage:
	 *  	Deletes selected message.
	 * @param message
	 */
	void deleteMessage(Message message);

	/**
	 * getTotalMailNum:
	 *  	Returns total number of messages in box.
	 * @return
	 */
	int getTotalMailNum();
}
