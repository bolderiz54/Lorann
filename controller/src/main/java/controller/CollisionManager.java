package controller;

import model.IEntity;
import model.IModel;

public class CollisionManager {
	
	private IModel model;
	
	public CollisionManager(IModel model) {
		
	}
	
	public boolean wallCollision(IEntity entity, Object order) {
		return false;
		
	}

	public boolean crossCollision(IEntity entity1, IEntity entity2) {
		return false;
		
	}
}
