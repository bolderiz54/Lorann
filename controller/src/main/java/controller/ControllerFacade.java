package controller;

import model.IModel;
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
 private Order order;
 private IInteract interact;
 
 /**
  * PUT HERE THE COMMENT
  * @param view
  * @param model
  */
 	public ControllerFacade(IView view, IModel model) {
 	
 	}
 	
 	private Order getOrder() {
		return order;
 		
 	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public IView getView() {
		return view;
		
	}

	@Override
	public IModel getModel() {
		return model;
		
	}
 
}
