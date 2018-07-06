package model;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

public class SpellTest {

	@Test
	public void testMove() {
		final int expectedX = 12;
		final int expectedY = 8;
		final Spell spell = new Spell(Direction.DIR_DOWN_LEFT, new Point(11,9));
		spell.move();
		assertEquals(expectedX, spell.getPosition().x);
		assertEquals(expectedY, spell.getPosition().y);
	}

	@Test
	public void testReverse() {
		final Direction expectedDir = Direction.DIR_DOWN;
		final Spell spell = new Spell();
		spell.reverse();
		assertEquals(expectedDir, spell.getDirection());
	}

	@Test
	public void testIsRepelled() {
		final boolean expected = true;
		final Spell spell = new Spell();
		spell.reverse();
		assertEquals(expected, spell.isRepelled());
	}

	@Test
	public void testGetDirection() {
		final Direction expected = Direction.DIR_LEFT;
		final Spell spell = new Spell();
		spell.setDirection(Direction.DIR_LEFT);
		assertEquals(expected, spell.getDirection());
	}

}
