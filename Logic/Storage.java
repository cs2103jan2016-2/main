import java.io.*;
import java.util.*;

public class Storage {
	private static final String FILENAME_ONGOING_TASKS = "OngoingTasks.txt";
	private static final String FILENAME_COMPLETED_TASKS = "CompletedTasks.txt";
	private static final String FILENAME_FLOATING_TASKS = "FloatingTasks.txt";
	private static final String FILENAME_OVERDUE_TASKS = "OverdueTasks.txt";

	private static final String EMPTY_STRING = "";

	PrintWriter pw;
	BufferedReader br;

	public Storage(String directory) {
		// it cannot create a file in a specific directory for now
		// it only creates a file in the same directory as the programme
		initialiseFile(FILENAME_ONGOING_TASKS);
		initialiseFile(FILENAME_COMPLETED_TASKS);
		initialiseFile(FILENAME_FLOATING_TASKS);
		initialiseFile(FILENAME_OVERDUE_TASKS);
	}

	public ArrayList<Task> read(TASK_STATUS task_status) {
		switch (task_status) {
		case ONGOING:
			return readFromFile(FILENAME_ONGOING_TASKS);
		case COMPLETED:
			return readFromFile(FILENAME_COMPLETED_TASKS);
		case FLOATING:
			return readFromFile(FILENAME_FLOATING_TASKS);
		case OVERDUE:
			return readFromFile(FILENAME_OVERDUE_TASKS);
		default:
			return null;
		}
	}

	public String save(TASK_STATUS task_status, ArrayList<Task> tasks) {
		switch (task_status) {
		case ONGOING:
			return printToFile(FILENAME_ONGOING_TASKS, tasks);
		case COMPLETED:
			return printToFile(FILENAME_COMPLETED_TASKS, tasks);
		case FLOATING:
			return printToFile(FILENAME_FLOATING_TASKS, tasks);
		case OVERDUE:
			return printToFile(FILENAME_OVERDUE_TASKS, tasks);
		default:
			return "Invalid type of tasks.";
		}
	}
	
	private String printToFile(String filename, ArrayList<Task> tasks)  {
		clearFile(filename);
		String output = "";
		
		try {
			pw = new PrintWriter(new BufferedWriter(new FileWriter(filename, true)));
			for (int i=0; i<tasks.size(); i++) {
				pw.println(tasks.get(i));
			}
			pw.close();
		}
		catch (IOException e) {
			e.printStackTrace();
			return "Saving " + filename + " is not successful. :(";
		}
		return "Saving " + filename + " is successful. :)";
	}

	private ArrayList<String> readFromFile(String filename) {
		ArrayList<String> tasks = new ArrayList<String>();
		try {
			br = new BufferedReader(new FileReader(filename));
			String content = br.readLine();
			// serialised???
			while (!content.equals(EMPTY_STRING)) {
				tasks.add(content);
				content = br.readLine();
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return tasks;
	}

	private void initialiseFile(String filename) {
		try {
			pw = new PrintWriter(new BufferedWriter(new FileWriter(filename, true)));
			pw.print("");
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void clearFile(String filename) {
		try {
			pw = new PrintWriter(new BufferedWriter(new FileWriter(filename, false)));
			pw.print("");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
