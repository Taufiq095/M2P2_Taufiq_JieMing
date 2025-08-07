import java.util.Arrays;

public class UpdateCommand implements Command {

    private Receiver receiver;
    private int index;
    private String[] param;
    private String[] oldData; //to remember the original contact data before updating
    private boolean undoable = true;

    @Override
    public boolean getUndoable() {
        return undoable;
    }

    public UpdateCommand(Receiver receiver, String input) {
        this.receiver = receiver;
        String[] splitInput = input.split(" ");
        this.param = new String[splitInput.length-1];
        try {
            // first parameter as integer index
            this.index = Integer.parseInt(splitInput[0]);
        } catch (NumberFormatException e) { // for invalid index input
            this.index = -1; // setting invalid index
        }

            // capitalising first letter of first name and last name
            for (int i =0; i < param.length; i++) {
                param[i] = splitInput[i+1];
            }
            // first letter of names to upper case
            for (int i=0; i < 1; i++) {
                param[i] = param[i].toLowerCase().substring(0, 1).toUpperCase() +
                        param[i].toLowerCase().substring(1);
            }
    }

    @Override
    public void execute() {
        receiver.update(index, param);
    }

    public void undo() {
        receiver.dataStore.set(index-1, oldData);
    }
}
