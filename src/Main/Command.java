package Main;

import Helper.InvalidInputsException;

public interface Command {
    default void execute() throws InvalidInputsException {}
    default void undo() {}
    boolean getUndoable();
}
