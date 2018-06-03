package model;

import java.awt.Point;

/**
 * <h1> How to use class mobile </h1>
 * @author pcmga
 *
 */
public interface IMobile {

	/**
	 * set the x position
	 * @param x
	 */
	public void setX(int x);
	
	/**
	 * set the y position
	 * @param y
	 */
	public void setY(int y);
	
	/**
	 * set the x and the y positions
	 * @param position
	 */
	public void setPosition(Point position);
	
}
