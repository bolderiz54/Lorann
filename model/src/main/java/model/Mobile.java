package model;

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
	public Mobile(String imagePath) {
		super(imagePath);
		
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
	
}
