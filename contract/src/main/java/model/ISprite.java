package model;

import java.awt.Image;

public interface ISprite {

	/**
	 * load the image thanks to the image path
	 */
	public void loadImage();
	
	/**
	 * set the image path
	 * @param imagePath
	 */
	public void setImagePath(String imagePath);
	
	public String getImagePath();
	
	/**
	 * get the image
	 * @return
	 */
	public Image getImage();
	
}
