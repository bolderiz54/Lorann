package model;

import java.awt.Point;

/**
 * <h1> This interface describes how to use the element loaded from the databased </h1>
 * @author Vincent Linck
 * @version 1.0
 */
public interface ILoadedElement {
	
	/**
	 * it returns the name of the element
	 * @return
	 */
	public String getName();
	
	/**
	 * it sets the name
	 * @param name
	 */
	public void setName(String name);
	
	/**
	 * it returns the position
	 * @return
	 */
	public Point getPosition();
	
	/**
	 * it sets the position
	 * @param position
	 */
	public void setPosition(Point position);

}

