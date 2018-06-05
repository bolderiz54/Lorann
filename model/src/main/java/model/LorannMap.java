package model;

import java.util.Observable;
import java.util.Observer;

/**
 * <h1>The class LorannMap</h1>
 * This class describe how to use a map
 * 
 * @author Vincent Linck
 * @version 1.1
 */
@SuppressWarnings("deprecation")
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
	 * 			The width of the map
	 * @param height
	 * 			The height of the map
	 */
	public LorannMap(int width, int height) {
		this.width = width;
		this.height = height;
		map = new IEntity[this.height][this.width];
		
		for (int y = 0; y < this.height; y++) {
			for (int x = 0; x < this.width; x++) {
				map[y][x] = null;
			}
		}
	}
	
	/**
	 * Get an entity on the map
	 * @param x
	 * 			The x position of the map
	 * @param y
	 * 			The y position of the map
	 * @return IEntity
	 * 			The entity
	 */
	public IEntity getOnMap(int x, int y) {
		if (x >= 0 && x < this.width && y >= 0 && y < this.height) {
			return map[y][x];
		}
		return new Entity("../sprite/ground.png", Permeability.BLOCKING);
	}
	
	/**
	 * Set an entity on the map
	 * @param entity
	 * 			The entity
	 * @param x
	 * 			The x position of the entity
	 * @param y
	 * 			The y position of the entity
	 */
	public void setOnMap(IEntity entity, int x, int y) {
		if (x >= 0 && x < this.width && y >= 0 && y < this.height) {
			map[y][x] = entity;
		}
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
