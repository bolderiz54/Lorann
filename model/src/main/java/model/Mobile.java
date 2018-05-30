package model;

import java.awt.Point;

import showboard.IPawn;

/**
 * <h1> This class allows an entity to move </h1>
 * 
 * @author Vincent Linck
 * @version 1.0
 *
 */
public class Mobile extends Entity implements IPawn {

	/**
	 * the x (horizontal) position
	 */
	private int x;
	
	/**
	 * the y (vertical) position
	 */
	private int y;
	
	/**
	 * instantiate a mobile entity
	 * @param imagePath
	 */
	public Mobile(String imagePath, Permeability permeability) {
		super(imagePath, permeability);
	}
	
	/**
	 * set the x position
	 * @param x
	 */
	protected void setX(int x) {
		this.x = x;
	}
	
	/**
	 * set the y position
	 * @param y
	 */
	protected void setY(int y) {
		this.y = y;
	}
	
	/**
	 * set the x and the y positions
	 * @param position
	 */
	public void setPosition(Point position) {
		this.x = position.x;
		this.y = position.y;
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public Point getPosition() {
		return new Point(x, y);
	}
	
}

