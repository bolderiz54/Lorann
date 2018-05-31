package model;

/**
 * <h1>The class Score contains the methods and the data to manipulate a score counter.</h1>
 * 
 * @author Hugo
 * @version 1.0
 */
public class Score implements IScore {

	/**
	 * retain the score obtained
	 */
	private int score = 0;
	
	/**
	 * get the score
	 * @return the score
	 */
	@Override
	public int getScore() {	
		return score;
	}

	/**
	 * calculate and add the score
	 * @param points
	 */
	@Override
	public void addScore(int points) {
		this.setScore(this.getScore() + points);
		
	}

	/**
	 * set the score 
	 * @param points
	 */
	@Override
	public void setScore(int points) {
		this.score=points;
		
	}

}

