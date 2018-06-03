package model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Observer;

/**
 * <h1>The Class ModelFacade provides a facade of the Model component.</h1>
 *
 * @author Hugo
 * @version 1.0
 */
public final class ModelFacade implements IModel {
	
	/**
	 * The number of the level which will be loaded
	 */
	@SuppressWarnings("unused")
	private int levelNumber = 1;
	
	/**
	 * The level loaded from the database
	 */
	private String[][] loadedLevel;
	
	/**
	 * The pawns in the loaded level from the database
	 */
	private ArrayList<LoadedElement> pawnsLoaded;
	
	/**
	 * The map that the game use
	 */
	private ILorannMap map;
	
	/**
	 * the width of the map
	 */
	private int width;
	
	/**
	 * the height of the map
	 */
	private int height;
	
	/**
	 * the score obtained
	 */
	private Score score;
	
	/**
	 * the factory that is use to generate entities
	 */
	private Factory factory;
	
    /**
     * Instantiates a new model facade.
     * 
     * @param map's width
     * @param map's height
     */
    public ModelFacade(final int width, final int height) {
        score = new Score();
        factory = new Factory();
        this.width = width;
        this.height = height;
        this.map = (ILorannMap) new LorannMap(this.width, this.height);
        this.pawnsLoaded = new ArrayList<LoadedElement>();
    }

    /**
	 * get the score
	 * @return the score
	 */
	@Override
	public int getScore() {
		return this.score.getScore();
	}

	/**
	 * calculate and add the score
	 * @param points
	 */
	@Override
	public void addScore(int points) {
		this.score.addScore(points);
		
	}

	/**
	 * set the score 
	 * @param points
	 */
	@Override
	public void setScore(int points) {
		this.score.setScore(points);
	}

	/**
	 * 
	 * @param level (int)
	 * @return true if the entity is alive
	 */
	public boolean loadLevel(int level) {
		this.unloadLevel();
		
		this.loadedLevel = new String[this.getHeight()][this.getWidth()];
		
		for (int y = 0; y < this.height; y++) {
			for (int x = 0; x < this.width; x++) {
				this.loadedLevel[y][x] = "ground";
			}
		}
		
		for (int y = 0; y < this.height; y++) {
			for (int x = 0; x < this.width; x++) {
				if (x == 0 || x == this.width - 1 || y == 0 || y == this.height - 1) {
					this.loadedLevel[y][x] = "bone";
				}
			}
		}
		
		this.pawnsLoaded.add(new LoadedElement("lorann", 5, 5));
		this.pawnsLoaded.add(new LoadedElement("rook", 10, 6));
		this.pawnsLoaded.add(new LoadedElement("bishop", 11, 7));
		this.pawnsLoaded.add(new LoadedElement("wheel", 12, 5));
		this.pawnsLoaded.add(new LoadedElement("stalker", 19, 10));
		
		//add DB call
		
		//ArrayList<LoadedElement> AllElemnts = ...
		
		/*ArrayList<LoadedElement> AllElements = new ArrayList<LoadedElement>();
		
		for (LoadedElement element : AllElements) {
			switch (element.name) {
			case "lorann":
			case "rook":
			case "bishop":
			case "wheel":
			case "stalker":
				this.pawnsLoaded.add(element);
				break;
			default:
				if (element.position.x >= 0 && element.position.x < this.getWidth() &&
						element.position.y >= 0 && element.position.y < this.getHeight()) {
					this.loadedLevel[element.position.y][element.position.x] = element.name;
				}
			}
		}*/
		
		this.resetLevel();
		
		return true;
	}

	/**
	 * Reset the level
	 */
	@Override
	public void resetLevel() {
		this.factory.getPlayer().die();
		for (int i = 0; i < 4; i++) {
			this.factory.getMonster(i).die();
		}
		
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				switch (this.loadedLevel[y][x]) {
				case "bone_v" :
					this.getLorannMap().setOnMap(this.factory.getEntity(EntityType.ENT_BONE_V), x, y);
					break;
				case "bone_h" :
					this.getLorannMap().setOnMap(this.factory.getEntity(EntityType.ENT_BONE_H), x, y);
					break;
				case "bone" :
					this.getLorannMap().setOnMap(this.factory.getEntity(EntityType.ENT_BONE), x, y);
					break;
				case "crystal" :
					this.getLorannMap().setOnMap(this.factory.getEntity(EntityType.ENT_CRYSTAL), x, y);
					break;
				case "gate_c" :
					this.getLorannMap().setOnMap(this.factory.getEntity(EntityType.ENT_GATE_C), x, y);
					break;
				case "gate_o" :
					this.getLorannMap().setOnMap(this.factory.getEntity(EntityType.ENT_GATE_O), x, y);
					break;
				case "purse" :
					this.getLorannMap().setOnMap(this.factory.getEntity(EntityType.ENT_PURSE), x, y);
					break;
				case "ground" :
				default :
					this.getLorannMap().setOnMap(this.factory.getEntity(EntityType.ENT_GROUND), x, y);
					break;
				}
			}
		}
		
		for (LoadedElement element : this.pawnsLoaded) {
			switch (element.name) {
			case "lorann":
				this.factory.getPlayer().setPosition(new Point(element.position));
				this.factory.getPlayer().reserruct();
				break;
			case "rook":
				this.factory.getMonster(0).setPosition(new Point(element.position));
				this.factory.getMonster(0).reserruct();
				break;
			case "bishop":
				this.factory.getMonster(1).setPosition(new Point(element.position));
				this.factory.getMonster(1).reserruct();
				break;
			case "wheel":
				this.factory.getMonster(2).setPosition(new Point(element.position));
				this.factory.getMonster(2).reserruct();
				break;
			case "stalker":
				this.factory.getMonster(3).setPosition(new Point(element.position));
				this.factory.getMonster(3).reserruct();
				break;
			}
		}
	}

	/**
	 * Unload the level
     */
	@Override
	public void unloadLevel() {
		this.loadedLevel = null;
		this.pawnsLoaded.clear();
	}

	@Override
	public ILorannMap getLorannMap() {
		return this.map;
	}

	/**
	 * get the Width of the map
     * @return the size of the width (int)
	 */
	@Override
	public int getWidth() {
		return width;
	}

	/**
	 * set the width
	 * @param width
	 */
	@Override
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * get the height
	 * @return the size of the height (int)
	 */
	@Override
	public int getHeight() {
		return height;
	}

	/**
	 * set the height
	 * @param height
	 */
	@Override
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * get the player
	 */
	@Override
	public IPlayer getPlayer() {
		return this.factory.getPlayer();
	}

	/**
	 * This is to get a Monster
     * @param monsterNumber
     * @return the number of the monster
	 */
	@Override
	public IMonster getMonster(int monsterNumber) {
		return this.factory.getMonster(monsterNumber);
	}

	/**
	 * The method check if the spell exist or not 
     * @return true if the spell exist
	 */
	@Override
	public boolean isSpellExist() {
		return this.factory.isSpellExist();
	}

	/**
	 * get the spell
	 */
	@Override
	public ISpell getSpell() {
		return this.factory.getSpell();
	}

	/**
	 * get an Entity
     * @param x  The movements of the Entity
     * @param y The movements of the Entity
     * @return  an entity at the right coordinates
	 */
	@Override
	public IEntity getOnMap(int x, int y) {
		return this.getLorannMap().getOnMap(x, y);
	}
	
	/**
	 * set an Entity on the map
	 * @param entity
	 * @param x
	 * @param y
	 */
	@Override
	public void setOnMap(EntityType entity, int x, int y) {
		this.getLorannMap().setOnMap(this.factory.getEntity(entity), x, y);
	}

	/**
	 * generate the spell
	 */
	@Override
	public void generateSpell() {
		this.factory.generateSpell();
	}
	/**
	 * destroy the spell
	 */
	@Override
	public void destroySpell() {
		this.factory.destroySpell();
	}

	/**
	 * remove a square from the map
	 */
	@Override
	public void removeSquare(int x, int y) {
		this.getLorannMap().setOnMap(this.factory.getEntity(EntityType.ENT_GROUND), x, y);
	}

	/**
	 * Add an observer to the map
	 */
	@Override
	public void addObserver(Observer observer) {
		this.getLorannMap().addObserver(observer);
	}

}
