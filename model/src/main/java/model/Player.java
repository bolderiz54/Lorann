package model;

import java.awt.Image;
import java.awt.Point;
import java.io.IOException;

/**
 * <h1> This class describe the structure of the player </h1>
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
	 * The images of the player
	 */
	private static String[] imagesPath = {"C:\\Users\\pcmga\\git\\Lorann\\sprite\\lorann_u.png", "C:\\Users\\pcmga\\git\\Lorann\\sprite\\lorann_ur.png", "C:\\Users\\pcmga\\git\\Lorann\\sprite\\lorann_r.png", "C:\\Users\\pcmga\\git\\Lorann\\sprite\\lorann_br.png",
			"C:\\Users\\pcmga\\git\\Lorann\\sprite\\lorann_b.png", "C:\\Users\\pcmga\\git\\Lorann\\sprite\\lorann_bl.png", "C:\\Users\\pcmga\\git\\Lorann\\sprite\\lorann_l.png", "C:\\Users\\pcmga\\git\\Lorann\\sprite\\lorann_ul.png"};
	
	/**
	 * Instantiate the player
	 * @param imagePath
	 */
	public Player() {
		super(imagesPath[0], Permeability.PENETRABLE);
		this.setDirection(Direction.DIR_UP);
		this.animationDirection = Direction.DIR_UP;
	}
	
	/**
	 * This method allows the player to move
	 * @throws IOException 
	 */
	@Override
	public void move(int x, int y) {
		this.setPosition(new Point(x, y));
		
		if(x > 0) {
			if(y > 0) {
				this.setDirection(Direction.DIR_DOWN_RIGHT);
				this.animationDirection = this.getDirection();
			}
			else if (y < 0) {
				this.setDirection(Direction.DIR_UP_RIGHT);
				this.animationDirection = this.getDirection();
			}
			else {
				this.setDirection(Direction.DIR_RIGHT);
				this.animationDirection = this.getDirection();
			}
		}
		else if (x < 0) {
			if(y > 0) {
				this.setDirection(Direction.DIR_DOWN_LEFT);
				this.animationDirection = this.getDirection();
			}
			else if (y < 0) {
				this.setDirection(Direction.DIR_UP_LEFT);
				this.animationDirection = this.getDirection();
			}
			else {
				this.setDirection(Direction.DIR_LEFT);
				this.animationDirection = this.getDirection();
			}
		}
		else {
			if(y > 0) {
				this.setDirection(Direction.DIR_DOWN);
				this.animationDirection = this.getDirection();
			}
			else if (y < 0) {
				this.setDirection(Direction.DIR_UP);
				this.animationDirection = this.getDirection();
			}
		}
	}

	/**
	 * getDirection
	 * @return Direction
	 */
	@Override
	public Direction getDirection() {
		return this.direction;
	}

	/**
	 * set the direction
	 */
	@Override
	public void setDirection(Direction direction) {
		this.direction = direction;
	}
	
	private void setImage() throws IOException {
		switch (this.animationDirection) {
		case DIR_UP:
			this.getSprite().setImagePath(Player.imagesPath[0]);
			this.animationDirection = Direction.DIR_UP_RIGHT;
			break;
		case DIR_UP_RIGHT:
			this.getSprite().setImagePath(Player.imagesPath[1]);
			this.animationDirection = Direction.DIR_RIGHT;
			break;
		case DIR_RIGHT:
			this.getSprite().setImagePath(Player.imagesPath[2]);
			this.animationDirection = Direction.DIR_DOWN_RIGHT;
			break;
		case DIR_DOWN_RIGHT:
			this.getSprite().setImagePath(Player.imagesPath[3]);
			this.animationDirection = Direction.DIR_DOWN;
			break;
		case DIR_DOWN:
			this.getSprite().setImagePath(Player.imagesPath[4]);
			this.animationDirection = Direction.DIR_DOWN_LEFT;
			break;
		case DIR_DOWN_LEFT:
			this.getSprite().setImagePath(Player.imagesPath[5]);
			this.animationDirection = Direction.DIR_LEFT;
			break;
		case DIR_LEFT:
			this.getSprite().setImagePath(Player.imagesPath[6]);
			this.animationDirection = Direction.DIR_UP_LEFT;
			break;
		case DIR_UP_LEFT:
			this.getSprite().setImagePath(Player.imagesPath[7]);
			this.animationDirection = Direction.DIR_UP;
			break;
		}
		
		this.getSprite().loadImage();
	}
	
	@Override
	public Image getImage() {
		try {
			this.setImage();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return this.getSprite().getImage();
	}

}
