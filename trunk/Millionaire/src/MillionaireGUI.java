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
	
	private JTextField questionField;
	private JButton answerAButton;
	private JButton answerBButton;
	private JButton answerCButton;
	private JButton answerDButton;
	private JButton walkAwayButton;
	
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
		
		f.getContentPane().add(question);
		f.getContentPane().setLayout(new GridBagLayout());
		f.getContentPane().add(answerA);
		f.getContentPane().add(answerB);
		f.getContentPane().add(answerC);
		f.getContentPane().add(answerD);
		f.getContentPane().add(walkAway);
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
