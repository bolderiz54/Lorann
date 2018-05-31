package controller;

import java.awt.Point;

import model.IEntity;
import model.IModel;
import model.IPlayer;
import model.Permeability;

public class CollisionManager {
	
	private IModel model;
	
	public CollisionManager(IModel model) {
		this.model = model;
	}
	
	public boolean wallCollision(IPlayer player, Order order) {
		Point position = player.getPosition();
		switch (order) {
		case ORD_M_UP:
			position.y -= 1;
			break;
		case ORD_M_UP_R:
			position.y -= 1;
			position.x += 1;
			break;
		case ORD_M_RIGHT:
			position.x += 1;
			break;
		case ORD_M_DOWN_R:
			position.y += 1;
			position.x += 1;
			break;
		case ORD_M_DOWN:
			position.y += 1;
			break;
		case ORD_M_DOWN_L:
			position.y +=1;
			position.x -=1;
			break;
		case ORD_M_LEFT:
			position.x -= 1;
			break;
		case ORD_M_UP_L:
			position.y -= 1;
			position.x -= 1;
			break;
		default:
			break;
		}
		
		IEntity entity = model.getOnMap(position.x, position.y);
		Permeability permeability = entity.getPermeability();
		switch (permeability) {
		
		case BLOCKING:
			return false;
		case PENETRABLE:
			return true;
		case COLLECTABLE:
			model.removeSquare(position.x, position.y);
			model.addScore(250);
			return true;
		case KILLING:
			player.die();
			return true;
		case SPELLING:
			model.destroySpell();
			return true;
		default:
			return false;
		}
			
	}

	public boolean crossCollision(IEntity entity1, IEntity entity2) {
		return false;
	}
}
