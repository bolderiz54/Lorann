package main;

import java.awt.Point;
import java.sql.SQLException;
import java.util.ArrayList;

import controller.ControllerFacade;
import model.ILoadedElement;
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
    	final ModelFacade model = new ModelFacade(20, 12);
    	final ViewFacade view = new ViewFacade(model);
        final ControllerFacade controller = new ControllerFacade(view, model);

        controller.start();
    	/*ArrayList<ILoadedElement> l = new ArrayList<ILoadedElement>();
    	Point p = new Point(0, 0);
		try {
			p = DAO.test();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	System.out.println(p.x+","+p.y);
    	try {
			l = DAO.loadLevel(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	for (ILoadedElement element : l) {
    		System.out.println(element.getName()+","+element.getPosition().x+","+element.getPosition().y);
    	}*/
    }

}