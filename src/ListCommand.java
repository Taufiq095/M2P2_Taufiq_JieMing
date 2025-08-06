public class ListCommand implements Command {

    private Receiver receiver;

    public ListCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.list();
    }

    @Override
    public String toString() {
        return "list";
    }

}
