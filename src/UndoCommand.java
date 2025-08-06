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

            System.out.println("Popped from history: " +  lastCommand.toString());
            lastCommand.undo();
            System.out.println("Undo");
        }
        else {
            System.out.println("Nothing to undo.");
        }

        //needs to access the history stack to pop and undo
//        receiver.undo(); Removed undo from Receiver and use it here instead

    }

//    @Override
//    public void undo() {
//
//    }
}
