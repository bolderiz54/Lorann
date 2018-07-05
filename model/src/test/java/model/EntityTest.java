package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class EntityTest {

	@Test
	public void testGetPermeability() {
		final Permeability expected = Permeability.BLOCKING;
		final Entity entity = new Entity("../sprite/lorann_u.png", Permeability.BLOCKING);
		assertEquals(expected, entity.getPermeability());
	}
}
