package Commands;

import Helper.Data3Checker;
import Helper.InvalidInputsException;
import Main.Command;
import Main.Receiver;

public class AddCommand implements Command {

    private Receiver receiver;
    private String firstName;
    private String lastName;
    private String data3String;
    private int addedIndex;
    private String[] splitParam;

    /**
     * Returns whether this command is undoable.
     *
     * @return {@code true} if the command can be undone, {@code false} otherwise.
     */
    private boolean undoable = true;


    @Override
    public boolean getUndoable() {
        return undoable;
    }

    public AddCommand(Receiver receiver, String param) {
        this.receiver = receiver;
        splitParam = param.split(" ");

    }

    @Override
    public void execute() throws InvalidInputsException {
            this.firstName = splitParam[0];
            this.lastName = splitParam[1];
            this.data3String = splitParam[2];
            firstName = firstName.toLowerCase().substring(0, 1).toUpperCase() +
                    firstName.toLowerCase().substring(1);

            lastName = lastName.toLowerCase().substring(0, 1).toUpperCase() +
                    lastName.toLowerCase().substring(1);

            if (!Data3Checker.isValidEmail(data3String) && !Data3Checker.isValidData3String(data3String)) {
                throw new InvalidInputsException("Please enter valid inputs");
            }

            if (!Data3Checker.isValidEmail(data3String)) {
                if (!Data3Checker.isValidData3String(data3String)) {
                    throw new InvalidInputsException("Please enter valid inputs");
                } else data3String = data3String.toLowerCase().substring(0, 1).toUpperCase() +
                        data3String.toLowerCase().substring(1);
            }

            receiver.add(firstName, lastName, data3String); //the end of
            // datastore
            addedIndex = receiver.dataStore.size();
    }

    @Override
    public void undo() {
        receiver.dataStore.remove(addedIndex-1);
    }
}

