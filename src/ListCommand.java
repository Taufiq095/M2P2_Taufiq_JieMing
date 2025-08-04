public class ListCommand implements Command {

    private Receiver receiver;

    private ListCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        Command.super.execute();
    }

}
