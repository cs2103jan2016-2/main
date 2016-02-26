
public class Parser {
	String command;
	COMMAND_TYPE commandType;
	
	public Parser(String command) {
		this.command = command;
	}
	
	public COMMAND_TYPE getCommandType() {
		return this.commandType;
	}
}
