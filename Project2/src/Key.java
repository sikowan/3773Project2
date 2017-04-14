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
	 * @param key
	 */
	public Key(String key) {
		this.key = encryptKey(key);
		
	}
	
	/**
	 * keyMatch:
	 * 		Compares entered key to actual key.
	 * 		Returns true if keys match.
	 * 		Returns false if keys do not match.
	 * @param enteredKey
	 * @return
	 */
	public boolean keyMatch(String enteredKey) {
		//encrypt given key
		enteredKey = encryptKey(enteredKey);
		
		//check if the encryptions match
		if(enteredKey.equals(this.key)){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * encryptKey()
	 * 		encrypts the given string for security
	 * @params key 
	 * @return key - encrypted key
	 * 
	 */
	private String encryptKey(String key){
		return key;//still need to add encryption
	}
	
	/**
	 * getKey:
	 * 		Returns key.
	 * @return
	 */
	public String getKey() {
		return key;
	}
}
