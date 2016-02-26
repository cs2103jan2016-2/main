import java.util.*;

public class History {
	private Stack<Command> history;
	
	public getPrevCommand() {
		return history.pop();
	}
}
