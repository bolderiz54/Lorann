package model;

/**
 * <h1>The interface IScore.</h1>
 * 
 * @author Hugo
 * @version 1.0
 */

public interface IScore {
	
	/**
	 * get the score
	 * @return int
	 * 			the score
	 */
	public int getScore();
	
	/**
	 * calculate and add the score
	 * @param points
	 * 			The sum of points just earned
	 */
	public void addScore(int points);
	
	/**
	 * set the score 
	 * @param points
	 * 			The sum of points the score has
	 */
	public void setScore(int points);
	
}
