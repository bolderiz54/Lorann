package model;

import java.util.Observable;
import java.util.Observer;

/**
 * This class describe how to use a map
 * 
 * @author vince
 * @version 1.0
 */
public class Map extends Observable {
	
	/**
	 * The map that the game use
	 */
	private IEntity[][] map;
	
	public Map(int width, int height) {
		map = new IEntity[height][width];
	}
	
	public IEntity getOnMap(int x, int y) {
		return map[y][x];
	}
	
	public void setOnMap(IEntity entity, int x, int y) {
		map[y][x] = entity;
	}
	
	/**
     * Sets the mobile has changed.
     */
    @SuppressWarnings("deprecation")
	public final void setMobileHasChanged() {
        this.setChanged();
        this.notifyObservers();
    }
    
    @SuppressWarnings("deprecation")
	@Override
    public void addObserver(Observer observer) {
    	super.addObserver(observer);
    }

}
