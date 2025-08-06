public class DeleteCommand implements Command {

    private Receiver receiver;
    private String[] deletedData; //to remember what was deleted, array since 3 parameters
    private int deletedIndex; //to be used to remember the original position before being deleted
    private boolean undoable = true;

    public boolean getUndoable() {
        return undoable;
    }

    public DeleteCommand(Receiver receiver, String param) {
        this.receiver = receiver;
        this.deletedIndex= Integer.parseInt(param); //parse the String[] param to int
    }
    @Override
    public void execute() {
        //before deleting, grab and clone the data at index
        this.deletedData = receiver.dataStore.get(deletedIndex - 1).clone(); //-1 since arraylist starts from 0
        receiver.delete(deletedIndex);
    }
    @Override
    //For DeleteCommand, undo restores the data from history
    public void undo() {
        receiver.dataStore.add(deletedIndex - 1, deletedData);
    }

}
