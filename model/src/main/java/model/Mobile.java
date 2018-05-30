package model;

import java.awt.Point;

import showboard.IPawn;

/**
 * <h1> This class allows an entity to move <h1>
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
		
	}
	
	/**
	 * set the y position
	 * @param y
	 */
	protected void setY(int y) {
		
	}
	
	/**
	 * set the x and the y positions
	 * @param position
	 */
	public void setPosition(Point position) {
		
	}

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return x;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return y;
	}

	@Override
	public Point getPosition() {
		// TODO Auto-generated method stub
		return new Point(x, y);
	}
	
}

