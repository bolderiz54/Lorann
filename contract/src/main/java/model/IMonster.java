package model;

import java.awt.Point;

import showboard.IPawn;

/**
 * <h1>The Interface IMonster.</h1>
 *  
 * @author Hugo
 * @version 1.0
 */

public interface IMonster extends IBeing {
	
	/**
	 * The method move allow the monsters to move
	 * @param player
	 * 			The pawn of the player
	 * @param model
	 * 			The model
	 */
	public void move(IPawn player, IModel model);
	
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
     * @return int
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
