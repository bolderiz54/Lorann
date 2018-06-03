package model.AIDesignPatter;

import java.awt.Point;

import model.Direction;
import model.IModel;
import model.Monster;
import model.Permeability;
import showboard.IPawn;

public class Stalker implements IAIMonster {

	@Override
	public void move(IPawn player, IModel model, Monster monster) {
		Point offset = new Point(player.getX() - monster.getX(), player.getY() - monster.getY());
		Point straightPosition, secondPosition, thirdPosition;
		Direction straightDirection, secondDirection, thirdDirection;
		double ratio;
		
		if (player.getPosition() == monster.getPosition()) {
			monster.setDirection(Direction.DIR_NONE);
			return;
		}
		
		if (offset.y == 0) {
			ratio = 10.0;
		}
		else {
			ratio = offset.getX() / offset.getY();
			if (ratio < 0) {
				ratio *= -1;
			}
		}
		
		if (ratio >= 2) {
			if (offset.x > 0) {
				straightDirection = Direction.DIR_RIGHT;
				straightPosition = new Point(monster.getX() + 1, monster.getY());
				if (offset.y > 0) {
					secondDirection = Direction.DIR_DOWN_RIGHT;
					secondPosition = new Point(monster.getX() + 1, monster.getY() + 1);
					thirdDirection = Direction.DIR_UP_RIGHT;
					thirdPosition = new Point(monster.getX() + 1, monster.getY() - 1);
				}
				else {
					secondDirection = Direction.DIR_UP_RIGHT;
					secondPosition = new Point(monster.getX() + 1, monster.getY() - 1);
					thirdDirection = Direction.DIR_DOWN_RIGHT;
					thirdPosition = new Point(monster.getX() + 1, monster.getY() + 1);
				}
			}
			else {
				straightDirection = Direction.DIR_LEFT;
				straightPosition = new Point(monster.getX() - 1, monster.getY());
				if (offset.y > 0) {
					secondDirection = Direction.DIR_DOWN_LEFT;
					secondPosition = new Point(monster.getX() - 1, monster.getY() + 1);
					thirdDirection = Direction.DIR_UP_LEFT;
					thirdPosition = new Point(monster.getX() - 1, monster.getY() - 1);
				}
				else {
					secondDirection = Direction.DIR_UP_LEFT;
					secondPosition = new Point(monster.getX() - 1, monster.getY() - 1);
					thirdDirection = Direction.DIR_DOWN_LEFT;
					thirdPosition = new Point(monster.getX() - 1, monster.getY() + 1);
				}
			}
		}
		else if (ratio <= 0.5) {
			if (offset.y > 0) {
				straightDirection = Direction.DIR_DOWN;
				straightPosition = new Point(monster.getX(), monster.getY() + 1);
				if (offset.x > 0) {
					secondDirection = Direction.DIR_DOWN_RIGHT;
					secondPosition = new Point(monster.getX() + 1, monster.getY() + 1);
					thirdDirection = Direction.DIR_DOWN_LEFT;
					thirdPosition = new Point(monster.getX() - 1, monster.getY() + 1);
				}
				else {
					secondDirection = Direction.DIR_DOWN_LEFT;
					secondPosition = new Point(monster.getX() - 1, monster.getY() + 1);
					thirdDirection = Direction.DIR_DOWN_RIGHT;
					thirdPosition = new Point(monster.getX() + 1, monster.getY() + 1);
				}
			}
			else {
				straightDirection = Direction.DIR_UP;
				straightPosition = new Point(monster.getX(), monster.getY() - 1);
				if (offset.x > 0) {
					secondDirection = Direction.DIR_UP_RIGHT;
					secondPosition = new Point(monster.getX() + 1, monster.getY() - 1);
					thirdDirection = Direction.DIR_UP_LEFT;
					thirdPosition = new Point(monster.getX() - 1, monster.getY() - 1);
				}
				else {
					secondDirection = Direction.DIR_UP_LEFT;
					secondPosition = new Point(monster.getX() - 1, monster.getY() - 1);
					thirdDirection = Direction.DIR_UP_RIGHT;
					thirdPosition = new Point(monster.getX() + 1, monster.getY() - 1);
				}
			}
		}
		else {
			if (offset.x > 0) {
				if (offset.y > 0) {
					straightDirection = Direction.DIR_DOWN_RIGHT;
					straightPosition = new Point(monster.getX() + 1, monster.getY() + 1);
					if (ratio >= 1) {
						secondDirection = Direction.DIR_RIGHT;
						secondPosition = new Point(monster.getX() + 1, monster.getY());
						thirdDirection = Direction.DIR_DOWN;
						thirdPosition = new Point(monster.getX(), monster.getY() + 1);
					}
					else {
						secondDirection = Direction.DIR_DOWN;
						secondPosition = new Point(monster.getX(), monster.getY() + 1);
						thirdDirection = Direction.DIR_RIGHT;
						thirdPosition = new Point(monster.getX() + 1, monster.getY());
					}
				}
				else {
					straightDirection = Direction.DIR_UP_RIGHT;
					straightPosition = new Point(monster.getX() + 1, monster.getY() - 1);
					if (ratio >= 1) {
						secondDirection = Direction.DIR_RIGHT;
						secondPosition = new Point(monster.getX() + 1, monster.getY());
						thirdDirection = Direction.DIR_UP;
						thirdPosition = new Point(monster.getX(), monster.getY() - 1);
					}
					else {
						secondDirection = Direction.DIR_UP;
						secondPosition = new Point(monster.getX(), monster.getY() - 1);
						thirdDirection = Direction.DIR_RIGHT;
						thirdPosition = new Point(monster.getX() + 1, monster.getY());
					}
				}
			}
			else {
				if (offset.y > 0) {
					straightDirection = Direction.DIR_DOWN_LEFT;
					straightPosition = new Point(monster.getX() - 1, monster.getY() + 1);
					if (ratio >= 1) {
						secondDirection = Direction.DIR_LEFT;
						secondPosition = new Point(monster.getX() - 1, monster.getY());
						thirdDirection = Direction.DIR_DOWN;
						thirdPosition = new Point(monster.getX(), monster.getY() + 1);
					}
					else {
						secondDirection = Direction.DIR_DOWN;
						secondPosition = new Point(monster.getX(), monster.getY() + 1);
						thirdDirection = Direction.DIR_LEFT;
						thirdPosition = new Point(monster.getX() - 1, monster.getY());
					}
				}
				else {
					straightDirection = Direction.DIR_UP_LEFT;
					straightPosition = new Point(monster.getX() - 1, monster.getY() - 1);
					if (ratio >= 1) {
						secondDirection = Direction.DIR_LEFT;
						secondPosition = new Point(monster.getX() - 1, monster.getY());
						thirdDirection = Direction.DIR_UP;
						thirdPosition = new Point(monster.getX(), monster.getY() - 1);
					}
					else {
						secondDirection = Direction.DIR_UP;
						secondPosition = new Point(monster.getX(), monster.getY() - 1);
						thirdDirection = Direction.DIR_LEFT;
						thirdPosition = new Point(monster.getX() - 1, monster.getY());
					}
				}
			}
		}
		
		if (model.getOnMap(straightPosition.x, straightPosition.y).getPermeability() == Permeability.PENETRABLE) {
			monster.setDirection(straightDirection);
			monster.setPosition(straightPosition);
		}
		else if (model.getOnMap(secondPosition.x, secondPosition.y).getPermeability() == Permeability.PENETRABLE) {
			monster.setDirection(secondDirection);
			monster.setPosition(secondPosition);
		}
		else if (model.getOnMap(thirdPosition.x, thirdPosition.y).getPermeability() == Permeability.PENETRABLE) {
			monster.setDirection(thirdDirection);
			monster.setPosition(thirdPosition);
		}
		else {
			monster.setDirection(Direction.DIR_NONE);
		}
	}
	
}
