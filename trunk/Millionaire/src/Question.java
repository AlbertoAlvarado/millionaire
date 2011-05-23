
public class Question {
	/*
	 * A question has:
	 * - 1 question
	 * - 4 answer choices
	 * - 1 correct answer
	 * - $$$ amount
	 */
	
	private String question;
	private String answerA;
	private String answerB;
	private String answerC;
	private String answerD;
	private int level;
	private String correctAnswer;
	
	public Question (String question, String answerA, String answerB, String answerC, String answerD, int level, String correctAnswer) {
		this.question = question;
		this.answerA = answerA;
		this.answerB = answerB;
		this.answerC = answerC;
		this.answerD = answerD;
		this.level = level;
		this.correctAnswer = correctAnswer;
	}
	
	public String toString () {
		return question + ": " + level + "\n" + answerA + "\n" + answerB + "\n" + answerC + "\n" + answerD + "\n" + correctAnswer + "\n";
	}
	
	public int getLevel () {
		return level;
	}

	public String getQuestion() {
		return question;
	}

	public String getAnswerA() {
		return answerA;
	}

	public String getAnswerB() {
		return answerB;
	}

	public String getAnswerC() {
		return answerC;
	}

	public String getAnswerD() {
		return answerD;
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}

}
