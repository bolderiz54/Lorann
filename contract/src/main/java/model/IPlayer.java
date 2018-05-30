package model;

import java.awt.Point;

/**
 * The interface IPlayer
 * @author Hugo
 *
 */
public interface IPlayer extends IBeing {
	
	/**
	 * Move the player at the right coordinate
	 * @param x (int)
	 * @param y (int)
	 */
	public void move(int x, int y);
	
	/**
	 * get the direction
	 * @return
	 */
	public Direction getDirection();
	
	/**
	 * set the direction
	 * @param direction
	 */
	public void setDirection(Direction direction);

	/**
	 *
     * Gets the x position.
     *
     * @return the x
     */
    public int getX();

    /**
     * Gets the y position.
     *
     * @return the y
     */
    public int getY();

    /**
     * Gets the position Point(int x, int y).
     *
     * @return the position
     * @see Point
     */
    public Point getPosition();

}
