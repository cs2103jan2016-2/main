import java.util.*;

/*
 * @author: Lu Yang
 * description: 
 */

enum COMMAND {
	ADD, EDIT, DELETE, TAG, FLAG, SEARCH, UNDO, REDO, 
}

public class Logic {
	Parser parser;
	ArrayList<Task> ongoingTasks;
	ArrayList<Task> completedTasks;
	ArrayList<Task> overdueTasks;
	ArrayList<Task> floatingTasks;
	ArrayList<Task> results;
	
	public Logic(String command) {
		parser = new Parser(command);
	}
	
	public ArrayList<Task> retrieveTasks() {
		Storage storage = new Storage();
		storage.getTasks();
	}
	
	public void run(String command) {
		COMMAND command = parser.getCommandType();
		
		switch (command) {
		case ADD:
			add();
			break;
		case EDIT:
			edit();
			break;
		case DELETE:
			delete();
			break;
			
	}
	
	public void add() {
		String name = parser.getName();
		String tag = parser.getTag();
		boolean isTask = parser.getIsTask();
		boolean flag = parser.getFlag();
		Date startTime = parser.getStartTime();
		Date endTime = parser.getEndTime();
		
		Task task = new Task(name, tag, isTask, flag, startTime, endTime);
		ongoingTasks.add(task);
	}
	
	public void edit() {
		
	}
	
	
}
