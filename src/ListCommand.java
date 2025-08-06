public class ListCommand implements Command {

    private Receiver receiver;
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
        receiver.list();
    }

    @Override
    public String toString() {
        return "list";
    }

}
