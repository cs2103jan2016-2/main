public abstract class Command {
	COMMAND_TYPE command_type;
	
	public Command() {
	}
	
	public abstract String execute();
	
	public abstract String undo();
}
