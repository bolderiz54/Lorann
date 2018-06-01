package model;

public interface IEntity {
	
	/**
	 * get the sprite
	 */
	public ISprite getSprite();
	
	/**
	 * get the permeability of an entity 
	 * how the entity interact with his environment
	 */
	public Permeability getPermeability();
	
}
