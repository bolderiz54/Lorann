package view;

import showboard.IPawn;

/**
 * <h1>The Interface IView.</h1>
 *
 * @author Hugo
 * @version 1.0
 */
public interface IView {
    
   /**
    * remove the pawns
    */
   public void removePawns();

   /**
    * remove a pawn 
    * @param pawn
    * 			The pawn to remove from the view
    */
   public void removePawn(IPawn pawn);
   
   /**
    * add a Pawn
    * @param pawn
    * 			The pawn to add to the view
    */
   public void addPawn(IPawn pawn);

   /**
    * Display a message
    * @param message
    * 			The message to display
    */
   public void displayMessage(String message);
   
   /**
    * Get interact
    * @return IInteract
    * 			The instance of Interact contain in the view
    */
   public IInteract getInteract();
   
   /**
    * update the observer
    */
   public void update();
    
}
