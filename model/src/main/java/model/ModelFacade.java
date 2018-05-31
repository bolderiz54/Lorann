package model;

import java.sql.SQLException;
import java.util.List;

import model.dao.ExampleDAO;

/**
 * <h1>The Class ModelFacade provides a facade of the Model component.</h1>
 *
 * @author Vincent Linck
 * @version 1.0
 */
public final class ModelFacade implements IModel {
	
	/**
	 * The number of the level which will be loaded
	 */
	private int levelNumber = 1;
	
	/**
	 * The level loaded from the database
	 */
	private int[][] loadedLevel;
	
	/**
	 * The map that the game use
	 */
	private IEntity[][] map;
	
	/**
	 * the width of the map
	 */
	private int width;
	
	/**
	 * the height of the map
	 */
	private int height;
	
	/**
	 * the score obtained
	 */
	private Score score;
	
    /**
     * Instantiates a new model facade.
     * 
     * @param map's width
     * @param map's height
     * @param view
     */
    public ModelFacade(final int width, final int height, final IView view) {
        
    }

    /**
	 * get the score
	 * @return the score
	 */
	@Override
	public int getScore() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * calculate and add the score
	 * @param points
	 */
	@Override
	public void addScore(int points) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * set the score 
	 * @param points
	 */
	@Override
	public void setScore(int points) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 
	 * @param level (int)
	 * @return true if the entity is alive
	 */
	@Override
	public boolean loadLevel(int level) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Reset the level
	 */
	@Override
	public void resetLevel() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Unload the level
     */
	@Override
	public void unloadLevel() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 
	 * @return all the entity in the map
	 */
	@Override
	public IEntity[][] getMap() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * get the Width of the map
     * @return the size of the width (int)
	 */
	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * set the width
	 * @param width
	 */
	@Override
	public void setWidth(int width) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * get the height
	 * @return the size of the height (int)
	 */
	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * set the height
	 * @param height
	 */
	@Override
	public void setHeight(int height) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * get the player
	 */
	@Override
	public Player getPlayer() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * This is to get a Monster
     * @param monsterNumber
     * @return the number of the monster
	 */
	@Override
	public Monster getMonster(int monsterNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * The method check if the spell exist or not 
     * @return true if the spell exist
	 */
	@Override
	public boolean isSpellExist() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * get the spell
	 */
	@Override
	public ISpell getSpell() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * get an Entity
     * @param x  The movements of the Entity
     * @param y The movements of the Entity
     * @return  an entity at the right coordinates
	 */
	@Override
	public IEntity getOnMap(int x, int y) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * generate the spell
	 */
	@Override
	public void generateSpell() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * destroy the spell
	 */
	@Override
	public void destroySpell() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * remove a square from the map
	 */
	@Override
	public void removeSquare(int x, int y) {
		// TODO Auto-generated method stub
		
	}

}

