package Main;

public interface Command {
    default void execute() {}
    default void undo() {}
    boolean getUndoable();
}
