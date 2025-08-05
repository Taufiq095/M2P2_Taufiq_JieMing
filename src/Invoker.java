import java.util.Stack;

public class Invoker {

    private Command[] cmdToExecute;

    public void setCommandsForExecution(Command[] cmdToExecute) {
        this.cmdToExecute = cmdToExecute;
    }

    public void executeCommand(Stack<Command> history) {
        for (int i=0; i<cmdToExecute.length; i++) {
            cmdToExecute[i].execute();
            if (cmdToExecute[i].toString().equals("undo") || cmdToExecute[i].toString().equals(
                    "list")) {
                //Do nothing, undo and list not pushed to history stack
            }
            else {
                history.add(cmdToExecute[i]);
            }
        }
    }
}
