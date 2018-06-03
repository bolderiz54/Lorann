package controller;

import model.IModel;
import showboard.IPawn;
import view.IInteract;
import view.IView;

/**
 * <h1>The Class ControllerFacade provides a facade of the Controller component.</h1>
 *
 * @author 
 * @version 1.0
 */
public class ControllerFacade implements IController {

 private IView view;
 private IModel model;
 private CollisionManager collisionManager;
 private Clock clock;
 private Order order = Order.ORD_NONE;
 private IInteract interact;
 private static final int keyLeft = 37;
 private static final int keyRight = 39;
 private static final int keyUp = 38;
 private static final int keyDown = 40;
 
 /**
  * PUT HERE THE COMMENT
  * @param view
  * @param model
  */
 	public ControllerFacade(IView view, IModel model) {
 		this.view = view;
 		this.model = model;
 		this.collisionManager = new CollisionManager(this.getModel());
 		}
 	
 	@SuppressWarnings("unused")
	private Order getOrder() {
		return order;
 		
 	}

 	/**
 	 * method that allow us to move Lorann with the collisions
 	 */
	@Override
	public void start() throws InterruptedException {
		this.getModel().loadLevel(0);
		
		if (this.getModel().getPlayer().isAlive()) {
			this.getView().addPawn((IPawn) this.getModel().getPlayer());
		}
		for (int i = 0; i < 4; i++) {
			if (this.getModel().getMonster(i).isAlive()) {
				this.getView().addPawn((IPawn) this.getModel().getMonster(i));
			}
		}
		
		while(true) {
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
				default:
					break;
				}
			}
			
			this.getModel().getMonster(0).move((IPawn) this.getModel().getPlayer(), this.getModel());
			this.getModel().getMonster(1).move((IPawn) this.getModel().getPlayer(), this.getModel());
			this.getModel().getMonster(2).move((IPawn) this.getModel().getPlayer(), this.getModel());
			this.getModel().getMonster(3).move((IPawn) this.getModel().getPlayer(), this.getModel());
			
			this.getModel().getLorannMap().setMobileHasChanged();
			Thread.sleep(100);
		}
	}

	@Override
	public IView getView() {
		return view;
		
	}

	@Override
	public IModel getModel() {
		return model;
		
	}
	
	/**
	 * method that associate the key pressed with a movement
	 */
	private void interpretInteraction() {
		if (this.getView().getInteract().isKeyPressed(keyUp)) {
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

}
