public class UndoCommand implements Command {

    private Receiver receiver;

    private UndoCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
//        Command.super.execute();
        receiver.undo();
    }
}
