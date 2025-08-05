import java.util.Stack;

public class UndoCommand implements Command {

    private Receiver receiver;
    private Stack<Command> commandHistory;

    public UndoCommand(Receiver receiver,  Stack<Command> history) {
        this.receiver = receiver;
        this.commandHistory = history;

    }

    @Override
    public void execute() {
        if  (!commandHistory.isEmpty()) {
            Command lastCommand = commandHistory.pop();
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
