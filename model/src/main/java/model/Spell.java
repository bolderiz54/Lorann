package model;

/**
 * 
 * @author Hugo
 *
 */
public class Spell extends Mobile implements ISpell {

private int animationStep=0;
private boolean repelled=false;
private static String imagesPath[] = {"../sprite/spell_1", "../sprite/spell_2", "../sprite/spell_3", "../sprite/spell_4", "../sprite/spell_5"};
private Direction direction;


public Spell() {
	super(imagesPath[0], Permeability.SPELLING);
	}

/**
 * this method move and change the images of the Fireball
 */
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

/**
 * This method reverse the direction of the spell
 */
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
	
	
}

/**
 * this method return a boolean to watch if the spell is repel or not
 */
@Override
public boolean isRepelled() {
	return repelled;
}

}