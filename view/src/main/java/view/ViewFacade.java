package view;

import javax.swing.JOptionPane;

import model.IModel;

/**
 * <h1>The Class ViewFacade provides a facade of the View component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public class ViewFacade implements IView {
	
	private BoardFrame boardframe;
	
    /**
     * Instantiates a new view facade.
     */
    public ViewFacade() {
        super();
    }

    /*
     * (non-Javadoc)
     * @see view.IView#displayMessage(java.lang.String)
     */
    @Override
    public final void displayMessage(final String message) {
        JOptionPane.showMessageDialog(null, message);
    }
    
    public void showMap(IModel model) {
    	
    }
    
    public void removeSquares() {
    	
    }
    
    public void removePawns() {
    	
    }
    
    public void removePawn(IPawn pawn) {
    	
    }
    
    public final void run() {
    	
    }

}
