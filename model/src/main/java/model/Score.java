package model;

/**
 * <h1>The class Score</h1>
 * The class Score contains the methods and the data to manipulate a score counter.
 * @author Hugo
 * @version 1.0
 */
public class Score implements IScore {

	/**
	 * retain the score obtained
	 */
	private int score = 0;
	
	@Override
	public int getScore() {	
		return score;
	}

	@Override
	public void addScore(int points) {
		this.setScore(this.getScore() + points);
	}

	@Override
	public void setScore(int points) {
		this.score=points;
	}

}

