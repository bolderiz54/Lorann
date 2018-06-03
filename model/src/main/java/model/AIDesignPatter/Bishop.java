package model.AIDesignPatter;

import java.awt.Point;

import model.Direction;
import model.IModel;
import model.Monster;
import model.Permeability;
import showboard.IPawn;

public class Bishop implements IAIMonster {

	@Override
	public void move(IPawn player, IModel model, Monster monster) {
Point nextPosition;
		
		for (int i = 0; i < 5; i++) {
			if (i == 5) {
				monster.setDirection(Direction.DIR_NONE);
				break;
			}
			
			switch (monster.getDirection()) {
			
			case DIR_DOWN_RIGHT:
				nextPosition = new Point(monster.getX() + 1, monster.getY() + 1);
				break;
			case DIR_DOWN_LEFT:
				nextPosition = new Point(monster.getX() - 1, monster.getY() + 1);
				break;
			case DIR_UP_LEFT:
				nextPosition = new Point(monster.getX() - 1, monster.getY() - 1);
				break;
			case DIR_UP_RIGHT:
			default:
				monster.setDirection(Direction.DIR_UP_RIGHT);
				nextPosition = new Point(monster.getX() + 1, monster.getY() - 1);
				break;
			}
			
			if (model.getOnMap(nextPosition.x, nextPosition.y).getPermeability() == Permeability.PENETRABLE) {
				monster.setPosition(nextPosition);
				break;
			}
			else {
				switch (monster.getDirection()) {
				case DIR_UP_RIGHT:
					monster.setDirection(Direction.DIR_DOWN_RIGHT);
					break;
				case DIR_DOWN_RIGHT:
					monster.setDirection(Direction.DIR_DOWN_LEFT);
					break;
				case DIR_DOWN_LEFT:
					monster.setDirection(Direction.DIR_UP_LEFT);
					break;
				case DIR_UP_LEFT:
					monster.setDirection(Direction.DIR_UP_RIGHT);
					break;
				default:
					break;
				}
			}
		}
	}

}
