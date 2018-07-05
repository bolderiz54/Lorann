package model;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

public class PlayerTest {

	@Test
	public void testMove() {
		final int expectedX = 7;
		final int expectedY = 5;
		final Direction expectedDir = Direction.DIR_UP_RIGHT;
		final Player player = new Player();
		player.setPosition(new Point(6, 6));
		player.move(1, -1);
		assertEquals(expectedX, player.getPosition().x);
		assertEquals(expectedY, player.getPosition().y);
		assertEquals(expectedDir, player.getDirection());
	}

	@Test
	public void testGetDirection() {
		final Direction expected = Direction.DIR_LEFT;
		final Player player = new Player();
		player.setDirection(Direction.DIR_LEFT);
		assertEquals(expected, player.getDirection());
	}

}
