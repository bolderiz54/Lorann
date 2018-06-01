package model.AIDesignPatter;

import model.IModel;
import model.Monster;
import showboard.IPawn;

public interface IAIMonster {
	
	/**
	 * This methods describe how to call the behavior of a monster
	 * @param player
	 * @param model
	 * @param monster
	 */
	public void move(IPawn player, IModel model, Monster monster);

}
