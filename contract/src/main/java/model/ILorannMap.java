package model;

import java.util.Observer;

public interface ILorannMap {

	/**
	 * Get an entity on the map
	 * @param x
	 * @param y
	 * @return
	 */
	public IEntity getOnMap(int x, int y);
	
	/**
	 * Set an entity on the map
	 * @param entity
	 * @param x
	 * @param y
	 */
	public void setOnMap(IEntity entity, int x, int y);
	
	/**
     * Sets the mobile has changed.
     */
	public void setMobileHasChanged();
	
	public void addObserver(Observer observer);
	
}
