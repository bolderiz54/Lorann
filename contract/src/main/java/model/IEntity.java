package model;

public interface IEntity {
	
	/**
	 * get the sprite
	 */
	public Sprite getSprite();
	
	/**
	 * get the permeability of an entity 
	 * how the entity interact with his environment
	 */
	public Permeability getPermeability();
	
	/**
	 * set the permeability to an entity
	 * @param permeability
	 */
	public void setPermeability(Permeability permeability);

}
