package controller;

import java.awt.Point;

import model.IEntity;
import model.IModel;

public class CollisionManager {
	
	private IModel model;
	
	public CollisionManager(IModel model) {
		this.model = model;
	}
	
	public boolean wallCollision(IPlayer player, Object order) {
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
			position.x -= 1;
			break;
		case ORD_M_DOWN_R:
			position.y += 1;
			position.x -= 1;
			break;
		case ORD_M_DOWN:
			position.y += 1;
			break;
		case ORD_M_DOWN_L:
			position.y +=1;
			position.x +=1;
			break;
		case ORD_M_LEFT:
			position.x += 1;
			break;
		case ORD_M_UP_L:
			position.y -= 1;
			position.x -= 1;
			break;
		default:
				
		}
		return false;
		
	}

	public boolean crossCollision(IEntity entity1, IEntity entity2) {
		return false;
		
	}
}
