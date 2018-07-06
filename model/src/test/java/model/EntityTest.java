package model;

import static org.junit.Assert.*;

import java.awt.Image;

import org.junit.Test;

public class EntityTest {
	
	@Test
	public void testGetImageANDGetSprite() {
		final String expected = "../sprite/lorann_u.png";
		final Entity entity = new Entity("../sprite/lorann_u.png", Permeability.BLOCKING);
		assertEquals(expected, entity.getSprite().getImagePath());
	}
	
	@Test
	public void testGetPermeability() {
		final Permeability expected = Permeability.BLOCKING;
		final Entity entity = new Entity("../sprite/lorann_u.png", Permeability.BLOCKING);
		assertEquals(expected, entity.getPermeability());
	}
}
