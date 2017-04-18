package softwareEngP2.group;

import java.util.ArrayList;

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
public class Box {
	
	private ArrayList<Message> messages;
	private int total;
	
	/**
	 * Box:
	 * 		Constructor.
	 */
	public Box() {
        messages = new ArrayList<Message>();
		total = 0;
	}

	/**
	 *  selectMessage:
	 * 		Allows for selection of message.
	 */
	public void selectMessage() {
		//TODO: selectMessage()
	}

	/**
	 * viewMessage:
	 *  	Views selected message.
	 * @param message message to be viewed
	 */
	public void viewMessage(Message message) {
		//TODO: viewMessage()
	}

	/**
	 * deleteMessage:
	 *  	Deletes selected message.
	 * @param message message to be deleted
	 */
	public void deleteMessage(Message message) {
		// check if message exists in messages. if it does, delete.
		messages.remove(message);
        total--;
		// if it doesn't, error handling?
	}

    /**
     * addMessage:
     *  	add given message.
     * @param message message to be added
     */
    public void addMessage(Message message){
        messages.add(message);
        total++;
    }

	/**
	 * getTotalMailNum:
	 *  	Returns total number of messages in box.
	 * @return total total number of messages in the box
	 */
	public int getTotal() {
		return total;
	}

}
