package model;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * <h1>The class Sprite</h1>
 * Contains the methods needed to make a sprite
 * @author Vincent Linck
 * @version 1.1
 *
 */
public class Sprite implements ISprite {
	
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
	 * 			The path to the image
	 */
	public Sprite(String imagePath) {
		this.setImagePath(imagePath);
	}
	
	/**
	 * load the image thanks to the image path
	 */
	public void loadImage() {
		try {
			this.image = ImageIO.read(new File(imagePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * set the image path
	 * @param imagePath
	 * 			The path to the image
	 */
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
		this.loadImage();
	}
	
	/**
	 * get the image
	 * @return Image
	 * 			The image of the sprite
	 */
	public Image getImage() {
		return image;
	}
	
	/**
	 * get the image path
	 * @return String
	 * 			The path to the image
	 */
	public String getImagePath() {
		return this.imagePath;
	}

}

