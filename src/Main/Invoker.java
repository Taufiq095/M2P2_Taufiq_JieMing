package Main;

import Helper.InvalidInputsException;

import java.util.Stack;

public class Invoker {

    private Command[] cmdToExecute;

    /**
     * Sets the array of commands to be executed by this invoker.
     * These commands will be processed sequentially when {@link #executeCommand(Stack)} is called.
     *
     * @param cmdToExecute An array of Command objects that the invoker will
     * execute.
     */
    public void setCommandsForExecution(Command[] cmdToExecute) {
        this.cmdToExecute = cmdToExecute;
    }

    /**
     * Executes the commands that have been set using {@link #setCommandsForExecution(Command[])}.
     * Each command in the array is executed in order.
     * If a command is undoable, it is pushed onto the provided history stack
     * after successful execution.
     *
     * @param history A stack of Command objects used to store commands
     */
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
            } catch (NumberFormatException e) {
                System.out.println("Please enter valid index");
            }
        }
    }
}
