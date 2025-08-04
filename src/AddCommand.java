import java.util.Stack;

public class AddCommand implements Command {

    private Receiver receiver;
    private String firstName;
    private String lastName;
    private String emailAddress;



    private AddCommand(Receiver receiver, String param) {
        this.receiver = receiver;
        String[] splitParam = param.split(" ");
        this.firstName = splitParam[0];
        this.lastName = splitParam[1];
        this.emailAddress = splitParam[2];
    }

    @Override
    public void execute() {
//        Command.super.execute();
        receiver.add(firstName, lastName, emailAddress);
    }
}

