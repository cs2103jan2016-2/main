import java.util.ArrayList;

public class Logic {
	private ArrayList<Task> ongoingTasks;
	private ArrayList<Task> completedTasks;
	private ArrayList<Task> overdueTasks;
	private ArrayList<Task> floatingTasks;
	private ArrayList<Task> results;
	
	public void run(String input) {
		 System.out.println("process command");
	}
	public void save() {
		System.out.println("do save");
	}
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
