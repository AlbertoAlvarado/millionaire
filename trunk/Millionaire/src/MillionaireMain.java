import java.awt.Container;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class MillionaireMain {
	public static void main (String[] args) throws FileNotFoundException {
		QuestionList qList = MillionaireFileReading.generateQuestions();
		GameManager gm = new GameManager(qList);
		MillionaireGUI gui = new MillionaireGUI(gm);
		gui.launchFrame();
	}
}
