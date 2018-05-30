package model;

import java.awt.Image;

import showboard.ISquare;

/**
 * <h1> This class contains the methods to give life to an entity <h1>
 * 
 * @author Vincent Linck
 * @version 1.0
 *
 */
public class Entity implements IEntity, ISquare {

	/**
	 * Instatiat an object Entity with an image (path)
	 * @param imagePath
	 */
	public Entity(String imagePath) {
		
	}

	/**
	 * get the image
	 * @return Image
	 */
	@Override
	public Image getImage() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * get the sprite
	 * @return Sprite
	 */
	@Override
	public Sprite getSprite() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * get the permeability
	 * @return Permeability
	 */
	@Override
	public Permeability getPermeability() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * set the permeability
	 * @param permeability
	 */
	@Override
	public void setPermeability(Permeability permeability) {
		// TODO Auto-generated method stub
		
	}

}

