package model;

import java.io.IOException;
import java.util.Observer;

/**
 * <h1>The Interface IModel.</h1>
 *
 * @author Hugo
 * @version 1.1
 */
@SuppressWarnings("deprecation")
public interface IModel extends IScore {

/**
 * Load the level from the database according to the level number
 * @param level
 * 			The number of the level we want to load
 * @return boolean
 * 			true if the entity is alive
 * @throws IOException 
 */
   public boolean loadLevel(int level);
   
   /**
    * Reset the map to the loaded level
    */
   public void resetLevel();
   
   /**
    * Unload the loaded level
    */
   public void unloadLevel();
   
   /**
    * Get the map
    * @return ILorannMap
    * 			all the entity in the map
    */
   public ILorannMap getLorannMap();
   
   /**
    * Get the width of the map
    * @return int
    * 			the width of the map
    */
   public int getWidth();
   
   /**
    * Set the width
    * @param width
    * 			the width of the map
    */
   public void setWidth(int width);
   
   /**
    * Get the height of the map
    * @return int
    * 			the size of the height
    */
   public int getHeight();
  
   /**
    * Set the height of the map
    * @param height
    * 			the size of the height
    */
   public void setHeight(int height);
   
   /**
    * get the player
    * @return IPlayer
    * 			the character that the player control
    */
   public IPlayer getPlayer();
   
   /**
    * This is to get a Monster
    * @param monsterNumber
    * 			The id of the monster (0-3)
    * @return IMonster
    * 			The monster
    */
   public IMonster getMonster(int monsterNumber);
   
   /**
	 * get the type of the entity
	 * @param entityType
	 * 			The type of the entity
	 * @return the entity
	 * 			The entity
	 */
   public IEntity getEntity(EntityType entityType);
   
   /**
    * The method check if the spell exist or not 
    * @return boolean
    * 			true if the spell exist
    */
   public boolean isSpellExist();
   
   /**
    * The method get the spell
    * @return ISpell
    * 			The spell
    */
   public ISpell getSpell();
   
   /**
    * get an Entity
    * @param x
    * 			The x position of the Entity
    * @param y
    * 			The y position of the Entity
    * @return IEntity
    * 			the entity at the coordinates
    */
   public IEntity getOnMap(int x, int y);
   
   /**
    * set an Entity on the map
    * @param entity
    * 			The type of the entity
    * @param x
    * 			The x position of the Entity
    * @param y
    * 			The y position of the Entity
    */
   public void setOnMap(EntityType entity, int x, int y);
   
   /**
    * Generate the spell
    */
   public void generateSpell();
   
   /**
    * Destroy the spell
    */
   public void destroySpell();
   
   /**
    * remove an entity from the map
    * @param x
    * 			The x position of the Entity
    * @param y
    * 			The y position of the Entity
    */
   public void removeSquare(int x, int y);
   
   /**
    * Add an observer to the map
    * @param observer
    * 			The observer
    */
   public void addObserver(Observer observer);
   
}
