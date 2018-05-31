package model;

import model.AIDesignPatter.*;

/**
 * The class Factory instantiate 
 * @author Hugo
 *
 */
public class Factory {

	private Player player;
	private Monster rook;
	private Monster bishop;
	private Monster wheel;
	private Monster stalker;
	private Spell spell;
	private Entity bone;
	private Entity ground;
	private Entity purse;
	private Entity gate_o;
	private Entity gate_c;
	private Entity crystal_ball;
	private Entity horizontal_bone;
	private Entity vertical_bone;
	/**
	 * instantiate
	 */
	public Factory() {
		player = new Player();
		rook = new Monster("rook", new Rook());
		bishop = new Monster("bishop", new Bishop());
		wheel = new Monster("wheel", new Wheel());
		stalker = new Monster("stalker", new Stalker());
		spell = null;
		bone = new Entity("bone", Permeability.BLOCKING);
		ground = new Entity("ground", Permeability.PENETRABLE);
		purse = new Entity("purse", Permeability.COLLECTABLE);
		gate_o = new Entity("gate_o", Permeability.PENETRABLE);
		gate_c = new Entity("gate_c", Permeability.KILLING);
		crystal_ball = new Entity("crystall_ball", Permeability.COLLECTABLE);
		horizontal_bone = new Entity("horizontal_bone", Permeability.BLOCKING);
		vertical_bone = new Entity ("vertical_bone", Permeability.BLOCKING);
		
		
	}
	
	public IEntity getEntity(EntityType entityType) {
		return ent
	}
	
	public IMonster getMonster(int monsterNumber) {
		switch (monsterNumber) {
		
		case 1 : return this.rook;
		
		case 2 : return this.bishop;
		
		case 3 : return this.wheel;
		
		case 4 : return this.stalker;
		
		default : return null;
		}
		
	}
	
	public IPlayer getPlayer() {
		return player;
	}
	
	public void generateSpell() {
		if(!isSpellExist()) {
			spell = new Spell();
			spell.setPosition(player.getPosition());
		}
		
	}
	
	public boolean isSpellExist() {
		if(this.spell == null) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public ISpell getSpell() {
		return this.spell;
	}
	
	public void destroySpell() {
		this.spell = null;
	}
	
}
