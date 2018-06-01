package model;

import java.util.Observer;

/**
 * <h1>The Interface IModel.</h1>
 *
 * @author Hugo
 * @version 1.1
 */
public interface IModel extends IScore {

/**
 * 
 * @param level (int)
 * @return true if the entity is alive
 */
   public boolean loadLevel(int level);
   
   /**
    * Reset the level
    */
   public void resetLevel();
   
   /**
    * Unload the level
    */
   public void unloadLevel();
   
   /**
    * get the map
    * @return all the entity in the map
    */
   public ILorannMap getLorannMap();
   
   /**
    * get the Width of the map
    * @return the size of the width (int)
    */
   public int getWidth();
   
   /**
    * set the width
    * @param Width
    */
   public void setWidth(int width);
   
   /**
    * get the height of the map
    * @return the size of the height
    */
   public int getHeight();
  
   /**
    * set the height of the map
    * @param height
    */
   public void setHeight(int height);
   
   /**
    * get the player
    */
   public IPlayer getPlayer();
   
   /**
    *  This is to get a Monster
    * @param monsterNumber
    * @return the number of the monster
    */
   public IMonster getMonster(int monsterNumber);
   
   /**
    * The method check if the spell exist or not 
    * @return true if the spell exist
    */
   public boolean isSpellExist();
   
   /**
    * The method get the spell
    * @return
    */
   public ISpell getSpell();
   
   /**
    *  get an Entity
    * @param x  The movements of the Entity
    * @param y The movements of the Entity
    * @return  an entity at the right coordinates
    */
   public IEntity getOnMap(int x, int y);
   
   /**
    * set an Entity on the map
    * @param entity
    * @param x
    * @param y
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
    * @param y
    */
   public void removeSquare(int x, int y);
   
   /**
    * Add an observer to the map
    * @param observer
    */
   public void addObserver(Observer observer);
   
}
