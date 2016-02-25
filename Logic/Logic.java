import java.util.*;

/*
 * @author: Lu Yang
 * description: 
 */

enum COMMAND {
	ADD, EDIT, DELETE, TAG, FLAG, SEARCH, UNDO, REDO, 
}

public class Logic {
	ArrayList<Task> tasks;
	
	public Logic() {
		tasks = retrieveTasks();
	}
	
	public ArrayList<Task> retrieveTasks() {
		Storage storage = new Storage();
		storage.getTasks();
	}
	
	public void processCommand() {
		Parser parser = new Parser(command);
		COMMAND command = parser.getCommandType();
		
		switch (command) {
		case ADD:
			add();
		}
	}
	
	public void add() {
		Add add = new Add();
	}
	
	
}
