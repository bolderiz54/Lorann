package model;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

public class SpellTest {

	@Test
	public void testMove() {
		final int expectedX = 12;
		final int expectedY = 8;
		final Direction expectedDir = Direction.DIR_DOWN_LEFT;
		final Spell spell = new Spell(Direction.DIR_DOWN_LEFT, new Point(11,9));
		spell.move();
		assertEquals(expectedX, spell.getPosition().x);
		assertEquals(expectedY, spell.getPosition().y);
	}

	@Test
	public void testReverse() {
		final Direction expectedDir = Direction.DIR_RIGHT;
		final Spell spell = new Spell(Direction.DIR_LEFT, new Point(11,9));
		assertEquals(expectedDir, spell.reverse());
	}

	@Test
	public void testIsRepelled() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetDirection() {
		fail("Not yet implemented");
	}

}
