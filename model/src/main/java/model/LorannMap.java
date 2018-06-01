package model;

import java.util.Observable;
import java.util.Observer;

/**
 * This class describe how to use a map
 * 
 * @author Vincent Linck
 * @version 1.1
 */
@SuppressWarnings("deprecation")
public class LorannMap extends Observable {
	
	/**
	 * The map that the game use
	 */
	private IEntity[][] map;
	
	public LorannMap(int width, int height) {
		map = new IEntity[height][width];
	}
	
	/**
	 * Get an entity on the map
	 * @param x
	 * @param y
	 * @return
	 */
	public IEntity getOnMap(int x, int y) {
		return map[y][x];
	}
	
	/**
	 * Set an entity on the map
	 * @param entity
	 * @param x
	 * @param y
	 */
	public void setOnMap(IEntity entity, int x, int y) {
		map[y][x] = entity;
	}
	
	/**
     * Sets the mobile has changed.
     */
	public final void setMobileHasChanged() {
        this.setChanged();
        this.notifyObservers();
    }
    
    /**
     * add an observer
     */
    @Override
    public void addObserver(Observer observer) {
    	super.addObserver(observer);
    }

}
