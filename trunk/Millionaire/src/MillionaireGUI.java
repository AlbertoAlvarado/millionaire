import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;

public class MillionaireGUI {
	
	private JFrame f = new JFrame("Who Wants to be a Millionaire?");
	private JPanel question = new JPanel();
	private JPanel answerA = new JPanel();
	private JPanel answerB = new JPanel();
	private JPanel answerC = new JPanel();
	private JPanel answerD = new JPanel();
	private JPanel walkAway = new JPanel();
	private JPanel fiftyFifty = new JPanel();
	private JPanel pollAudience = new JPanel();
	private JPanel askTheExpert = new JPanel();
	
	private JTextField questionField;
	private JButton answerAButton;
	private JButton answerBButton;
	private JButton answerCButton;
	private JButton answerDButton;
	private JButton walkAwayButton;
	private JButton fiftyFiftyButton;
	private JButton pollAudienceButton;
	private JButton askTheExpertButton;
	
	private GameManager gm;
	
	public MillionaireGUI (GameManager gm) {
		this.gm = gm;
		
		questionField = new JTextField(gm.getQ().getQuestion());
		questionField.setEditable(false);
		answerAButton = new JButton(gm.getQ().getAnswerA());
		answerBButton = new JButton(gm.getQ().getAnswerB());
		answerCButton = new JButton(gm.getQ().getAnswerC());
		answerDButton = new JButton(gm.getQ().getAnswerD());
		walkAwayButton = new JButton("Walk Away");
		fiftyFiftyButton = new JButton("50/50");
		pollAudienceButton = new JButton("Ask the Audience");
		askTheExpertButton = new JButton("Ask an Expert");
		
		question.add(questionField);
		answerA.add(answerAButton);
		ActionListener listenerA = new AActionListener();
		answerAButton.addActionListener(listenerA);
		ActionListener listenerB = new BActionListener();
		answerBButton.addActionListener(listenerB);
		answerB.add(answerBButton);
		ActionListener listenerC = new CActionListener();
		answerCButton.addActionListener(listenerC);
		answerC.add(answerCButton);
		ActionListener listenerD = new DActionListener();
		answerDButton.addActionListener(listenerD);
		answerD.add(answerDButton);
		ActionListener walkListener = new WalkListener();
		walkAwayButton.addActionListener(walkListener);
		walkAway.add(walkAwayButton);
		ActionListener fiftyListener = new FiftyFiftyListener();
		fiftyFiftyButton.addActionListener(fiftyListener);
		fiftyFifty.add(fiftyFiftyButton);
		ActionListener audienceListener = new PollAudienceListener();
		pollAudienceButton.addActionListener(audienceListener);
		pollAudience.add(pollAudienceButton);
		ActionListener expertListener = new ExpertListener();
		askTheExpertButton.addActionListener(expertListener);
		askTheExpert.add(askTheExpertButton);
		
		f.getContentPane().add(question);
		f.getContentPane().setLayout(new GridBagLayout());
		f.getContentPane().add(answerA);
		f.getContentPane().add(answerB);
		f.getContentPane().add(answerC);
		f.getContentPane().add(answerD);
		f.getContentPane().add(walkAway);
		f.getContentPane().add(fiftyFifty);
		f.getContentPane().add(pollAudience);
		f.getContentPane().add(askTheExpert);
	}
	
	public class AActionListener implements ActionListener {	
		public void actionPerformed(ActionEvent event) {
			if (gm.getQ().getCorrectAnswer().equals("A")) {
				updateCorrect();
			}
			else {
				updateIncorrect();
			}
		}	
	}
	
	public class BActionListener implements ActionListener {	
		public void actionPerformed(ActionEvent event) {
			if (gm.getQ().getCorrectAnswer().equals("B")) {
				updateCorrect();
			}
			else {
				updateIncorrect();
			}
		}	
	}
	
	public class CActionListener implements ActionListener {	
		public void actionPerformed(ActionEvent event) {
			if (gm.getQ().getCorrectAnswer().equals("C")) {
				updateCorrect();
			}
			else {
				updateIncorrect();
			}
		}	
	}
	
	public class DActionListener implements ActionListener {	
		public void actionPerformed(ActionEvent event) {
			if (gm.getQ().getCorrectAnswer().equals("D")) {
				updateCorrect();			
			}
			else {
				updateIncorrect();
			}
		}	
	}
	
	public class WalkListener implements ActionListener {
		public void actionPerformed (ActionEvent event) {
			walkAway();
		}
	}
	
	public class FiftyFiftyListener implements ActionListener {
		public void actionPerformed (ActionEvent event) {
			if (!gm.isLifeline1Used()) {
				updateFiftyFifty();
				gm.Lifeline1Used();
				fiftyFifty.removeAll();
			} 
/*
 * 			determine what answer is correct
 * 			from incorrect answers, choose two of them randomly
 * 			tell manager to remove them
 */
		}
	}
	
	public class PollAudienceListener implements ActionListener {
		public void actionPerformed (ActionEvent event) {
			if (!gm.isLifeline2Used()) {
				updateAudience();
				gm.Lifeline2Used();
				pollAudience.removeAll();
			}
/*
 * 			look at level of question
 * 			based on level, use algorithm to determine the percentages the audience votes for
 * 			tell manager to show a graphic
 */
		}
	}
	
	public class ExpertListener implements ActionListener {
		public void actionPerformed (ActionEvent event) {
/*
 * 			randomly pick an expert from an array
 * 			determine level of question
 * 			based on level, use algorithm to determine how sure the expert is
 * 			tell manager to show a graphic
 */
			if (!gm.isLifeline3Used()) {
				updateExpert();
				gm.Lifeline3Used();
				askTheExpert.removeAll();
			}
		}
	}
	
	public void updateFiftyFifty() {
		if (gm.getQ().getCorrectAnswer().equals("A")) {
			questionField.setText(gm.getQ().getQuestion());
			answerAButton.setText(gm.getQ().getAnswerA());
			
			int random = (int) (3 * Math.random());
			if (random == 0) {
				answerBButton.setText(gm.getQ().getAnswerB());
				answerCButton.setText("");
				answerDButton.setText("");
			} else if (random == 1) {
				answerBButton.setText("");
				answerCButton.setText(gm.getQ().getAnswerC());
				answerDButton.setText("");
			} else if (random == 2){
				answerBButton.setText("");
				answerCButton.setText("");
				answerDButton.setText(gm.getQ().getAnswerD());
			}
			this.f.pack();
		} else if (gm.getQ().getCorrectAnswer().equals("B")) {
			questionField.setText(gm.getQ().getQuestion());
			answerBButton.setText(gm.getQ().getAnswerB());
			
			int random = (int) (3 * Math.random());
			if (random == 0) {
				answerAButton.setText(gm.getQ().getAnswerA());
				answerCButton.setText("");
				answerDButton.setText("");
			} else if (random == 1) {
				answerAButton.setText("");
				answerCButton.setText(gm.getQ().getAnswerC());
				answerDButton.setText("");
			} else if (random == 2){
				answerAButton.setText("");
				answerCButton.setText("");
				answerDButton.setText(gm.getQ().getAnswerD());
			}
			this.f.pack();
		} else if (gm.getQ().getCorrectAnswer().equals("C")) {
			questionField.setText(gm.getQ().getQuestion());
			answerCButton.setText(gm.getQ().getAnswerC());
			
			int random = (int) (3 * Math.random());
			if (random == 0) {
				answerAButton.setText(gm.getQ().getAnswerA());
				answerBButton.setText("");
				answerDButton.setText("");
			} else if (random == 1) {
				answerAButton.setText("");
				answerBButton.setText(gm.getQ().getAnswerB());
				answerDButton.setText("");
			} else if (random == 2){
				answerAButton.setText("");
				answerBButton.setText("");
				answerDButton.setText(gm.getQ().getAnswerD());
			}
			this.f.pack();
		} else if (gm.getQ().getCorrectAnswer().equals("D")) {
			questionField.setText(gm.getQ().getQuestion());
			answerDButton.setText(gm.getQ().getAnswerD());
			
			int random = (int) (3 * Math.random());
			if (random == 0) {
				answerAButton.setText(gm.getQ().getAnswerA());
				answerBButton.setText("");
				answerCButton.setText("");
			} else if (random == 1) {
				answerAButton.setText("");
				answerBButton.setText(gm.getQ().getAnswerB());
				answerCButton.setText("");
			} else if (random == 2){
				answerAButton.setText("");
				answerBButton.setText("");
				answerCButton.setText(gm.getQ().getAnswerC());
			}
			this.f.pack();
		}
	}
	
	public void updateAudience() {
		/*
		 * determine confidence level from list
		 * pick random int between 1, 100
		 * if random int < confidence level
		 * 	audience recommends right answer
		 * else
		 * 	audience recommends randomly selected wrong answer
		 */
		String audienceAnswer = "";
		int confidenceLevel = 97 + ((gm.getQ().getLevel()-1) * -5);
		System.out.println(confidenceLevel);
		int random = (int) (100 * Math.random() + 1);
		System.out.println(random);
		if (random < confidenceLevel) {
			audienceAnswer = gm.getQ().getCorrectAnswer();
		} else {
			String[] list = {"A", "B", "C", "D"};
			boolean temp = true;
			int tempInt = 0;
			while (temp) {
				int newRandom = (int) (4 * Math.random());
				temp = list[newRandom].equals(gm.getQ().getCorrectAnswer());
				tempInt = newRandom;
			}
			audienceAnswer = list[tempInt];
		}
		System.out.println(audienceAnswer);
	}
	
	public void updateExpert() {
		String expertAnswer = "";
		String[] experts = {"Emile Gleeson", "George Matter", "Ms. Martin", "Bill Nye", "Jared from Subway", "Mr. Rogers", "Barack Obama", "Steve Jobs", "Donald Trump", "Malcolm Gladwell", "Mr. Truax", "Albert Einstein", "Ichiro", "Mr. Carpenter", "Grant Brosndon", "Erik Carlson", "Mr. Kastl", "Billy Mays", "Oprah Winfrey", "Dr. Phil", "Bob Barker", "Shirley Temple", "Justin Bieber", "Tiger Woods", "George Lucas", "Bill Cosby", "Arnold Palmer", "Meredith Viera", "Drew Carey", "Wayne Brady", "Dr. Greg House", "Ryan Seacrest", "Will Schuester", "Dr. Temperance Brennan"};
		int randomExpert = (int) (experts.length * Math.random());
		String expert = experts[randomExpert];
		int originalconfidenceLevel = 97 + ((gm.getQ().getLevel()-1) * -4);
		System.out.println(originalconfidenceLevel);
		int confidenceLevel = originalconfidenceLevel;
		int chance = (int) (5 * Math.random());
		if (((int)(2 * Math.random())) < 1 ) {
			confidenceLevel += chance;
		} else {
			confidenceLevel -= chance;
		}
		System.out.println(confidenceLevel);
		int random = (int) (100 * Math.random() + 1);
		System.out.println(random);
		if (random < confidenceLevel) {
			expertAnswer = gm.getQ().getCorrectAnswer();
		} else {
			String[] list = {"A", "B", "C", "D"};
			boolean temp = true;
			int tempInt = 0;
			while (temp) {
				int newRandom = (int) (4 * Math.random());
				temp = list[newRandom].equals(gm.getQ().getCorrectAnswer());
				tempInt = newRandom;
			}
			expertAnswer = list[tempInt];
			if (expertAnswer != gm.getQ().getCorrectAnswer()) {
				originalconfidenceLevel -= 10;
			}
		}
		System.out.println(expert + ": Hello, my answer is " + expertAnswer + ". I am " + originalconfidenceLevel + "% sure. Good luck!");
	}
	
	public void updateCorrect() {
		System.out.println("CORRECT");
		gm.correct();
		questionField.setText(gm.getQ().getQuestion());
		answerAButton.setText(gm.getQ().getAnswerA());
		answerBButton.setText(gm.getQ().getAnswerB());
		answerCButton.setText(gm.getQ().getAnswerC());
		answerDButton.setText(gm.getQ().getAnswerD());
		this.f.pack();
	}
	
	public void updateIncorrect() {
		System.out.println("INCORRECT");
		gm.incorrect();
		System.out.println(gm.getWinnings());
		System.exit(0);
	}
	
	public void walkAway() {
		System.out.println(gm.getWinnings());
		System.exit(0);
	}
	
	public GameManager getGameManager () {
		return gm;
	}
	
	public void setGameManager (GameManager manager) {
		this.gm = manager;
	}
	
	public void launchFrame () {
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack();
		f.setVisible(true);
	}
	
//	public static void main (String[] args) {
//		MillionaireGUI gui = new MillionaireGUI(gm);
//		gui.launchFrame();
//	}
}
