import java.util.Stack;

public class UndoCommand implements Command {

    private Receiver receiver;
    private Stack<Command> history;
    private boolean undoable = true;

    public boolean getUndoable() {
        return undoable;
    }

    public UndoCommand(Receiver receiver,  Stack<Command> history) {
        this.receiver = receiver;
        this.history = history;
    }

    @Override
    public void execute() {
        if  (!history.isEmpty()) {
            Command lastCommand = history.pop();

            // ! print output error - printing memory location
            System.out.println("Popped from history: " +  lastCommand);
            lastCommand.undo();
            System.out.println("Undo");
        }
        else {
            System.out.println("Nothing to undo.");
        }
    }

}
