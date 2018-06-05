package controller;

/**
 * <h1>The class Clock</h1>
 * @author gauthier
 * @version 1.0
 */
public class Clock {

	/**
	 * The number of tick is the number of time that the game looped
	 */
	private int ticksPerSecond = 15;
	
	/**
	 * The duration between to tick
	 * how much time the program will sleep
	 */
	private long tickDuration;
	
	/**
	 * The method Clock instantiate an object Clock
	 */
	public Clock() {
		tickDuration = 1000/ticksPerSecond;
	}
	
	/**
	 * This method instantiate an object Clock but this time with a custom ticksPerSecond 
	 * @param ticksPerSecond
	 * 			The number of ticks per second
	 */
	public Clock(int ticksPerSecond) {
		this.ticksPerSecond=ticksPerSecond;
		tickDuration = 1000/ticksPerSecond;
	}
	
	/**
	 * Sleep is a method that is used between 2 frames to pause the program
	 * @throws InterruptedException 
	 * 			InterruptedException 
	 */
	public void sleep() throws InterruptedException {
		Thread.sleep(tickDuration);
	}
}