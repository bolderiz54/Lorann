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

	private int levelNumber = 1;
	
	private int[][] loadedLevel;
	
	private IEntity[][] map;
	
	private int width;
	
	private int height;
	
	private Score score;
	
    /**
     * Instantiates a new model facade.
     * 
     * @param map's width
     * @param map's height
     */
    public ModelFacade(final int width, final int height) {
        super();
    }

	@Override
	public int getScore() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void addScore(int points) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setScore(int points) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean loadLevel(int level) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void resetLevel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void unloadLevel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public IEntity[][] getMap() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setWidth(int width) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setHeight(int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Player getPlayer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Monster getMonster(int monsterNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isSpellExist() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ISpell getSpell() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IEntity getOnMap(int x, int y) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void generateSpell() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroySpell() {
		// TODO Auto-generated method stub
		
	}

}
