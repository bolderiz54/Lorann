package model;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * <h1> Contains the methods needed to make a sprite </h1>
 * 
 * @author Vincent Linck
 * @version 1.1
 *
 */
public class Sprite {
	
	/**
	 * path to the image
	 */
	private String imagePath;
	
	/**
	 * image of the sprite
	 */
	private Image image;
	
	/**
	 * instantiate a sprite with an image (path)
	 * @param imagePath
	 */
	public Sprite(String imagePath) {
		this.setImagePath(imagePath);
	}
	
	/**
	 * load the image thanks to the image path
	 * @throws IOException 
	 */
	public void loadImage() throws IOException {
		this.image = ImageIO.read(new File(this.imagePath));
	}
	
	/**
	 * set the image path
	 * @param imagePath
	 */
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
	/**
	 * get the image
	 * @return
	 */
	public Image getImage() {
		return image;
	}

}

