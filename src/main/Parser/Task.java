import java.util.*;

	/*
	 *@author Pay Hao Jie
	 *@Description: This class sets and returns the attributes of a task. 
	 */
public class Task {
	
	private int taskID;
	private Date taskStartDate;
	private Date taskEndDate;
	private String taskTag;
	private String taskDescription;
	private boolean taskImportance;
	private boolean isTask;
	private boolean isComplete;
	
	protected int getTaskID() {
		return this.taskID;
	}
	
	protected void setTaskID(int taskID) {
		this.taskID = taskID;
	}
	
	protected Date getTaskStartDate() {
		return this.taskStartDate;
	}
	
	protected void setTaskStartDate(Date taskStartDate) {
		this.taskStartDate = taskStartDate;
	}
	
	protected Date getTaskEndDate() {
		return this.taskEndDate;
	}
	
	protected void setTaskEndDate(Date taskEndDate) {
		this.taskEndDate = taskEndDate;
	}
	
	protected boolean getTaskImportance() {
		return this.taskImportance;
	}
	
	protected void setTaskImportance(boolean taskImportance) {
		this.taskImportance = taskImportance;
	}
	
	protected String getTaskTag() {
		return this.taskTag;
	}
	
	protected void getTaskTag(String taskTag) {
		this.taskTag = taskTag;
	}
	
	protected String getTaskDescription() {
		return this.taskDescription;
	}
	
	protected void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}
	
	protected boolean isTask() {
		return this.isTask;
	}
	
	protected void setImportanceOfTask(boolean isTask) {
		this.isTask = isTask;
	}
	
	protected boolean getIsTaskComplete() {
		return this.isComplete;
	}
	
	protected void setTaskAsComplete(boolean isComplete) {
		this.isComplete = isComplete;
	}
	
}
