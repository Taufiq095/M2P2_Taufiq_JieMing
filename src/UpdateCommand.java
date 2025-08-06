import java.util.Arrays;

public class UpdateCommand implements Command {

    private Receiver receiver;
    private int index;
    private String[] param = new String[3];
    private String[] oldData; //to remember the original contact data before updating
    private boolean undoable = true;

    @Override
    public boolean getUndoable() {
        return undoable;
    }

    public UpdateCommand(Receiver receiver, String input) {
        this.receiver = receiver;
        String[] splitInput = input.split(" ");
        try {
            // first parameter as integer index
            this.index = Integer.parseInt(splitInput[0]);
        }  catch (NumberFormatException e) {
            this.index = -1; // setting invalid index
        }
        try {
            for (int i = 1; i < splitInput.length; i++) {
                param[i - 1] = splitInput[i].toLowerCase().substring(0, 1).toUpperCase() +
                        splitInput[i].toLowerCase().substring(1);
                ;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index = -1;
        }

        // ! CHECK FOR VALID EMAIL INPUT (REGEX)
    }

    @Override
    public void execute() {
        if (index == -1) {
            System.out.println("Please enter valid inputs");
        } else {
            receiver.update(index, param);
        }
    }

    public void undo() {
        receiver.dataStore.set(index-1, oldData);
    }
}
