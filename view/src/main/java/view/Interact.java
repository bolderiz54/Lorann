package view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <h1>The class Interact</h1>
 * This class allows to interact with the player
 * We're creating the lists that will receive the keychar and keycode of the key pressed
 * @author Gauthier
 * @version 1.0
 */
public class Interact implements KeyListener, IInteract{
	
	private List<Integer> keyCodePressed;
	private List<Character> keyCharPressed;
	
	public Interact() {
		this.keyCodePressed = new ArrayList<Integer>();
		this.keyCharPressed = new ArrayList<Character>();
	}

	public boolean isKeyPressed(int keyCode) {
		int index = Collections.binarySearch(this.getKeyCodePressed(), keyCode);
		if (index >= 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isKeyPressed(char keyChar) {
		int index = Collections.binarySearch(this.getKeyCharPressed(), keyChar);
		if (index >= 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * if a key is pressed the keycode and keychar are stocked in a list
	 * @param event
	 * 			The event from the keyboard
	 */
	public void keyPressed(KeyEvent event) {
		int index = Collections.binarySearch(this.getKeyCodePressed(), event.getKeyCode());
		if (index < 0) {
			this.getKeyCodePressed().add(event.getKeyCode());
			Collections.sort(this.getKeyCodePressed());
		}
		index = Collections.binarySearch(this.getKeyCharPressed(), event.getKeyChar());
		if (index < 0) {
			this.getKeyCharPressed().add(event.getKeyChar());
			Collections.sort(this.getKeyCharPressed());
		}
	}
	
	/**
	 * when the key is released we remove the keycode and the keychar from the list
	 * @param event
	 * 			The event from the keyboard
	 */
	public void keyReleased(KeyEvent event) {
		int index = Collections.binarySearch(this.getKeyCodePressed(), event.getKeyCode());
		if (index >= 0) {
			this.getKeyCodePressed().remove(index);
		}
		index = Collections.binarySearch(this.getKeyCharPressed(), event.getKeyChar());
		if (index >= 0) {
			this.getKeyCharPressed().remove(index);
		}
	}
	
	/**
	 * when a key is pressed and released in the same tick
	 * @param event
	 * 			The event from the keyboard
	 */
	public void keyTyped(KeyEvent event) {
	}
	
	public List<Integer> getKeyCodePressed(){
		return keyCodePressed;
	}
	
	public List<Character> getKeyCharPressed(){
		return keyCharPressed;
	}
	
}
