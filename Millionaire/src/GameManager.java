
public class GameManager {
	private int currentLevel;
	private int winnings;
	private boolean lifeline1Used;
	private boolean lifeline2Used;
	private boolean lifeline3Used;
	private Question q;
	
	/*
	 * public void lifelinePressed () {
	 * 		set lifeline to true
	 * 		change answer choices
	 */
	
	/*
	 * public void answerPressed (answer choice a/b/c/d) {
	 * 		determine if answer is correct
	 * 		if yes:
	 * 			print CONGRATS screen
	 * 			currentLevel ++
	 * 			winnings +
	 * 			change question
	 * 		if no:
	 * 			print WRONG screen
	 * 			display winnings
	 * 			end game
	 */
	
	public int getCurrentLevel() {
		return currentLevel;
	}
	
	public int getWinnings() {
		return winnings;
	}

	public boolean isLifeline1Used() {
		return lifeline1Used;
	}
	
	public boolean isLifeline2Used() {
		return lifeline2Used;
	}

	public boolean isLifeline3Used() {
		return lifeline3Used;
	}

	public Question getQ() {
		return q;
	}
	
	public void setQ(Question q) {
		this.q = q;
	}
	
}
