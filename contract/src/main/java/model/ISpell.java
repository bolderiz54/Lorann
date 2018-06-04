package model;

import java.awt.Point;

/**
 * The interface ISpell
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
	 */
	public boolean isRepelled();
	
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
	
    /**
     * It sets the direction of the spell
     * @param direction
     */
    void setDirection(Direction direction);
    
    /**
     * It return the direction of the spell
     * @return Direction
     */
    Direction getDirection();
    
}
