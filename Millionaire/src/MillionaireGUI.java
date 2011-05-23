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
	
	private JTextField questionField;
	private JButton answerAButton;
	private JButton answerBButton;
	private JButton answerCButton;
	private JButton answerDButton;
	
	public MillionaireGUI (Question q) {
		questionField = new JTextField(q.getQuestion());
		questionField.setEditable(false);
		answerAButton = new JButton(q.getAnswerA());
		answerBButton = new JButton(q.getAnswerB());
		answerCButton = new JButton(q.getAnswerC());
		answerDButton = new JButton(q.getAnswerD());
		
		question.add(questionField);
		answerA.add(answerAButton);
		ActionListener listener = new MyActionListener();
		answerAButton.addActionListener(listener);
		answerB.add(answerBButton);
		answerC.add(answerCButton);
		answerD.add(answerDButton);
		
		f.getContentPane().add(question);
		f.getContentPane().setLayout(new GridBagLayout());
		f.getContentPane().add(answerA);
		f.getContentPane().add(answerB);
		f.getContentPane().add(answerC);
		f.getContentPane().add(answerD);	
	}
	
	public class MyActionListener implements ActionListener {
		
		public void actionPerformed(ActionEvent event) {
			System.out.println("HELLO WORLD");
		}	
		
	}
	public void launchFrame () {
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack();
		f.setVisible(true);
	}
	
	public static void main (String[] args) {
		MillionaireGUI gui = new MillionaireGUI(new Question("What is the highest U.S. mountain east of the Mississippi River?", "Mount Washington, NH", "Mount Mitchell, NC", "Mount Adams, NH", "Stone Mountain, GA", 15, "B"));
		gui.launchFrame();
	}
}
