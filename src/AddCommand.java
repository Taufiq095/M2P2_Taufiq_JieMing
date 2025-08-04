import java.util.Stack;

public class AddCommand implements Command {

    private Receiver receiver;

    private AddCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        Command.super.execute();
    }
}

