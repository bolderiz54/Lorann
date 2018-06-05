package model.AIDesignPatter;

import java.awt.Point;

import model.Direction;
import model.IModel;
import model.Monster;
import model.Permeability;
import showboard.IPawn;

/**
 * <h1>The class Wheel</h1>
 * This class is a behavior from IAIMonster for monsters
 * @author Vincent Linck
 * @version 1.0
 */
public class Wheel implements IAIMonster {

	@Override
	public void move(IPawn player, IModel model, Monster monster) {
		Point frontPosition, rightPosition, leftPosition, backPosition, rightBackPosition;
	
		switch (monster.getDirection()) {
		case DIR_RIGHT:
			frontPosition = new Point(monster.getX() + 1, monster.getY());
			rightPosition = new Point(monster.getX(), monster.getY() + 1);
			leftPosition = new Point(monster.getX(), monster.getY() - 1);
			backPosition = new Point(monster.getX() - 1, monster.getY());
			rightBackPosition = new Point(monster.getX() - 1, monster.getY() + 1);
			break;
		case DIR_DOWN:
			frontPosition = new Point(monster.getX(), monster.getY() + 1);
			rightPosition = new Point(monster.getX() - 1, monster.getY());
			leftPosition = new Point(monster.getX() + 1, monster.getY());
			backPosition = new Point(monster.getX(), monster.getY() - 1);
			rightBackPosition = new Point(monster.getX() - 1, monster.getY() - 1);
			break;
		case DIR_LEFT:
			frontPosition = new Point(monster.getX() - 1, monster.getY());
			rightPosition = new Point(monster.getX(), monster.getY() - 1);
			leftPosition = new Point(monster.getX(), monster.getY() + 1);
			backPosition = new Point(monster.getX() + 1, monster.getY());
			rightBackPosition = new Point(monster.getX() + 1, monster.getY() - 1);
			break;
		case DIR_UP:
		default:
			monster.setDirection(Direction.DIR_UP);
			frontPosition = new Point(monster.getX(), monster.getY() - 1);
			rightPosition = new Point(monster.getX() + 1, monster.getY());
			leftPosition = new Point(monster.getX() - 1, monster.getY());
			backPosition = new Point(monster.getX(), monster.getY() + 1);
			rightBackPosition = new Point(monster.getX() + 1, monster.getY() + 1);
			break;
		}
		
		if (model.getOnMap(rightBackPosition.x, rightBackPosition.y).getPermeability() != Permeability.PENETRABLE &&
				model.getOnMap(rightPosition.x, rightPosition.y).getPermeability() == Permeability.PENETRABLE) {
			switch (monster.getDirection()) {
			case DIR_RIGHT:
				monster.setDirection(Direction.DIR_DOWN);
				break;
			case DIR_DOWN:
				monster.setDirection(Direction.DIR_LEFT);
				break;
			case DIR_LEFT:
				monster.setDirection(Direction.DIR_UP);
				break;
			case DIR_UP:
			default:
				monster.setDirection(Direction.DIR_RIGHT);
				break;
			}
			monster.setPosition(rightPosition);
		}
		else if (model.getOnMap(frontPosition.x, frontPosition.y).getPermeability() == Permeability.PENETRABLE) {
			monster.setPosition(frontPosition);
		}
		else if (model.getOnMap(leftPosition.x, leftPosition.y).getPermeability() == Permeability.PENETRABLE) {
			switch (monster.getDirection()) {
			case DIR_RIGHT:
				monster.setDirection(Direction.DIR_UP);
				break;
			case DIR_DOWN:
				monster.setDirection(Direction.DIR_RIGHT);
				break;
			case DIR_LEFT:
				monster.setDirection(Direction.DIR_DOWN);
				break;
			case DIR_UP:
			default:
				monster.setDirection(Direction.DIR_LEFT);
				break;
			}
			monster.setPosition(leftPosition);
		}
		else if (model.getOnMap(backPosition.x, backPosition.y).getPermeability() == Permeability.PENETRABLE) {
			switch (monster.getDirection()) {
			case DIR_RIGHT:
				monster.setDirection(Direction.DIR_LEFT);
				break;
			case DIR_DOWN:
				monster.setDirection(Direction.DIR_UP);
				break;
			case DIR_LEFT:
				monster.setDirection(Direction.DIR_RIGHT);
				break;
			case DIR_UP:
			default:
				monster.setDirection(Direction.DIR_DOWN);
				break;
			}
			monster.setPosition(backPosition);
		}
		else if (model.getOnMap(rightPosition.x, rightPosition.y).getPermeability() == Permeability.PENETRABLE) {
			switch (monster.getDirection()) {
			case DIR_RIGHT:
				monster.setDirection(Direction.DIR_DOWN);
				break;
			case DIR_DOWN:
				monster.setDirection(Direction.DIR_LEFT);
				break;
			case DIR_LEFT:
				monster.setDirection(Direction.DIR_UP);
				break;
			case DIR_UP:
			default:
				monster.setDirection(Direction.DIR_RIGHT);
				break;
			}
			monster.setPosition(rightPosition);
		}
		else {
			monster.setDirection(Direction.DIR_NONE);
		}
	}
	
}
