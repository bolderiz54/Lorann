package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class FactoryTest {

	@Test
	public void testGetEntity() {
		final EntityType expected = EntityType.ENT_BONE;
		final Factory factory = new Factory();
		assertEquals(expected, factory.getEntity(EntityType.ENT_BONE));
	}

	@Test
	public void testGetMonster() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPlayer() {
	}

	@Test
	public void testIsSpellExist() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSpell() {
		fail("Not yet implemented");
	}

}
