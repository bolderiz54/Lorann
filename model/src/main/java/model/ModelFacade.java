package model;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

import model.dao.DAO;
import model.dao.LoadedElement;

/**
 * <h1>The Class ModelFacade provides a facade of the Model component.</h1>
 *
 * @author Hugo
 * @version 1.0
 */
@SuppressWarnings({ "unused", "deprecation" })
public final class ModelFacade implements IModel {
	
	/**
	 * The number of the level which will be loaded
	 */
	private int levelNumber = 1;
	
	/**
	 * The level loaded from the database
	 */
	private String[][] loadedLevel;
	
	/**
	 * The pawns in the loaded level from the database
	 */
	private ArrayList<ILoadedElement> pawnsLoaded;
	
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
     * @param width
     * 			The map's width
     * @param height
     * 			The map's height
     */
    public ModelFacade(final int width, final int height) {
        score = new Score();
        factory = new Factory();
        this.width = width;
        this.height = height;
        this.map = (ILorannMap) new LorannMap(this.width, this.height);
        this.pawnsLoaded = new ArrayList<ILoadedElement>();
        
        for (int y = 0; y < this.getHeight(); y++) {
        	for (int x = 0; x < this.getHeight(); x++) {
            	this.setOnMap(EntityType.ENT_GROUND, x, y);
            }
        }
    }

	@Override
	public int getScore() {
		return this.score.getScore();
	}

	@Override
	public void addScore(int points) {
		this.score.addScore(points);
		
	}

	@Override
	public void setScore(int points) {
		this.score.setScore(points);
	}

	/**
	 * Load the level thank to the database
	 * @param level
	 * 			The number of the level
	 * @return boolean
	 * 			True if the load happened correctly
	 */
	public boolean loadLevel(int level) {
		List<ILoadedElement> AllElements = new ArrayList<ILoadedElement>();
		
		this.unloadLevel();
		
		this.loadedLevel = new String[this.getHeight()][this.getWidth()];
		
		for (int y = 0; y < this.height; y++) {
			for (int x = 0; x < this.width; x++) {
				this.loadedLevel[y][x] = "ground";
			}
		}
		
		/*
		
		BufferedReader buffer;
		String line, entityName;
		int index, entityX = 0, entityY = 0;
		try {
			Runtime r = Runtime.getRuntime();
			Process p = r.exec("java -jar ../getLevel/getLevelBDD.jar");
			p.waitFor();
			p.destroy();
			buffer = new BufferedReader(new InputStreamReader(new FileInputStream("../lorannMap.csv")));
			line = buffer.readLine();
			while (line != null) {
				entityX = 0;
				entityY = 0;
				index = line.indexOf(";");
				entityName = line.substring(0, index);
				line = line.substring(index + 1);
				index = line.indexOf(";");
				entityX = Integer.parseInt(line.substring(0, index));
				entityY = Integer.parseInt(line.substring(index + 1));
				AllElements.add(new LoadedElement(entityName, entityX, entityY));
				line = buffer.readLine();
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
			return false;
		} catch (IOException e2) {
			e2.printStackTrace();
			return false;
		} catch (InterruptedException e3) {
			e3.printStackTrace();
			return false;
		}
		
		*/
		/*
		
		for (int y = 0; y < this.height; y++) {
			for (int x = 0; x < this.width; x++) {
				if (x == 0 || x == this.width - 1 || y == 0 || y == this.height - 1) {
					this.loadedLevel[y][x] = "bone";
				}
			}
		}
		
		this.loadedLevel[6][10] = "purse";
		this.loadedLevel[5][1] = "gate_c";
		this.loadedLevel[7][18] = "crystal";
		
		this.pawnsLoaded.add(new LoadedElement("lorann", 5, 5));
		this.pawnsLoaded.add(new LoadedElement("rook", 10, 6));
		//this.pawnsLoaded.add(new LoadedElement("bishop", 11, 7));
		this.pawnsLoaded.add(new LoadedElement("wheel", 12, 5));
		//this.pawnsLoaded.add(new LoadedElement("stalker", 19, 10));
		
		*/
		/**/
		
		try {
			AllElements = DAO.loadLevel(level);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("error");
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error");
			return false;
		}
		
		/**/
		
		for (ILoadedElement element : AllElements) {
			switch (element.getName()) {
			case "lorann":
			case "rook":
			case "bishop":
			case "wheel":
			case "stalker":
				this.pawnsLoaded.add(element);
				break;
			default:
				if (element.getPosition().x >= 0 && element.getPosition().x < this.getWidth() &&
						element.getPosition().y >= 0 && element.getPosition().y < this.getHeight()) {
					this.loadedLevel[element.getPosition().y][element.getPosition().x] = element.getName();
				}
				break;
			}
		}
		
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
					this.setOnMap(EntityType.ENT_BONE_V, x, y);
					break;
				case "bone_h" :
					this.setOnMap(EntityType.ENT_BONE_H, x, y);
					break;
				case "bone" :
					this.setOnMap(EntityType.ENT_BONE, x, y);
					break;
				case "crystal" :
					this.setOnMap(EntityType.ENT_CRYSTAL, x, y);
					break;
				case "gate_c" :
					this.setOnMap(EntityType.ENT_GATE_C, x, y);
					break;
				case "gate_o" :
					this.setOnMap(EntityType.ENT_GATE_O, x, y);
					break;
				case "purse" :
					this.setOnMap(EntityType.ENT_PURSE, x, y);
					break;
				case "ground" :
				default :
					this.setOnMap(EntityType.ENT_GROUND, x, y);
					break;
				}
			}
		}
		
		for (ILoadedElement element : this.pawnsLoaded) {
			
			switch (element.getName()) {
			case "lorann":
				this.getPlayer().setPosition(new Point(element.getPosition()));
				this.getPlayer().reserruct();
				break;
			case "rook":
				this.getMonster(0).setPosition(new Point(element.getPosition()));
				this.getMonster(0).reserruct();
				break;
			case "bishop":
				this.getMonster(1).setPosition(new Point(element.getPosition()));
				this.getMonster(1).reserruct();
				break;
			case "wheel":
				this.getMonster(2).setPosition(new Point(element.getPosition()));
				this.getMonster(2).reserruct();
				break;
			case "stalker":
				this.getMonster(3).setPosition(new Point(element.getPosition()));
				this.getMonster(3).reserruct();
				break;
			default:
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

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public void setWidth(int width) {
		this.width = width;
	}

	@Override
	public int getHeight() {
		return height;
	}

	@Override
	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public IPlayer getPlayer() {
		return this.factory.getPlayer();
	}

	@Override
	public IMonster getMonster(int monsterNumber) {
		return this.factory.getMonster(monsterNumber);
	}
	
	@Override
	public IEntity getEntity(EntityType entityType) {
		return this.factory.getEntity(entityType);
	}

	@Override
	public boolean isSpellExist() {
		return this.factory.isSpellExist();
	}

	@Override
	public ISpell getSpell() {
		return this.factory.getSpell();
	}

	@Override
	public IEntity getOnMap(int x, int y) {
		return this.getLorannMap().getOnMap(x, y);
	}
	
	@Override
	public void setOnMap(EntityType entity, int x, int y) {
		this.getLorannMap().setOnMap(this.factory.getEntity(entity), x, y);
	}

	@Override
	public void generateSpell() {
		this.factory.generateSpell();
	}

	@Override
	public void destroySpell() {
		this.factory.destroySpell();
	}

	@Override
	public void removeSquare(int x, int y) {
		this.setOnMap(EntityType.ENT_GROUND, x, y);
	}

	@Override
	public void addObserver(Observer observer) {
		this.getLorannMap().addObserver(observer);
	}

}
