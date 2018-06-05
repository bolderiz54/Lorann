package model;

import java.awt.Image;
import showboard.ISquare;

/**
 * <h1>The class Entity</h1>
 * This class contains the methods to give life to an entity
 * @author Vincent Linck
 * @version 1.0
 *
 */
public class Entity implements IEntity, ISquare {

	/**
	 * The sprite of the entity
	 */
	private Sprite sprite;
	
	/**
	 * The permeability of the entity
	 */
	private Permeability permeability;
	
	/**
	 * Instantiate an object Entity with an image (path)
	 * @param imagePath
	 * 			The path to the image
	 * @param permeability
	 * 			The permeability to the image
	 */
	public Entity(String imagePath, Permeability permeability) {
		this.sprite = new Sprite(imagePath);
		this.setPermeability(permeability);
	}

	/**
	 * get the image
	 * @return Image
	 * 			The image of the entity
	 */
	@Override
	public Image getImage() {
		return sprite.getImage();
	}

	/**
	 * get the sprite
	 * @return Sprite
	 * 			The sprite of the entity
	 */
	@Override
	public ISprite getSprite() {
		return (ISprite) this.sprite;
	}

	/**
	 * get the permeability
	 * @return Permeability
	 * 			The permeability of the entity
	 */
	@Override
	public Permeability getPermeability() {
		return this.permeability;
	}

	/**
	 * set the permeability
	 * @param permeability
	 * 			The permeability of the entity
	 */
	protected void setPermeability(Permeability permeability) {
		this.permeability = permeability;
	}

}

