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

	private ArrayList<User> userList;

	/**
	 * Contacts:
	 * 		Constructor.
	 */
	public Contacts() {
		userList = new ArrayList<User>();
	}
	
	/**
	 * addContact:
	 * 		Adds user to contact list.
	 * @param user user to be added to contact list
	 */
	public void addContact(User user) {
		userList.add(user);
	}
	
	/**
	 * deleteContact:
	 * 		Deletes user from contact list.
	 * @param user user to be deleted from contact list
	 */
	public void deleteContact(User user) {
		userList.remove(user);
	}

	/**
	 * viewContact:
	 * 		Lists basic contact info.
	 */
	public void viewContact(User user) {
		user.toString();
	}

	/**
	 * listContacts:
	 * 		Lists contacts on list.
	 * @return String list of contacts
	 */
	public String listContacts() {
		return userList.toString();
	}

	/**
	 * getContacts:
	 * 		Returns contact list.
	 * @return userList list of contacts
	 */
	public ArrayList<User> getContacts() {
		return userList;
	}
}
