package model;

import java.awt.Point;

/**
 * <h1>The class Spell</h1>
 * @author Hugo
 * @version 1.0
 */
public class Spell extends Mobile implements ISpell {

	private int animationStep = 0;
	private boolean repelled = false;
	private static String imagesPath[] = {"../sprite/spell_1.png", "../sprite/spell_2.png",
			"../sprite/spell_3.png", "../sprite/spell_4.png", "../sprite/spell_5.png"};
	private Direction direction;

	/**
	 * This method instantiates a new spell
	 */
	public Spell() {
		super(imagesPath[0], Permeability.SPELLING);
		this.setPosition(new Point(0, 0));
		this.setDirection(Direction.DIR_UP);
	}
	
	/**
	 * This method instantiates a new spell
	 * @param direction
	 * 			The direction of the spell
	 * @param position
	 * 			The position of the spell
	 */
	public Spell(Direction direction, Point position) {
		super(imagesPath[0], Permeability.SPELLING);
		this.setPosition(new Point(position));
		this.setDirection(direction);
		this.reverse();
		this.repelled = false;
	}

	@Override
	public void move() {
		switch (direction) {
		case DIR_UP:
			this.setY(this.getY() - 1);
			break;
		case DIR_UP_RIGHT:
			this.setY(this.getY() - 1); 
			this.setX(this.getX() + 1);
			break;
		case DIR_RIGHT:
			this.setX(this.getX() + 1);
			break;
		case DIR_DOWN_RIGHT:
			this.setY(this.getY() + 1);
			this.setX(this.getX() + 1);
			break;
		case DIR_DOWN:
			this.setY(this.getY() + 1);
			break;
		case DIR_DOWN_LEFT:
			this.setY(this.getY() + 1);
			this.setX(this.getX() - 1);
			break;
		case DIR_LEFT:
			this.setX(this.getX() - 1);
			break;
		case DIR_UP_LEFT:
			this.setY(this.getY() - 1);
			this.setX(this.getX() - 1); 
			break;
		default:
			break;
		}
	
		animationStep++;
		if (animationStep > 4) {
			animationStep -= 5;
		}
	
		getSprite().setImagePath(imagesPath[animationStep]);
	
	}

	@Override
	public void reverse() {
		switch (direction) {
		case DIR_UP:
			direction = Direction.DIR_DOWN;
			break;
		case DIR_UP_RIGHT:
			direction = Direction.DIR_DOWN_LEFT;
			break;
		case DIR_RIGHT:
			direction = Direction.DIR_LEFT;
			break;
		case DIR_DOWN_RIGHT:
			direction = Direction.DIR_UP_LEFT;
			break;
		case DIR_DOWN:
			direction = Direction.DIR_UP;
			break;
		case DIR_DOWN_LEFT:
			direction = Direction.DIR_UP_RIGHT;
			break;
		case DIR_LEFT:
			direction = Direction.DIR_RIGHT;
			break;
		case DIR_UP_LEFT:
			direction = Direction.DIR_DOWN_RIGHT; 
			break;
		default:
			break;
		}
		
		this.repelled = true;
	}
	
	@Override
	public boolean isRepelled() {
		return repelled;
	}
	
	public void setDirection(Direction direction) {
		this.direction = direction;
	}
	
	public Direction getDirection() {
		return this.direction;
	}

}