package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

public class Interact implements KeyListener{
	
	private List<Integer> keyCodePressed;
	private List<Character> keyCharPressed;
	
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
	
	public List<Integer> getKeyCodePressed(){
		return keyCodePressed;
	}
	
	public List<Character> getKeyCharPressed(){
		return keyCharPressed;
	}
	
}
