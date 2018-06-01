package model;

import java.awt.Image;
import java.io.IOException;

import showboard.ISquare;

/**
 * <h1> This class contains the methods to give life to an entity </h1>
 * 
 * @author Vincent Linck
 * @version 1.0
 *
 */
public class Entity implements IEntity, ISquare {

	/**
	 * The sprite of the entity
	 */
	private ISprite sprite;
	
	/**
	 * The permeability of the entity
	 */
	private Permeability permeability;
	
	/**
	 * Instatiat an object Entity with an image (path)
	 * @param imagePath
	 */
	public Entity(String imagePath, Permeability permeability) {
		this.sprite = (ISprite) new Sprite(imagePath);
		this.getSprite().loadImage();
		this.setPermeability(permeability);
	}

	/**
	 * get the image
	 * @return Image
	 */
	@Override
	public Image getImage() {
		return sprite.getImage();
	}

	/**
	 * get the sprite
	 * @return Sprite
	 */
	@Override
	public ISprite getSprite() {
		return this.sprite;
	}

	/**
	 * get the permeability
	 * @return Permeability
	 */
	@Override
	public Permeability getPermeability() {
		return this.permeability;
	}

	/**
	 * set the permeability
	 * @param permeability
	 */
	protected void setPermeability(Permeability permeability) {
		this.permeability = permeability;
	}

}

