package model;

import showboard.IPawn;

/**
 * <h1>The Interface IMonster.</h1>
 *  
 * @author Hugo
 * @version 1.0
 */

public interface IMonster extends IBeing{
	
	/**
	 * The method move allow the monsters to move
	 * @param player
	 * @param model
	 */
	public void move(IPawn player, IModel model);
	
}
