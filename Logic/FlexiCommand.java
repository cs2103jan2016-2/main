package parser;

import java.util.HashMap;

/*
 *@author Pay Hao Jie
 *@Description: This class consolidates the possible inputs for a specific command 
 *				if the user happens to key in a different variation. 
 */

public class FlexiCommand {
	private static CommandType ADD = CommandType.ADD;
	private static CommandType DELETE = CommandType.DELETE;
	private static CommandType EDIT = CommandType.EDIT;
	private static CommandType HELP = CommandType.HELP;
	private static CommandType DISPLAY = CommandType.DISPLAY;
	private static CommandType TAG = CommandType.TAG;
	private static CommandType UNTAG = CommandType.UNTAG;
	private static CommandType UNDO = CommandType.UNDO;
	private static CommandType REDO = CommandType.REDO;
	private static CommandType FLAG = CommandType.FLAG;
	private static CommandType UNFLAG = CommandType.UNFLAG;
	private static CommandType EXIT = CommandType.EXIT;
	private static CommandType SEARCH = CommandType.SEARCH;
	private static CommandType SORT = CommandType.SORT;
	private static CommandType COMPLETE = CommandType.COMPLETE;
	private static CommandType CLEAR = CommandType.CLEAR;
	
	private static HashMap<String, CommandType> possibleCommands;
	
	public FlexiCommand() {
		possibleCommands = new HashMap<String, CommandType>();
		possibleCommands = initiateFlexiAddCommand();
		possibleCommands = initiateFlexiDeleteCommand();
		possibleCommands = initiateFlexiEditCommand();
		possibleCommands = initiateFlexiHelpCommand();
		possibleCommands = initiateFlexiDisplayCommand();
		possibleCommands = initiateFlexiTagCommand();
		possibleCommands = initiateFlexiUntagCommand();
		possibleCommands = initiateFlexiUndoCommand();
		possibleCommands = initiateFlexiRedoCommand();
		possibleCommands = initiateFlexiFlagCommand();
		possibleCommands = initiateFlexiUnflagCommand();
		possibleCommands = initiateFlexiExitCommand();
		possibleCommands = initiateFlexiSearchCommand();
		possibleCommands = initiateFlexiSortCommand();
		possibleCommands = initiateFlexiCompleteCommand();
		possibleCommands = initiateFlexiClearCommand();
		
	}
	
	public HashMap<String, CommandType> getKeywordsDataBase() {
		return possibleCommands;
	}
	
	
	private HashMap<String, CommandType> initiateFlexiAddCommand() {
		possibleCommands.put("add", ADD);
		possibleCommands.put("+", ADD);
		possibleCommands.put("ad", ADD);
		possibleCommands.put("adds", ADD);
		possibleCommands.put("a", ADD);
		possibleCommands.put("create", ADD);
		possibleCommands.put("creates", ADD);
		possibleCommands.put("creat", ADD);
		return possibleCommands;
	}
	
	private HashMap<String, CommandType> initiateFlexiDeleteCommand() {
		possibleCommands.put("d", DELETE);
		possibleCommands.put("delete", DELETE);
		possibleCommands.put("dlt", DELETE);
		possibleCommands.put("del", DELETE);
		possibleCommands.put("deletes", DELETE);
		possibleCommands.put("remove", DELETE);
		possibleCommands.put("rm", DELETE);
		possibleCommands.put("r", DELETE);
		return possibleCommands;
		
	}
	
	private HashMap<String, CommandType> initiateFlexiEditCommand() {
		possibleCommands.put("ed", EDIT);
		possibleCommands.put("edit", EDIT);
		possibleCommands.put("edits", EDIT);
		possibleCommands.put("update", EDIT);
		possibleCommands.put("updates", EDIT);
		possibleCommands.put("change", EDIT);
		possibleCommands.put("changes", EDIT);
		possibleCommands.put("correct", EDIT);
		return possibleCommands;
	}
	
	private HashMap<String, CommandType> initiateFlexiHelpCommand() {
		possibleCommands.put("help", HELP);
		possibleCommands.put("helps", HELP);
		possibleCommands.put("h", HELP);
		possibleCommands.put("assist", HELP);
		return possibleCommands;
	}
	
	private HashMap<String, CommandType> initiateFlexiDisplayCommand() {
		possibleCommands.put("display", DISPLAY);
		possibleCommands.put("displays", DISPLAY);
		possibleCommands.put("show", DISPLAY);
		possibleCommands.put("view", DISPLAY);
		possibleCommands.put("v", DISPLAY);
		possibleCommands.put("see", DISPLAY);
		return possibleCommands;
	}
	
	private HashMap<String, CommandType> initiateFlexiTagCommand() {
		possibleCommands.put("tag", TAG);
		possibleCommands.put("cat", TAG);
		possibleCommands.put("tags", TAG);
		possibleCommands.put("category", TAG);
		return possibleCommands;
		
	}
	
	private HashMap<String, CommandType> initiateFlexiUntagCommand() {
		possibleCommands.put("untag", UNTAG);
		possibleCommands.put("untags", UNTAG);
		return possibleCommands;
	}
	
	private HashMap<String, CommandType> initiateFlexiUndoCommand() {
		possibleCommands.put("undo", UNDO);
		possibleCommands.put("back", UNDO);
		possibleCommands.put("previous", UNDO);
		possibleCommands.put("revert", UNDO);
		possibleCommands.put("b", UNDO);
		possibleCommands.put("goback", UNDO);
		return possibleCommands;
	}
	
	private HashMap<String, CommandType> initiateFlexiRedoCommand() {
		possibleCommands.put("redo", REDO);
		possibleCommands.put("redos", REDO);
		return possibleCommands;
		
	}
	
	private HashMap<String, CommandType> initiateFlexiFlagCommand() {
		possibleCommands.put("flag", FLAG);
		possibleCommands.put("flags", FLAG);
		possibleCommands.put("important", FLAG);
		possibleCommands.put("impt", FLAG);
		possibleCommands.put("starred", FLAG);
		possibleCommands.put("star", FLAG);
		return possibleCommands;
		
	}
	
	private HashMap<String, CommandType> initiateFlexiUnflagCommand() {
		possibleCommands.put("unflag", UNFLAG);
		possibleCommands.put("unflags", UNFLAG);
		possibleCommands.put("unimportant", UNFLAG);
		possibleCommands.put("unimpt", UNFLAG);
		possibleCommands.put("unstarred", UNFLAG);
		possibleCommands.put("unstar", UNFLAG);
		return possibleCommands;
	}
	
	private HashMap<String, CommandType> initiateFlexiExitCommand() {
		possibleCommands.put("exit", EXIT);
		possibleCommands.put("exits", EXIT);
		possibleCommands.put("quit", EXIT);
		possibleCommands.put("quits", EXIT);
		possibleCommands.put("q", EXIT);
		possibleCommands.put("q!", EXIT);
		possibleCommands.put("terminate", EXIT);
		return possibleCommands;
	}
	
	private HashMap<String, CommandType> initiateFlexiSortCommand() {
		possibleCommands.put("sort", SORT);
		possibleCommands.put("arrange", SORT);
		possibleCommands.put("sorts", SORT);
		return possibleCommands;
		
	}
	
	private HashMap<String, CommandType> initiateFlexiSearchCommand() {
		possibleCommands.put("search", SEARCH);
		possibleCommands.put("find", SEARCH);
		possibleCommands.put("f", SEARCH);
		return possibleCommands;
	}
	
	private HashMap<String, CommandType> initiateFlexiCompleteCommand() {
		possibleCommands.put("complete", COMPLETE);
		possibleCommands.put("completes", COMPLETE);
		possibleCommands.put("done", COMPLETE);
		possibleCommands.put("finish", COMPLETE);
		possibleCommands.put("fin", COMPLETE);
		possibleCommands.put("end", COMPLETE);
		return possibleCommands;
	}
	
	private HashMap<String, CommandType> initiateFlexiClearCommand() {
		possibleCommands.put("clear", CLEAR);
		possibleCommands.put("clears", CLEAR);
		possibleCommands.put("wipe", CLEAR);
		possibleCommands.put("wipeout", CLEAR);
		return possibleCommands;
	}
	
	
}
