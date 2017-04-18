package softwareEngP2.group;

import java.util.ArrayList;

/**
 *	Contacts: 
 *		Allows for contacts to be added, deleted, and viewed.
 * 
 * @author Team 5
 * 			Felan, Ernesto
 * 			Goins, Trenton
 * 			Mueller, Victoria
 * 			Olivares, Austin
 * 			Woodal, Jennifer
 */
public class Contacts {
	
	private User user;
	private ArrayList<User> userList;

	/**
	 * Contacts:
	 * 		Constructor.
	 */
	public Contacts() {
		// ?
	}
	
	/**
	 * addContact:
	 * 		Adds user to contact list.
	 * @param user
	 */
	public void addContact(User user) {
		userList.add(user);
	}
	
	/**
	 * deleteContact:
	 * 		Deletes user from contact list.
	 * @param user
	 */
	public void deleteContact(User user) {
		userList.remove(user);
	}

	/**
	 * listContacts:
	 * 		Lists contacts on list.
	 * @return
	 */
	public String listContacts() {
		return userList.toString();
	}

	/**
	 * getContacts:
	 * 		Returns contact list.
	 * @return
	 */
	public ArrayList<User> getContacts() {
		return userList;
	}
}
