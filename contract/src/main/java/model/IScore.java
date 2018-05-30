package model;

/**
 * <h1>The interface IScore.</h1>
 * 
 * @author Hugo
 * @version 1.0
 */

public interface IScore extends IModel {
	
	/**
	 * get the score
	 * @return the score
	 */
	public int getScore();
	
	/**
	 * calculate and add the score
	 * @param points
	 */
	public void addScore(int points);
	
	/**
	 * set the score 
	 * @param points
	 */
	public void setScore(int points);
	
}
