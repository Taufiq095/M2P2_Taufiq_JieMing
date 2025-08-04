import java.util.Stack;

public class Invoker {
//list of commands given by client to execute
    private Command[] cmdToExecute;

    public void setCommandsForExecution(Command[] Command) {
        this.cmdToExecute = Command;

    }

    public void executeCommand(Stack<Command> history) {

        Stack<String> stack = new Stack<>();

    }


}
