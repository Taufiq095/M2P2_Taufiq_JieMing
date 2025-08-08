package Main;

import Helper.InvalidInputsException;


public interface Command {

    /**
     * Executes the command.
     * @throws InvalidInputsException If the command encounters invalid inputs during execution.
     */
    default void execute() throws InvalidInputsException {}

    /**
     * Undoes the command's action.
     */
    default void undo() {}

    /**
     * Checks if the command can be undone.
     * @return {@code true} if the command is undoable, else {@code false}
     */
    boolean getUndoable();
}

