import java.util.Arrays;

public class UpdateCommand implements Command {

    private Receiver receiver;
    private int index;
    private String[] param = new String[3];
    private String[] oldData; //to remember the original contact data before updating
    private boolean undoable = true;

    public boolean getUndoable() {
        return undoable;
    }

    public UpdateCommand(Receiver receiver, String input) {
        this.receiver = receiver;
        String[] splitInput = input.split(" ");
        this.index = Integer.parseInt(splitInput[0]);
        for (int i = 1; i < splitInput.length; i++) {
            param[i-1] = splitInput[i];
        }
    }

    @Override
    public void execute() {
//        receiver.update(index, param[0], param[1], param[2]);
        receiver.update(index, param);
    }

    public void undo() {
        receiver.dataStore.set(index-1, oldData);
    }
}
