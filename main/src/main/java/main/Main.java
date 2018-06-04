package main;

import java.sql.SQLException;

import controller.ControllerFacade;
import model.ModelFacade;
import model.dao.DAO;
import view.ViewFacade;

/**
 * <h1>The Class Main.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public abstract class Main {

    /**
     * The main method.
     *
     * @param args
     *            the arguments
     * @throws InterruptedException 
     */
    public static void main(final String[] args) throws InterruptedException {
    	/*final ModelFacade model = new ModelFacade(20, 12);
    	final ViewFacade view = new ViewFacade(model);
        final ControllerFacade controller = new ControllerFacade(view, model);

        controller.start();*/
    	
    	try {
			DAO.loadLevel(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }

}