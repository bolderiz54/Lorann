package controller;

import java.sql.SQLException;
import java.util.List;

import model.Example;
import model.IModel;
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
 private Interact interact;
 
 /**
  * PUT HERE THE COMMENT
  * @param view
  * @param model
  */
 	public ControllerFacade(IView view, IModel model) {
 	
 	}
 	
 	private Order getOrder() {
 		
 	}
 
}
