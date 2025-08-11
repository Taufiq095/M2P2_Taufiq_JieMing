package Commands;

import Main.Command;
import Main.Receiver;

public class ListCommand implements Command {

    private Receiver receiver;

    /**
     * Returns whether this command is undoable.
     *
     * @return {@code true} if the command can be undone, {@code false} otherwise.
     */
    private boolean undoable = false;

    @Override
    public boolean getUndoable() {
        return undoable;
    }

    public ListCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        System.out.println("List");
        receiver.list();
    }

//    @Override
//    public String toString() {
//        return "list";
//    }
}
