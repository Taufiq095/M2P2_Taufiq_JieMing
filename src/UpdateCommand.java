public class UpdateCommand implements Command {

    private Receiver receiver;

    private UpdateCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        Command.super.execute();
    }

}
