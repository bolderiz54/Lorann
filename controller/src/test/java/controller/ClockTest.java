package controller;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class ClockTest {

	private static Clock clock;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		clock = new Clock(10);
	}

	@Test
	public void test() {
		long start = System.currentTimeMillis();
		try {
			clock.sleep();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long finish = System.currentTimeMillis();
		assertTrue(finish >= start + 1000/10);
	}

}
