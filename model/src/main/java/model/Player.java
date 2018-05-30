package model;

/**
 * <h1> This class describe the structure of the player <h1>
 * 
 * @author Vincent Linck
 * @version 1.0
 */
public class Player extends Being implements IPlayer {

	/**
	 * The direction of the player
	 */
	private Direction direction;
	
	/**
	 * The direction where the player is looking
	 */
	private Direction animationDirection;
	
	/**
	 * Instantiate the player
	 * @param imagePath
	 */
	public Player(String imagePath) {
		super(imagePath, Permeability.PENETRABLE);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * This method allows the player to move
	 */
	@Override
	public void move(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * getDirection
	 * @return Direction
	 */
	@Override
	public Direction getDirection() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * set the direction
	 */
	@Override
	public void setDirection(Direction direction) {
		// TODO Auto-generated method stub
		
	}
	
	

}
