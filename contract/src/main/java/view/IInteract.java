package view;

import java.util.List;

/**
 * It describe how to interact with the player
 * 
 * @author Gauthier
 * @version 1.0
 */
public interface IInteract {

	/**
	 * Test key pressed or not with a boolean
	 * @param keyCode
	 * @return
	 */
	public boolean isKeyPressed(int keyCode);
	
	/**
	 * Test key pressed or not with a boolean
	 * @param keyChar
	 * @return
	 */
	public boolean isKeyPressed(char keyChar);
	
	/**
	 * list of the keycode
	 * @return
	 */
	public List<Integer> getKeyCodePressed();
	
	/**
	 * list of the keychar
	 * @return
	 */
	public List<Character> getKeyCharPressed();
	
}
