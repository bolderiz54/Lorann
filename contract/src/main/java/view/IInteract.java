package view;

import java.util.List;

/**
 * <h1>The interface IInteract</h1>
 * It describe how to interact with the player
 * 
 * @author Gauthier
 * @version 1.0
 */
public interface IInteract {

	/**
	 * Test if key is pressed or not with a boolean
	 * @param keyCode
	 * 			The code of the key to test
	 * @return boolean
	 * 			True if the key is pressed
	 */
	public boolean isKeyPressed(int keyCode);
	
	/**
	 * Test if key is pressed or not with a boolean
	 * @param keyChar
	 * 			The character of the key to test
	 * @return boolean
	 * 			True if the key is pressed
	 */
	public boolean isKeyPressed(char keyChar);
	
	/**
	 * get the list of the keycode
	 * @return List<Integer>
	 * 			The list of all the key pressed
	 * @see List
	 */
	public List<Integer> getKeyCodePressed();
	
	/**
	 * get the list of the keychar
	 * @return List<Character>
	 * 			The list of all the key pressed
	 * @see List
	 */
	public List<Character> getKeyCharPressed();
	
}
