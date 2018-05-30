package model;

/**
 * The interface ISpell
 * @author Hugo
 *
 */
public interface ISpell {
	
	/**
	 * this method allow the movement
	 */
	public void move();
	
	/**
	 * this method reverse the direction of the spell
	 */
	public void reverse();
	
	/**
	 * this method show if the spell was called by the player
	 */
	public boolean isRepelled();
	

	
}
