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
    * remove the squares
    */
   public void removeSquares();
    
   /**
    * remove the pawns
    */
   public void removePawns();

   /**
    * remove a pawn 
    * @param pawn
    */
   public void removePawn(IPawn pawn);

   public void displayMessage(String message);
    
}
