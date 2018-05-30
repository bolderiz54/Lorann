package model;

import showboard.IPawn;

/**
 * <h1> This class describe the structure of a monster <h1>
 * 
 * @author Vincent Linck
 * @version 1.0
 */
public class Monster extends Being implements IMonster {

	/**
	 * The behavior that have the monster
	 */
	private IMonster behavior;
	
	/**
	 * Instantiate a monster with a custom image and a custom behavior
	 * @param imagePath
	 * @param behaviour
	 */
	public Monster(String imagePath, IMonster behaviour) {
		
	}
	
	/**
	 * It allows the monster to move regard of his behavior
	 */
	@Override
	public void move(IPawn player, IModel model) {
		// TODO Auto-generated method stub
		
	}

}
