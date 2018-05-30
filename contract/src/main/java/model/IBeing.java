package model;

import showboard.IPawn;

/**
 * <h1>The Interface IBeing.</h1>
 * 
 * @author Hugo
 * @version 1.0
 */

public interface IBeing extends IPawn {
	
	/**
	 * The method isAlive is a boolean to know if the entity is alive
	 * @return true or false
	 */
	public boolean isAlive();
	/**
	 * The method die is to kill the entity
	 */
	public void die();
	
	/**
	 * The method reserruct is to make entity come back to life
	 */
	public void reserruct();

}
