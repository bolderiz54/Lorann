package model;

/**
 * <h1> This class describe how is made a Being </h1>
 * 
 * @author Vincent Linck
 * @version 1.0
 *
 */
public abstract class Being extends Mobile implements IBeing {
	
	/**
	 * True or false if the being is alive or not
	 */
	private Boolean alive = true;
	
	/**
	 * Instantiate being
	 * @param imagePath
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
