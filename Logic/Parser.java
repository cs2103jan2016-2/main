
public class Parser {
	String command;
	COMMAND commandType;
	
	public Parser(String command) {
		this.command = command;
	}
	
	public COMMAND getCommandType() {
		return this.commandType;
	}
}
