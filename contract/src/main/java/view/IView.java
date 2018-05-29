package view;

/**
 * <h1>The Interface IView.</h1>
 *
 * @author Hugo
 * @version 1.0
 */
public interface IView {

	/**
	 * Show the map
	 * @param model
	 */
   public void showMap(IModel model);
    
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
    
}
