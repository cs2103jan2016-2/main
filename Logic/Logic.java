import java.util.*;

/*
 * @author: Lu Yang
 * description: 
 */

public class Logic {
	Storage storage;
	ArrayList<Task> ongoingTasks;
	ArrayList<Task> completedTasks;
	ArrayList<Task> overdueTasks;
	ArrayList<Task> floatingTasks;
	ArrayList<Task> results;
	
	// UI: you will call this when user starts the programme
	public Logic(String directory) {
		Storage storage = new Storage(directory);
		ongoingTasks = storage.read(TYPE.ONGOING);
		completedTasks = storage.read(TYPE.COMPLETED);
		overdueTasks = storage.read(TYPE.OVERDUE);
		floatingTasks = storage.read(TYPE.FLOATING);
	}
	
	// UI: you will call this to run logic
	public String run(String input) {
		return processCommand(input);
	}
	
	public String processCommand(String input) {
		Parser parser = new Parser(input);
		COMMAND command = parser.getCommandType();
		
		switch (command) {
		case ADD:
			return add();
	}
	
	public String add() {
		String name = parser.getName();
		String tag = parser.getTag(); // may be null
		boolean isTask = parser.getIsTask();
		boolean flag = parser.getFlag();
		Date startTime = parser.getStartTime(); // may be null
		Date endTime = parser.getEndTime();
		
		Task task = new Task(name, tag, isTask, flag, startTime, endTime);
		ongoingTasks.add(task);
		return "Added successfully";
	}	
	
	// UI: you will call this when user is quiting the programme
	public String save() {
		storage.save(TYPE.ONGOING, ongoingTasks);
		storage.save(TYPE.COMPLETED, completedTasks);
		storage.save(TYPE.FLOATING, floatingTasks);
		storage.save(TYPE.OVERDUE, overdueTasks);
		return "Saved successfully";
	}
}
