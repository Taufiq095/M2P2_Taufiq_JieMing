package Commands;

import Helper.EmailChecker;
import Helper.InvalidInputsException;
import Main.Command;
import Main.Receiver;

public class AddCommand implements Command {

    private Receiver receiver;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private int addedIndex;
    private String[] splitParam;
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
            this.emailAddress = splitParam[2];
            firstName = firstName.toLowerCase().substring(0, 1).toUpperCase() +
                    firstName.toLowerCase().substring(1);

            lastName = lastName.toLowerCase().substring(0, 1).toUpperCase() +
                    lastName.toLowerCase().substring(1);

            if (!EmailChecker.isValidEmail(emailAddress)) {
                throw new InvalidInputsException("Please enter valid inputs");
            }
            receiver.add(firstName, lastName, emailAddress); //the end of
            // datastore
            addedIndex = receiver.dataStore.size();
    }

    @Override
    public void undo() {
        receiver.delete(addedIndex); //deleting the last added item in datastore

    }
}

