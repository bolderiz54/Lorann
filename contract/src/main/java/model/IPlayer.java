package model;

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

}
