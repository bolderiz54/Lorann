package model.AIDesignPatter;

import model.IModel;
import model.Monster;
import showboard.IPawn;

/**
 * <h1>The interface IAIMonster</h1>
 * This interface describe how to use behavior for monsters
 * @author Vincent Linck
 * @version 1.0
 *
 */
public interface IAIMonster {
	
	/**
	 * This methods describe how to call the behavior of a monster
	 * @param player
	 * 			The player to track
	 * @param model
	 * 			The model to refer
	 * @param monster
	 * 			The monster which has the behavior
	 */
	public void move(IPawn player, IModel model, Monster monster);

}
