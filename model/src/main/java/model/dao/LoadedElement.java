package model.dao;

import java.awt.Point;

import model.ILoadedElement;

/**
 * <h1> This class is used by the model to remember the element loaded from the databased </h1>
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
	 * @param position
	 */
	public LoadedElement(String name, Point position) {
		this.name = name;
		this.position = position;
	}
	
	/**
	 * Instantiate a new element
	 * @param elementName
	 * @param x
	 * @param y
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
