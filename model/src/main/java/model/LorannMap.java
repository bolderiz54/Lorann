package model;

import java.util.Observable;
import java.util.Observer;

/**
 * This class describe how to use a map
 * 
 * @author Vincent Linck
 * @version 1.1
 */
public class LorannMap extends Observable implements ILorannMap {
	
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
	 * Instantiate the map
	 * @param width
	 * @param height
	 */
	public LorannMap(int width, int height) {
		this.width = width;
		this.height = height;
		map = new IEntity[this.height][this.width];
		
		for (int y = 0; y < this.height; y++) {
			for (int x = 0; x < this.height; x++) {
				map[y][x] = null;
			}
		}
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
    
    @Override
    public void addObserver(Observer observer) {
    	super.addObserver(observer);
    }

}
