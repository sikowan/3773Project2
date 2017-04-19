package softwareEngP2.group;

/**
 *	Key: 
 *		DESCRIPTION GOES HERE~!
 * 
 * @author Team 5
 * 			Felan, Ernesto
 * 			Goins, Trenton
 * 			Mueller, Victoria
 * 			Olivares, Austin
 * 			Woodal, Jennifer
 */
public class Key {

	private String key;
	private boolean success;
	
	/**
	 * Key: 
	 * 		Constructor.
	 * @param key sender entered key
	 */
	public Key(String key) {
		this.key = encryptKey(key);
		
	}
	
	/**
	 * keyMatch:
	 * 		Compares entered key to actual key.
	 * 		Returns true if keys match.
	 * 		Returns false if keys do not match.
	 * @param enteredKey receiver entered key
	 * @return true/false if they match/dont match
	 */

	public boolean keyMatch(String enteredKey) {
		//encrypt given key
		enteredKey = encryptKey(enteredKey);
		
		// check if the encryption matches
		if(enteredKey.equals(this.key)){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * encryptKey()
	 * 		encrypts the given string for security
	 * @param key unencrypted key
	 * @return key encrypted key
	 * 
	 */
	private String encryptKey(String key){
		return key;//TODO: add key encryption
	}
	
	/**
	 * getKey:
	 * 		Returns key.
	 * @return key encrypted key
	 */
	public String getKey() {
		return key;
	}
}
