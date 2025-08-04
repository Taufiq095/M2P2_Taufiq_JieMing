public class DeleteCommand implements Command {

    private Receiver receiver;

    private DeleteCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        Command.super.execute();
    }

}
