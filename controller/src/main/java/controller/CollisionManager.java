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
			
			break;
		case PENETRABLE:
			
			break;
		case COLLECTABLE:
			
			break;
		case KILLING:
			
			break;
		case SPELLING:
			
			break;
		}
			
			
		return false;
		
	}

	public boolean crossCollision(IEntity entity1, IEntity entity2) {
		return false;
		
	}
}
