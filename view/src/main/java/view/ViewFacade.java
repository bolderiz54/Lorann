package view;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;
import model.IModel;
import showboard.BoardFrame;
import showboard.IPawn;

/**
 * <h1>The Class ViewFacade provides a facade of the View component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public class ViewFacade implements IView, Runnable {
	
	private BoardFrame boardframe;
	
	private Rectangle view;
	
	private static final int squareSize = 32;
	
	private IModel model;
	
	private IInteract interact;
    /**
     * Instantiates a new view facade.
     */
    public ViewFacade(IModel model) {
        boardframe = new BoardFrame("Lorann");
        this.model = model;
        new Rectangle(0,0, this.model.getWidth(), this.model.getHeight());
        interact = new Interact();
    }

    /*
     * (non-Javadoc)
     * @see view.IView#displayMessage(java.lang.String)
     */
    @Override
    public final void displayMessage(final String message) {
        JOptionPane.showMessageDialog(null, message);
    }
    
    public void removePawns() {
    	this.boardframe.removePawns();
    }
    
    public void removePawn(IPawn pawn) {
    	this.boardframe.removePawn(pawn);
    }
    
    public IInteract getInteract() {
    	return interact;
    }
    
    public final void run() {
    	boardframe.setDimension(new Dimension(this.model.getWidth(), this.model.getHeight()));
    	boardframe.setDisplayFrame(this.view);
    	boardframe.setSize(this.model.getWidth() * squareSize, this.model.getHeight() * squareSize);
    	
    	for (int y = 0; y < this.model.getHeight(); y++) {
    		for (int x = 0; x < this.model.getWidth(); x++) {
        		boardframe.addSquare(this.model.getOnMap(x, y), x, y);
        	}
    	}
    	//boardframe.addPawn(IPawn pawn);
    	/*
    	 * Envoie la touche appuyé grâce à KeyListener
    	 */
    	boardframe.addKeyListener((KeyListener) interact);
    	this.model.addObserver(this.boardframe.getObserver());
    	boardframe.setFocusable(true);
    	boardframe.requestFocus();
    	boardframe.setVisible(true);
    }


}
