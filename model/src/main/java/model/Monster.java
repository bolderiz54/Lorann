package model;

import model.AIDesignPatter.IAIMonster;
import showboard.IPawn;

/**
 * <h1>The class Monster<h1>
 * This class describe the structure of a monster
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
	 * 			The path to the image
	 * @param behavior
	 * 			The behavior that the monster has
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
	
	@Override
	public void move(IPawn player, IModel model) {
		this.behavior.move(player, model, this);
	}

	/**
	 * get the direction
	 * @return Direction
	 * 			The direction of the monster
	 */
	public Direction getDirection() {
		return direction;
	}

	/**
	 * set the direction
	 * @param direction
	 * 			The direction of the monster
	 */
	public void setDirection(Direction direction) {
		this.direction = direction;
	}
	
	@Override
	public void reserruct() {
		super.reserruct();
		if (this.behavior.getClass().getName() == "model.AIDesignPatter.Bishop") {
			this.setDirection(Direction.DIR_UP_LEFT);
		}
		else {
			this.setDirection(Direction.DIR_UP);
		}
	}

}
