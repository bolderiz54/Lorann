package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Collections;
import java.util.List;

public class Interact implements KeyListener{
	
	/**
	 * List of the key pressed
	 */
	private List<Integer> keyCodePressed;
	private List<Character> keyCharPressed;
	
	/**
	 * Test key pressed or not with a boolean
	 * @param keyCode
	 * @return
	 */
	public boolean isKeyPressed(int keyCode) {
		int index = Collections.binarySearch(this.getKeyCodePressed(), keyCode);
		if (index >= 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Test key pressed or not with a boolean
	 * @param keyChar
	 * @return
	 */
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
	 * if key pressed the keycode and keychar are stocked in a list
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
	
	public void keyTyped(KeyEvent event) {

	}
	
	/**
	 * list of the keycode
	 * @return
	 */
	public List<Integer> getKeyCodePressed(){
		return keyCodePressed;
	}
	
	/**
	 * list of the keychar
	 * @return
	 */
	public List<Character> getKeyCharPressed(){
		return keyCharPressed;
	}
	
}
