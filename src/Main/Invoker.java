package Main;

import Helper.InvalidInputsException;

import java.util.Stack;

public class Invoker {

    private Command[] cmdToExecute;

    public void setCommandsForExecution(Command[] cmdToExecute) {
        this.cmdToExecute = cmdToExecute;
    }

    public void executeCommand(Stack<Command> history) {
        for (int i=0; i<cmdToExecute.length; i++) {
            try {
                cmdToExecute[i].execute();
                if (cmdToExecute[i].getUndoable()) {
                    history.push(cmdToExecute[i]);
                }
                //everything else is skipped
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Please enter valid inputs");
            } catch (InvalidInputsException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
