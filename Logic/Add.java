import java.util.ArrayList;
import java.util.Date;

public class Add extends Command {
	Parser parser;
	Logic logic;
	
	// for use in logic class
	public Add(Parser parser, Logic logic) {
		this.parser = parser;
		this.logic = logic;
	}

	@Override
	public String execute() {
		TYPE type = parser.getType();
		switch (type) {
		case ONGOING:
			return addOngoingTasks();
		case FLOATING:
			return addFloatingTasks();
		case OVERDUE:
			return addOverdueTasks();
		case COMPLETED:
			return addCompletedTasks();
		default:
			return "Invalid type of task.";
		}
	}
	
	private String addOngoingTasks() {
		String name = parser.getName(); // cannot be null
		String tag = parser.getTag(); // may be null
		boolean isTask = parser.getIsTask(); //default true: is a task not an event
		boolean flag = parser.getFlag(); // default false: unflagged
		Date startTime = parser.getStartTime(); // may be null
		Date endTime = parser.getEndTime(); // cannot be null
		
		Task task = new Task(name, tag, isTask, flag, startTime, endTime);
		ArrayList<Task> ongoingTasks = logic.getOngoingTasks();
		ongoingTasks.add(task);
		logic.setOngoingTasks(ongoingTasks);
	}
	
	private String addFloatingTasks() {
		String name = parser.getName(); // cannot be null
		String tag = parser.getTag(); // may be null
		boolean isTask = parser.getIsTask(); //default true: is a task not an event
		boolean flag = parser.getFlag(); // default false: unflagged
		Date startTime = parser.getStartTime(); // may be null
		Date endTime = parser.getEndTime(); // cannot be null
		
		Task task = new Task(name, tag, isTask, flag, startTime, endTime);
		ArrayList<Task> floatingTasks = logic.getFloatingTasks();
		floatingTasks.add(task);
		logic.setOngoingTasks(floatingTasks);
	}
	
	private String addOverdueTasks() {
		String name = parser.getName(); // cannot be null
		String tag = parser.getTag(); // may be null
		boolean isTask = parser.getIsTask(); //default true: is a task not an event
		boolean flag = parser.getFlag(); // default false: unflagged
		Date startTime = parser.getStartTime(); // may be null
		Date endTime = parser.getEndTime(); // cannot be null
		
		Task task = new Task(name, tag, isTask, flag, startTime, endTime);
		ArrayList<Task> overdueTasks = logic.getOverdueTasks();
		overdueTasks.add(task);
		logic.setOngoingTasks(overdueTasks);
	}
	
	private String addCompletedTasks() {
		String name = parser.getName(); // cannot be null
		String tag = parser.getTag(); // may be null
		boolean isTask = parser.getIsTask(); //default true: is a task not an event
		boolean flag = parser.getFlag(); // default false: unflagged
		Date startTime = parser.getStartTime(); // may be null
		Date endTime = parser.getEndTime(); // cannot be null
		
		Task task = new Task(name, tag, isTask, flag, startTime, endTime);
		ArrayList<Task> completedTasks = logic.getCompletedTasks();
		completedTasks.add(task);
		logic.setOngoingTasks(completedTasks);
	}

	@Override
	public String undo() {

	}
}
