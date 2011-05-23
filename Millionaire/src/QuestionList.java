import java.util.ArrayList;


public class QuestionList {

	private ArrayList<Question> list;
	
	public QuestionList () {
		list = new ArrayList<Question>();
	}
	
	public void addToList (Question q) {
		list.add(q);
	}
	
	public ArrayList<Question> getList () {
		return list;
	}
	
	public String toString () {
		return list.toString();
	}
}
