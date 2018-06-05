package controller;

import model.EntityType;
import model.IModel;
import showboard.IPawn;
import view.IInteract;
import view.IView;

/**
 * <h1>The Class ControllerFacade</h1>
 * It provides a facade of the Controller component.
 *
 * @author gauthier
 * @version 1.0
 */
public class ControllerFacade implements IController {

	/**
	 * The reference to the view
	 */
	private IView view;
	
	/**
	 * The reference to the model
	 */
	private IModel model;
	
	/**
	 * The object collisionManager
	 */
	private CollisionManager collisionManager;
	
	/**
	 * The object clock
	 */
	private Clock clock;
	
	/**
	 * The enum order
	 */
	private Order order = Order.ORD_NONE;
	
	/**
	 * The key code for the left key
	 */
	private static final int keyLeft = 37;
	
	/**
	 * The key code for the right key
	 */
	private static final int keyRight = 39;
	
	/**
	 * The key code for the up key
	 */
	private static final int keyUp = 38;
	
	/**
	 * The key code for the down key
	 */
	private static final int keyDown = 40;
	
	/**
	 * The key code for the space bar
	 */
	private static final int spaceBar = 32;
	
	/**
	 * A boolean to tell if the player has won or not
	 */
	private static boolean win = false;
 
	/**
	 * This method get the view, the model and the collisionManager
	 * @param view
	 * 			The reference to the view
	 * @param model
	 * 			The reference to the model
	 */
	public ControllerFacade(IView view, IModel model) {
 		this.view = view;
 		this.model = model;
 		this.collisionManager = new CollisionManager(this.getModel(), this.getView());
 		this.clock = new Clock(10);
 		}
 	
	/**
	 * Get the order
	 * @return Order
	 * 			The order request by the player
	 */
	@SuppressWarnings("unused")
	private Order getOrder() {
		return order;
	}

	/**
	 * method that allow us to move Lorann with the collisions
	 * we're doing a test in order to know if the monster or the player is alive or not
	 * then we're using our wallCollision method in order to move the player in every case of key pressed
	 * after that, we're using crossCollision in order to manage the collision between player monster and spell
	 * @throws InterruptedException
	 */
	@Override
	public void start() throws InterruptedException {
		boolean cast = false;
		
		this.getModel().loadLevel(2);
		this.getView().update();
		
		if (this.getModel().getPlayer().isAlive()) {
			this.getView().addPawn((IPawn) this.getModel().getPlayer());
		}
		for (int i = 0; i < 4; i++) {
			if (this.getModel().getMonster(i).isAlive()) {
				this.getView().addPawn((IPawn) this.getModel().getMonster(i));
			}
		}
		
		while(this.getModel().getPlayer().isAlive() && !win) {
			cast = false;
			
			this.interpretInteraction();
			
			if (this.collisionManager.wallCollision(this.getModel().getPlayer(), this.order)) {
				switch(this.order) {
				case ORD_M_UP:
					this.getModel().getPlayer().move(0, -1);
					break;
				case ORD_M_DOWN:
					this.getModel().getPlayer().move(0, 1);
					break;
				case ORD_M_LEFT:
					this.getModel().getPlayer().move(-1, 0);
					break;
				case ORD_M_RIGHT:
					this.getModel().getPlayer().move(1, 0);
					break;
				case ORD_M_UP_L:
					this.getModel().getPlayer().move(-1, -1);
					break;
				case ORD_M_UP_R:
					this.getModel().getPlayer().move(1, -1);
					break;
				case ORD_M_DOWN_L:
					this.getModel().getPlayer().move(-1, 1);
					break;
				case ORD_M_DOWN_R:
					this.getModel().getPlayer().move(1, 1);
					break;
				case ORD_CAST_SPELL:
					if (!this.getModel().isSpellExist()) {
						this.getModel().generateSpell();
						this.getView().addPawn((IPawn) this.getModel().getSpell());
						cast = true;
					}
					else if (!this.getModel().getSpell().isRepelled()) {
						this.getModel().getSpell().reverse();
					}
					break;
				default:
					break;
				}
			}
			for (int i = 0; i < 4; i++) {
				if (this.getModel().getMonster(i).isAlive()) {
					this.collisionManager.crossCollision((IPawn) this.getModel().getPlayer(), (IPawn) this.getModel().getMonster(i));
					this.getModel().getMonster(i).move((IPawn) this.getModel().getPlayer(), this.getModel());
					this.collisionManager.crossCollision((IPawn) this.getModel().getPlayer(), (IPawn) this.getModel().getMonster(i));
				}
			}
			
			
			if (this.getModel().isSpellExist()) {
				if (!cast) {
					this.collisionManager.crossCollision((IPawn) this.getModel().getSpell(), (IPawn) this.getModel().getPlayer());
				}
				for (int i = 0; i < 4 && this.getModel().isSpellExist(); i++) {
					if (this.getModel().getMonster(i).isAlive()) {
						this.collisionManager.crossCollision((IPawn) this.getModel().getSpell(), (IPawn) this.getModel().getMonster(i));
					}
				}
				if (this.getModel().isSpellExist()) {
					if (this.collisionManager.wallCollision(this.getModel().getSpell())) {
						this.getModel().getSpell().move();
					}
					else {
						this.getModel().getSpell().reverse();
						if (this.collisionManager.wallCollision(this.getModel().getSpell())) {
							this.getModel().getSpell().move();
						}
					}
					this.collisionManager.crossCollision((IPawn) this.getModel().getSpell(), (IPawn) this.getModel().getPlayer());
					for (int i = 0; i < 4 && this.getModel().isSpellExist(); i++) {
						if (this.getModel().getMonster(i).isAlive()) {
							this.collisionManager.crossCollision((IPawn) this.getModel().getSpell(), (IPawn) this.getModel().getMonster(i));
						}
					}
				}
			}
			
			/*for (int y = 0; y < this.getModel().getHeight(); y++) {
				for (int x = 0; x < this.getModel().getHeight(); x++) {
					System.out.print(this.getModel().getOnMap(x, y).getSprite().getImagePath()+", ");
				}
				System.out.println("");
			}*/
			this.getModel().getLorannMap().setMobileHasChanged();
			this.clock.sleep();
		}
		
		if (ControllerFacade.win) {
			this.getView().displayMessage("GAME OVER\nYou win with a score of "+this.getModel().getScore()+" points !\nCongratulations !!");
		} else {
			this.getView().displayMessage("GAME OVER\nYou lose with a score of "+this.getModel().getScore()+" points.\nTry again.");
		}
	}

	/**
	 * This method get the view
	 * @return IView
	 * 			The referred view
	 */
	@Override
	public IView getView() {
		return view;
		
	}
	
	/**
	 * this method get the model
	 * @return IModel
	 * 			The referred model
	 */
	@Override
	public IModel getModel() {
		return model;
		
	}
	
	/**
	 * This method associate a key pressed with an order that is in our enumeration order
	 */
	private void interpretInteraction() {
		if (this.getView().getInteract().isKeyPressed(spaceBar)) {
			this.order = Order.ORD_CAST_SPELL;
		}
		else if (this.getView().getInteract().isKeyPressed(keyUp)) {
			if (this.getView().getInteract().isKeyPressed(keyLeft)) {
				this.order = Order.ORD_M_UP_L;
			}
			else if (this.getView().getInteract().isKeyPressed(keyRight)) {
				this.order = Order.ORD_M_UP_R;
			}
			else {
				this.order = Order.ORD_M_UP;
			}
		}
		else if (this.getView().getInteract().isKeyPressed(keyDown)) {
			if (this.getView().getInteract().isKeyPressed(keyLeft)) {
				this.order = Order.ORD_M_DOWN_L;
			}
			else if (this.getView().getInteract().isKeyPressed(keyRight)) {
				this.order = Order.ORD_M_DOWN_R;
			}
			else {
				this.order = Order.ORD_M_DOWN;
			}
		}
		else if (this.getView().getInteract().isKeyPressed(keyLeft)) {
			this.order = Order.ORD_M_LEFT;
		}
		else if (this.getView().getInteract().isKeyPressed(keyRight)) {
			this.order = Order.ORD_M_RIGHT;
		}
		else {
			this.order = Order.ORD_NONE;
		}
	}
	
	/**
	 * Set if the player win
	 * @param win
	 * 			True to make the player win
	 */
	public static void setWin(boolean win) {
		ControllerFacade.win = win;
	}

}
