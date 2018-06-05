package model;

import java.util.Observer;

@SuppressWarnings("deprecation")
/**
 * <h1>The interface ILorannMap</h1>
 * @author Vincent Linck
 * @version 1.0
 */
public interface ILorannMap {

	/**
	 * Get an entity on the map
	 * @param x
	 * 			the x coordinate of the entity
	 * @param y
	 * 			the y coordinate of the entity
	 * @return IEntity
	 * 			The entity on the map at the coordinates
	 */
	public IEntity getOnMap(int x, int y);
	
	/**
	 * Set an entity on the map
	 * @param entity
	 * 			The entity to put on the map
	 * @param x
	 * 			the x coordinate of the entity
	 * @param y
	 * 			the y coordinate of the entity
	 */
	public void setOnMap(IEntity entity, int x, int y);
	
	/**
     * Notify the observer that mobile has changed
     */
	public void setMobileHasChanged();
	
	/**
	 * Add an observer to the observable
	 * @param observer
	 * 			The observer
	 */
	public void addObserver(Observer observer);
	
}
