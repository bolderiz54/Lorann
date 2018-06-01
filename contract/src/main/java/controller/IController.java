package controller;

/**
 * <h1>The Interface IController.</h1>
 * 
 * @author Hugo
 * @version 1.0
 */
public interface IController {
	
	/**
	 * The method start is to start the game
	 */
	public void start();
	
	/** 
	 * The method getView get the view sent to the controller
	 */
	public void getView();
	
	/** 
	 * The method getModel get the model sent to the controller
	 */
	public void getModel();

}
