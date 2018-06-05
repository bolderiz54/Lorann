package model;

import java.awt.Point;

/**
 * <h1>The interface ISpell</h1>
 * @author Hugo
 *
 */
public interface ISpell {
	
	/**
	 * this method allow the movement
	 */
	public void move();
	
	/**
	 * this method reverse the direction of the spell
	 */
	public void reverse();
	
	/**
	 * this method show if the spell was called by the player
	 * @return boolean
	 * 			True if the spell has been repelled
	 */
	public boolean isRepelled();
	
	/**
     * Gets the x position.
     *
     * @return int
     * 			The x position
     */
    int getX();

    /**
     * Gets the y position.
     *
     * @return int
     * 			The y position
     */
    int getY();

    /**
     * Gets the position Point(int x, int y).
     *
     * @return Point
     * 			The position
     * @see Point
     */
    Point getPosition();
	
    /**
     * It set the direction of the spell
     * @param direction
     * 			The direction of the spell
     */
    void setDirection(Direction direction);
    
    /**
     * It return the direction of the spell
     * @return Direction
     * 			The direction of the spell
     */
    Direction getDirection();
    
}
