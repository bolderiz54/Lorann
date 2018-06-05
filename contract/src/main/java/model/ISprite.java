package model;

import java.awt.Image;

/**
 * <h1>The interface ISprite</h1>
 * @author vince
 *
 */
public interface ISprite {

	/**
	 * load the image thanks to the image path
	 */
	public void loadImage();
	
	/**
	 * set the image path
	 * @param imagePath
	 * 			The path to the image
	 */
	public void setImagePath(String imagePath);
	
	/**
	 * Get the path of the image
	 * @return String
	 * 			The image path
	 */
	public String getImagePath();
	
	/**
	 * get the image
	 * @return Image
	 * 			The image of the sprite
	 * @see Image
	 */
	public Image getImage();
	
}
