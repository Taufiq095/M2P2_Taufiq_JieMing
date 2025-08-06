import java.util.regex.Pattern;

public class AddCommand implements Command {

    private Receiver receiver;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private int addedIndex;
    private boolean undoable = true;

    //email validation using REGEX, local before @, domain after @
    private static final String localEmail_REGEX = "[a-zA-Z._-]+@[a-z-]+$";
//   private static final String domainEmail_REGEX = JM to fill in this REGEX

    private static final Pattern local_Pattern = Pattern.compile(localEmail_REGEX);
//    private static final Pattern domain_Pattern = Pattern.compile(domainEmail_REGEX);

    //check validity of email

    private boolean isValidEmail (String email) {
        if (email == null || email.isEmpty()) {
            System.err.println("Email is empty!");
            return false;
        }
        String[] parts = email.split("@");

        if (parts.length != 2) {
            System.out.println("Email must contain only one @.");
            return false;
        }
        String localpart = parts[0];
        String domainpart = parts[1];
        return true;
    }

    private boolean validateLocalPart (String localpart) {
        if (localpart == null || localpart.isEmpty()) {
            System.out.println("Local part cannot be empty!.");
            return false;
        }

        if (!local_Pattern.matcher(localpart).matches()) {
            System.out.println("Invalid characters in email local part");
            return false;
        }
        return true;
    }

    @Override
    public boolean getUndoable() {
        return undoable;
    }

    public AddCommand(Receiver receiver, String param) {
        this.receiver = receiver;
        String[] splitParam = param.split(" ");
        if (splitParam.length != 3) {
            System.out.println("Wrong number of parameters");
        } else {
            this.firstName = splitParam[0];
            this.lastName = splitParam[1];
            this.emailAddress = splitParam[2];
        }

        firstName = firstName.toLowerCase().substring(0, 1).toUpperCase() +
                firstName.toLowerCase().substring(1);

        lastName = lastName.toLowerCase().substring(0, 1).toUpperCase() +
                lastName.toLowerCase().substring(1);

    }

    @Override
    public void execute() {
        // ! CHECK FOR VALID EMAIL INPUT (REGEX)
        receiver.add(firstName, lastName, emailAddress); //the end of datastore
        addedIndex = receiver.dataStore.size(); //get the size right after adding
    }

    @Override
    public void undo() {
        receiver.delete(addedIndex); //deleting the last added item in datastore

    }
}

