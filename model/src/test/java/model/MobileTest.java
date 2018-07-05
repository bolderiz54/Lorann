package model;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

public class MobileTest {

	@Test
	public void testGetX() {
		final int expected = 1;
		final Mobile mobile = new Mobile("test", Permeability.BLOCKING);
		mobile.setX(expected);
		assertEquals(expected, mobile.getX()); 
	}

	@Test
	public void testGetY() {
		final int expected = 12;
		final Mobile mobile = new Mobile("test", Permeability.BLOCKING);
		mobile.setY(expected);
		assertEquals(expected, mobile.getY()); 
	}

	@Test
	public void testGetPosition() {
		final int expectedX = 7;
		final int expectedY = 5;
		final Mobile mobile = new Mobile("test", Permeability.BLOCKING);
		mobile.setPosition(new Point(expectedX, expectedY));
		assertEquals(expectedX, mobile.getPosition().x);
		assertEquals(expectedY, mobile.getPosition().y); 
	}

}
