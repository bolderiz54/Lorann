package model.dao;

import java.awt.Point;

import model.ILoadedElement;

/**
 * <h1>The class LoadedElement</h1>
 * This class is used by the model to remember the element loaded from the database
 * @author Vincent Linck
 * @version 1.0
 */
public class LoadedElement implements ILoadedElement {
	
	/**
	 * name of the element
	 */
	public String name;
	
	/**
	 * positon of the element
	 */
	public Point position;
	
	/**
	 * Instantiate a new element
	 * @param elementName
	 * 			The name of the element
	 * @param position
	 * 			The position of the element
	 */
	public LoadedElement(String name, Point position) {
		this.name = name;
		this.position = position;
	}
	
	/**
	 * Instantiate a new element
	 * @param elementName
	 * 			The name of the element
	 * @param x
	 * 			The x position of the element
	 * @param y
	 * 			The y position of the element
	 */
	public LoadedElement(String name, int x, int y) {
		this.name = name;
		this.position = new Point(x, y);
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public Point getPosition() {
		return this.position;
	}

	@Override
	public void setPosition(Point position) {
		this.position = position;
	}

}
