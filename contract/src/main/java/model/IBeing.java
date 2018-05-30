package model;

import java.awt.Point;

/**
 * <h1>The Interface IBeing.</h1>
 * 
 * @author Hugo
 * @version 1.0
 */

public interface IBeing {
	
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
	
	/**
     * Gets the x position.
     *
     * @return the x
     */
    int getX();

    /**
     * Gets the y position.
     *
     * @return the y
     */
    int getY();

    /**
     * Gets the position Point(int x, int y).
     *
     * @return the position
     * @see Point
     */
    Point getPosition();

}
