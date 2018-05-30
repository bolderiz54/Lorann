package model;

import java.sql.SQLException;
import java.util.List;

/**
 * <h1>The Interface IModel.</h1>
 *
 * @author Hugo
 * @version 1.0
 */
public interface IModel {

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
    * 
    * @return all the entity in the map
    */
   public IEntity[][] getMap();
   
   /**
    * get the Width of the map
    * @return the size of the width (int)
    */
   public int getWidth();
   
   /**
    * set the width
    * @param Width
    */
   private void setWidth(int width);
   
   /**
    * get the height of the map
    * @return the size of the height
    */
   public int getHeight();
  
   /**
    * set the height of the map
    * @param height
    */
   private void setHeight(int height);
   
   /**
    * get the player
    */
   public Player getPlayer();
   
   /**
    *  This is to get a Monster
    * @param monsterNumber
    * @return the number of the monster
    */
   public Monster getMonster(int monsterNumber);
   
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
    * Generate the spell
    */
   public void generateSpell();
   
   /**
    * Destroy the spell
    */
   public void destroySpell();
}
