
public class GameManager {
	private int currentLevel;
	private int winnings;
	private boolean fiftyFiftyUsed;
	private boolean askAudienceUsed;
	private boolean askExpertUsed;
	private QuestionList qlist;
	private int index;
	private Question q;
	
	public GameManager (QuestionList qlist) {
		this.index = 0;
		currentLevel = index + 1;
		winnings = 0;
		fiftyFiftyUsed = false;
		askAudienceUsed = false;
		askExpertUsed = false;
		this.qlist = qlist;
		this.q = qlist.getList().get(index);
	}
	
	/*
	 * public void lifelinePressed () {
	 * 		set lifeline to true
	 * 		change answer choices
	 */
	
	public void correct () {
		if (currentLevel != 15) {
			currentLevel ++;
			winnings ++;
			index ++;
			setQ(index);
		} else {
			System.out.println("Congratulations, you've won a million dollars!");
		}
	}
	
	public void incorrect () {
		if (currentLevel <= 5) {
			winnings = 0;
		} else if (currentLevel >= 6 && currentLevel <= 10) {
			winnings = 5;
		} else if (currentLevel >= 11) {
			winnings = 10;
		}
	}
	
	public int getCurrentLevel() {
		return currentLevel;
	}
	
	public int getWinnings() {
		int[] list = {0, 100, 200, 300, 500, 1000, 2000, 4000, 8000, 16000, 32000, 64000, 125000, 250000, 500000, 1000000};
		return list[winnings];
	}
	
	public int getQuestionAmount() {
		int[] list = {0, 100, 200, 300, 500, 1000, 2000, 4000, 8000, 16000, 32000, 64000, 125000, 250000, 500000, 1000000};
		return list[currentLevel];
	}
	
	public boolean isFiftyFiftyUsed() {
		return fiftyFiftyUsed;
	}
	
	public void FiftyFiftyUsed() {
		fiftyFiftyUsed = true;
	}
	
	public boolean isAskAudienceUsed() {
		return askAudienceUsed;
	}

	public void askAudienceUsed() {
		askAudienceUsed = true;
	}
	
	public boolean isAskExpertUsed() {
		return askExpertUsed;
	}
	
	public void askExpertUsed() {
		askExpertUsed = true;
	}
	
	public Question getQ() {
		return qlist.getList().get(index);
	}
	
	public void setQ (int index) {
		this.q = qlist.getList().get(index);
	}
	
	public QuestionList getQuestionList () {
		return qlist;
	}
	
	public int getIndex () {
		return index;
	}
}
