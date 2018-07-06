package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class BeingTest {

	@Test
	public void testDie() {
		final boolean expected = false;
		final Being being = new Being("ImagePath", Permeability.BLOCKING);
		being.die();
		assertEquals(expected, being.isAlive());
	}

	@Test
	public void testAlive() {
		final boolean expected =  true;
		final Being being = new Being("ImagePath", Permeability.BLOCKING);
		assertEquals(expected, being.isAlive());
	}
	
}
