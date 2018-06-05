package model;

/**
 * <h1>The Interface IBeing.</h1>
 * 
 * @author Hugo
 * @version 1.0
 */

public interface IBeing extends IMobile {
	
	/**
	 * The method isAlive is a boolean to know if the entity is alive
	 * @return boolean
	 * 			true or false
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
