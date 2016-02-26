import java.util.*;

/*
 * @author: Lu Yang
 * description: 
 */

public class Logic {
	private Storage storage;
	private ArrayList<Task> ongoingTasks;
	private ArrayList<Task> completedTasks;
	private ArrayList<Task> overdueTasks;
	private ArrayList<Task> floatingTasks;
	private ArrayList<Task> results;
	
	// UI: you will call this when user starts the programme
	public Logic(String directory) {
		storage = new Storage(directory);
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
		COMMAND_TYPE command = parser.getCommandType();
		
		switch (command) {
		case ADD:
			return add(parser);
		case UNDO:
			return undo();
	}
	
	public String add(Parser parser) {
		Command add = new Add(parser, this);
		return add.execute();
	}
	
	public String undo() {
		
	}
	
	// UI: you will call this when user is quiting the programme
	public String save() {
		storage.save(TYPE.ONGOING, ongoingTasks);
		storage.save(TYPE.COMPLETED, completedTasks);
		storage.save(TYPE.FLOATING, floatingTasks);
		storage.save(TYPE.OVERDUE, overdueTasks);
		return "Saved successfully";
	}
	
	/***********************************MUTATORS***********************************************/
	public void setOngoingTasks(ArrayList<Task> tasks) {
		this.ongoingTasks = tasks;
	}
	
	public void setFloatingTasks(ArrayList<Task> tasks) {
		this.floatingTasks = tasks;
	}
	
	public void setCompletedTasks(ArrayList<Task> tasks) {
		this.completedTasks = tasks;
	}
	
	public void setOverdueTasks(ArrayList<Task> tasks) {
		this.overdueTasks = tasks;
	}
	
	/***********************************ACCESSORS***********************************************/
	public ArrayList<Task> getOngoingTasks() {
		return this.ongoingTasks;
	}
	
	public ArrayList<Task> getFloatingTasks() {
		return this.floatingTasks;
	}
	
	public ArrayList<Task> getCompletedTasks() {
		return this.completedTasks;
	}
	
	public ArrayList<Task> getOverdueTasks() {
		return this.overdueTasks;
	}
}
