package view;

import static org.junit.Assert.*;

import org.junit.Test;

public class InteractTest {

	@Test
	public void testIsKeyPressedChar() {
		Interact interact = new Interact();
		assertFalse(interact.isKeyPressed('a'));
		
		
	}
/*
	@Test
	public void testKeyPressed() {
		fail("Not yet implemented");
	}

	@Test
	public void testKeyReleased() {
		fail("Not yet implemented");
	}

	@Test
	public void testKeyTyped() {
		fail("Not yet implemented");
	}
*/
}
