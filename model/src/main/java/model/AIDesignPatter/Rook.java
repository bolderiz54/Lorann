package model.AIDesignPatter;

import java.awt.Point;

import model.Direction;
import model.IModel;
import model.Monster;
import model.Permeability;
import showboard.IPawn;

public class Rook implements IAIMonster {

	@Override
	public void move(IPawn player, IModel model, Monster monster) {
		Point nextPosition;
		
		for (int i = 0; i < 5; i++) {
			if (i == 5) {
				monster.setDirection(Direction.DIR_NONE);
				break;
			}
			
			switch (monster.getDirection()) {
			case DIR_RIGHT:
				nextPosition = new Point(monster.getX() + 1, monster.getY());
				break;
			case DIR_DOWN:
				nextPosition = new Point(monster.getX(), monster.getY() + 1);
				break;
			case DIR_LEFT:
				nextPosition = new Point(monster.getX() - 1, monster.getY());
				break;
			case DIR_UP:
			default:
				monster.setDirection(Direction.DIR_UP);
				nextPosition = new Point(monster.getX(), monster.getY() - 1);
				break;
			}
			
			if (model.getOnMap(nextPosition.x, nextPosition.y).getPermeability() == Permeability.PENETRABLE) {
				monster.setPosition(nextPosition);
				break;
			}
			else {
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
					monster.setDirection(Direction.DIR_RIGHT);
					break;
				default:
					break;
				}
			}
		}
	}
	
}
