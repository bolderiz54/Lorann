package controller;

import model.IModel;
import view.IView;

/**
 * <h1>The Interface IController.</h1>
 * 
 * @author Hugo
 * @version 1.0
 */
public interface IController {
	
	/**
	 * The method start is to start the game
	 * @throws InterruptedException 
	 */
	public void start() throws InterruptedException;
	
	/** 
	 * The method getView get the view sent to the controller
	 * @return IView
	 * The view that the controller has
	 */
	public IView getView();
	
	/** 
	 * The method getModel get the model sent to the controller
	 * @return IModel
	 * The model that the controller has
	 */
	public IModel getModel();

}
