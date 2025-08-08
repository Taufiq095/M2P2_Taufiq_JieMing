package Commands;

import Helper.EmailChecker;
import Helper.InvalidInputsException;
import Main.Command;
import Main.Receiver;

public class UpdateCommand implements Command {

    private Receiver receiver;
    private int index;
    private String[] param;
    String[]splitInput;
    private String[] oldData; //to remember the original contact data before updating
    private boolean undoable = true;

    @Override
    public boolean getUndoable() {
        return undoable;
    }

    public UpdateCommand(Receiver receiver, String input) {
        this.receiver = receiver;
        splitInput = input.split(" ");
//        this.param = new String[splitInput.length-1];
//            // capitalising first letter of first name and last name
//            for (int i =0; i < param.length; i++) {
//                param[i] = splitInput[i+1];
//            }
    }

    @Override
    public void execute() throws InvalidInputsException {
        try {
            // first parameter as integer index
            this.index = Integer.parseInt(splitInput[0]);
        } catch (NumberFormatException e) { // for invalid index input
           throw new InvalidInputsException("Please enter valid inputs"); //
            // setting invalid
            // index
        }
        try {
            this.param = new String[splitInput.length - 1];
            // capitalising first letter of first name and last name
            for (int i = 0; i < param.length; i++) {
                param[i] = splitInput[i + 1];
            }
        } catch (NegativeArraySizeException e) {
            throw new InvalidInputsException("Please enter a valid index");
        }
        try {
            for (int i = 0; i < 1; i++) {
                param[i] = param[i].toLowerCase().substring(0, 1).toUpperCase() +
                        param[i].toLowerCase().substring(1);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new InvalidInputsException("Please enter valid inputs");
        }
//        this.index = Integer.parseInt(splitInput[0]);
        if (index > receiver.dataStore.size()) {
            throw new InvalidInputsException("Please enter a valid index");
        }
        if (param.length == 2) {
            if (!EmailChecker.isValidEmail(param[2])) {
                throw new InvalidInputsException("Please enter valid inputs");
            }
        }
        receiver.update(index, param);
    }

    public void undo() {
        receiver.dataStore.set(index-1, oldData);
    }
}
