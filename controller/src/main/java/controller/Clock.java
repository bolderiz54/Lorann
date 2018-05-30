package controller;

public class Clock {

	/**
	 * the number of tick is the number of time that the game looped
	 */
	private int ticksPerSecond = 15;
	private long tickDuration;
	
	/**
	 * this Clock instantiate the object Clock
	 */
	public Clock() {
		tickDuration = 1000/ticksPerSecond;
	}
	
	/**
	 *this method instantiate the object Clock but this time with a custom ticksPerSecond 
	 * @param ticksPerSecond
	 */
	public Clock(int ticksPerSecond) {
		this.ticksPerSecond=ticksPerSecond;
		tickDuration = 1000/ticksPerSecond;
	}
	
	/**
	 * Sleep is a method that is used between 2 frames
	 * @throws InterruptedException 
	 */
	public void sleep() throws InterruptedException {
		Thread.sleep(tickDuration);
	}
}
