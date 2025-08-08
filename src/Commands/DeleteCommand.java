package Commands;

import Main.Command;
import Main.Receiver;

public class DeleteCommand implements Command {

    private Receiver receiver;
    private String[] deletedData; //to remember what was deleted, array since 3 parameters
    private int deletedIndex; //to be used to remember the original position before being deleted
    private boolean undoable = true;

    @Override
    public boolean getUndoable() {
        return undoable;
    }

    public DeleteCommand(Receiver receiver, String param) {
        this.receiver = receiver;
        try {
            this.deletedIndex = Integer.parseInt(param);
        }  catch (NumberFormatException e) {
            this.deletedIndex = -1; // setting invalid index
        }
    }

    @Override
    public void execute() {
        if (deletedIndex == -1) {
            System.out.println("Please enter valid inputs");
        } else {
            try {
                //before deleting, grab and clone the data at index
                this.deletedData = receiver.dataStore.get(deletedIndex - 1).clone(); //-1 since arraylist starts from 0
                receiver.delete(deletedIndex);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Please enter valid inputs");
            }
        }
    }
    @Override
    //For Commands.DeleteCommand, undo restores the data from history
    public void undo() {
        try {
            receiver.dataStore.add(deletedIndex - 1, deletedData);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Please enter valid inputs");
        }
    }
}
