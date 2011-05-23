import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


//http://www.eweezy.com/2009/10/who-wants-to-be-millionaire-old-game.html

public class MillionaireFileReading {
	public static QuestionList generateQuestions () throws FileNotFoundException {
		Scanner console = new Scanner(System.in);
		QuestionList qList = readFile(console);
		return currentQuestions(qList);
	}
	
	
	public static QuestionList readFile (Scanner console) throws FileNotFoundException {
		QuestionList qList = new QuestionList();
		File data = new File ("src/Questions");
		Scanner fileScan = new Scanner(data);

		
		while (fileScan.hasNext()) {
			Scanner lineScan = new Scanner(fileScan.nextLine());
			int level = lineScan.nextInt();
			String question = fileScan.nextLine();
			String answerA = fileScan.nextLine();
			String answerB = fileScan.nextLine();
			String answerC = fileScan.nextLine();
			String answerD = fileScan.nextLine();
			String correctAnswer = fileScan.nextLine();
			
			Question q = new Question(question, answerA, answerB, answerC, answerD, level, correctAnswer);
			qList.addToList(q);
			
		}
		return qList;
	}
	
	public static QuestionList currentQuestions (QuestionList qList) {
		QuestionList finalQuestions = new QuestionList();
		for (int i = 1; i <= 15; i++) {
			QuestionList tempQuestions = new QuestionList();
			for (Question q: qList.getList()) {
				if (i == q.getLevel()) {
					tempQuestions.addToList(q);
				}
			}
			int random = (int)(Math.random() * tempQuestions.getList().size());
			finalQuestions.addToList(tempQuestions.getList().get(random));
		}
		return finalQuestions;
	}
}
