public interface Command {
    default void execute() {}
    default void undo() {}
}
