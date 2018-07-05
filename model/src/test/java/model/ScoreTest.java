package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class ScoreTest {

	@Test
	public void testGetScore() {
		final int expected = 1000;
		final Score score = new Score();
		score.setScore(1000);
		assertEquals(expected, score.getScore()); 
	}

	@Test
	public void testAddScore() {
		final int expected = 1000;
		final Score score = new Score();
		score.setScore(0);
		score.addScore(1000);
		assertEquals(expected, score.getScore()); 
	}

}
