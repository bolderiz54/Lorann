package view;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import model.IModel;
import showboard.BoardFrame;
import showboard.IPawn;
import showboard.ISquare;

/**
 * <h1>The Class ViewFacade provides a facade of the View component.</h1>
 *
 * @author Jean-Aymeric DIET and Benjamin ZANARDO
 * @version 1.1
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
        this.view = new Rectangle(0, 0, this.model.getWidth(), this.model.getHeight());
        interact = new Interact();
        SwingUtilities.invokeLater(this);
    }

    /*
     * (non-Javadoc)
     * @see view.IView#displayMessage(java.lang.String)
     */
    @Override
    public final void displayMessage(final String message) {
        JOptionPane.showMessageDialog(null, message);
    }
    
    /**
     * This method execute the removePawns method in boardframe object
     */
    public void removePawns() {
    	this.boardframe.removePawns();
    }
    
    /**
     * This method execute the removePawn method in boardframe object
     * @param pawn
     * 			the pawn
     */
    public void removePawn(IPawn pawn) {
    	this.boardframe.removePawn(pawn);
    }
    
    /**
     * This metthod execute the addPawn method in boardframe object
     * @param pawn
     * 			the pawn
     */
    public void addPawn(IPawn pawn) {
    	this.boardframe.addPawn(pawn);
    }
    
    /**
     * Collect the player's interactions
     */
    public IInteract getInteract() {
    	return interact;
    }
    
    /**
     * Defined frame's parameters :
     * - map's dimension with setDimension
     * - the game panel's dimension and his size with setDisplayFrame
     * - The frame's size with setSize
     */
    public final void run() {
    	boardframe.setDimension(new Dimension(this.model.getWidth(), this.model.getHeight()));
    	boardframe.setDisplayFrame(this.view);
    	boardframe.setSize(this.view.width * squareSize, this.view.height * squareSize);
    	
    	for (int y = 0; y < this.model.getHeight(); y++) {
    		for (int x = 0; x < this.model.getWidth(); x++) {
        		boardframe.addSquare((ISquare) this.model.getOnMap(x, y), x, y);
        	}
    	}
    	
    	boardframe.addKeyListener((KeyListener) interact);
    	this.model.addObserver(this.boardframe.getObserver());
    	boardframe.setFocusable(true);
    	boardframe.requestFocus();
    	boardframe.setVisible(true);
    }


}
