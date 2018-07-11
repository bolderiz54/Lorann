package view;

import static org.junit.Assert.*;

import org.junit.Test;

public class InteractTest {

	@Test
	public void testIsKeyPressedChar() {
		Interact interact = new Interact();
		assertFalse(interact.isKeyPressed('a'));
	}
	
	@Test
	public void testIsKeyPressedCode() {
		Interact interact = new Interact();
		assertFalse(interact.isKeyPressed(1));
	}
}
