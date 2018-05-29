package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

public class Interact implements KeyListener{
	
	private List<Integer> keyCodePressed;
	private List<Character> keyCharPressed;
	
	public boolean isKeyPressed(int keyCode) {
		return false;
	}
	
	public boolean isKeyPressed(char keyChar) {
		return false;
	}
	
	public void keyPressed(KeyEvent event) {
		
	}
	
	public void keyReleased(KeyEvent event) {
		
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
