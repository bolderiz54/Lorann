package model;

public interface IEntity {
	
	/**
	 * get the sprite
	 * @return ISprite
	 * 			the sprite of the entity
	 */
	public ISprite getSprite();
	
	/**
	 * get the permeability of an entity 
	 * how the entity interact with his environment
	 * @return Permeability
	 * 			the permeability of the entity
	 */
	public Permeability getPermeability();
	
}
