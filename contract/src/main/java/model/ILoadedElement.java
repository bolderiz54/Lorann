package model;

import java.awt.Point;

/**
 * <h1>The interface ILoadedElement</h1>
 * This interface describes how to use the element loaded from the database
 * @author Vincent Linck
 * @version 1.0
 */
public interface ILoadedElement {
	
	/**
	 * it returns the name of the element
	 * @return String
	 * 			the loadedElement's name
	 */
	public String getName();
	
	/**
	 * it sets the name
	 * @param name
	 * 			the loadedElement's name
	 */
	public void setName(String name);
	
	/**
	 * it returns the position
	 * @return Point
	 * 			the loadedElement's position
	 */
	public Point getPosition();
	
	/**
	 * it sets the position
	 * @param position
	 * 			the loadedElement's position
	 */
	public void setPosition(Point position);

}

