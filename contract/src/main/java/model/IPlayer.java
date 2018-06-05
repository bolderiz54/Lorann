package model;

import java.awt.Point;
import java.io.IOException;

/**
 * <h1>The interface IPlayer</h1>
 * @author Hugo
 *
 */
public interface IPlayer extends IBeing {
	
	/**
	 * Move the player at the right coordinate
	 * @param x (int)
	 * 			The x component of the movement
	 * @param y (int)
	 * 			The y component of the movement
	 * @throws IOException 
	 */
	public void move(int x, int y);
	
	/**
	 * get the direction
	 * @return Direction
	 * 			The direction of the player
	 */
	public Direction getDirection();
	
	/**
	 * set the direction
	 * @param direction
	 * 			The direction of the player
	 */
	public void setDirection(Direction direction);

	/**
	 *
     * Gets the x position.
     *
     * @return int
     * 			the x position
     */
    public int getX();

    /**
     * Gets the y position.
     *
     * @return the y
     * 			the y position
     */
    public int getY();

    /**
     * Gets the position Point(int x, int y).
     *
     * @return Point
     * 			the position
     * @see Point
     */
    public Point getPosition();

}
