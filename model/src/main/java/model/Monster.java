package model;

import java.awt.Point;

import model.AIDesignPatter.IAIMonster;
import showboard.IPawn;

/**
 * <h1> This class describe the structure of a monster <h1>
 * 
 * @author Vincent Linck
 * @version 1.0
 */
public class Monster extends Being implements IMonster {

	/**
	 * The behavior that have the monster
	 */
	private IAIMonster behavior;
	
	/**
	 * The direction of the monster
	 */
	private Direction direction;
	
	/**
	 * Instantiate a monster with a custom image and a custom behavior
	 * @param imagePath
	 * @param behaviour
	 */
	public Monster(String imagePath, IAIMonster behavior) {
		super(imagePath, Permeability.KILLING);
		
		this.behavior = behavior;
		
		if (this.behavior.getClass().getName() == "model.AIDesignPatter.Bishop") {
			this.setDirection(Direction.DIR_UP_LEFT);
		}
		else {
			this.setDirection(Direction.DIR_UP);
		}
	}
	
	/**
	 * It allows the monster to move regard of his behavior
	 */
	@Override
	public void move(IPawn player, IModel model) {
		this.behavior.move(player, model, this);
		
		/*switch(this.getDirection()) {
		case DIR_UP_RIGHT:
			this.setPosition(new Point(this.getX() + 1, this.getY() - 1));
			break;
		case DIR_RIGHT:
			this.setPosition(new Point(this.getX() + 1, this.getY()));
			break;
		case DIR_DOWN_RIGHT:
			this.setPosition(new Point(this.getX() + 1, this.getY() + 1));
			break;
		case DIR_DOWN:
			this.setPosition(new Point(this.getX(), this.getY() + 1));
			break;
		case DIR_DOWN_LEFT:
			this.setPosition(new Point(this.getX() - 1, this.getY() + 1));
			break;
		case DIR_LEFT:
			this.setPosition(new Point(this.getX() - 1, this.getY()));
			break;
		case DIR_UP_LEFT:
			this.setPosition(new Point(this.getX() - 1, this.getY() - 1));
			break;
		case DIR_UP:
			this.setPosition(new Point(this.getX(), this.getY() - 1));
			break;
		case DIR_NONE:
			break;
		}*/
	}

	/**
	 * get the direction
	 * @return
	 */
	public Direction getDirection() {
		return direction;
	}

	/**
	 * set the direction
	 * @param direction
	 */
	public void setDirection(Direction direction) {
		this.direction = direction;
	}

}
