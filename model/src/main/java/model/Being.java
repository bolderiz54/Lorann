package model;

/**
 * 
 * @author Vincent Linck
 * @version 1.0
 *
 */
public abstract class Being extends Mobile implements IBeing {
	
	/**
	 * Instantiate being
	 * @param imagePath
	 */
	public Being(String imagePath) {
		super(imagePath);
		// TODO Auto-generated constructor stub
	}

	/**
	 * True or false if the being is alive or not
	 */
	private Boolean alive = true;

	@Override
	public boolean isAlive() {
		// TODO Auto-generated method stub
		return alive;
	}

	@Override
	public void die() {
		alive=false;
		
	}

	@Override
	public void reserruct() {
		alive=true;
		
	}

}
