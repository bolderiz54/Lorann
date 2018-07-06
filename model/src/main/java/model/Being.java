package model;

/**
 * <h1>The abstract class Being</h1>
 * This class describe how is made a Being
 * @author Vincent Linck
 * @version 1.0
 *
 */
public class Being extends Mobile implements IBeing {
	
	/**
	 * True or false if the being is alive or not
	 */
	private Boolean alive = true;
	
	/**
	 * Instantiate being
	 * @param imagePath
	 * 			The path to the image
	 */
	public Being(String imagePath, Permeability permeability) {
		super(imagePath, permeability);
	}

	@Override
	public boolean isAlive() {
		return alive;
	}

	@Override
	public void die() {
		alive = false;
	}

	@Override
	public void reserruct() {
		alive = true;
	}

}
