import java.util.Arrays;

public class UpdateCommand implements Command {

    private Receiver receiver;
    private int index;
//    private String firstName;
//    private String lastName;
//    private String email;
    private String[] param = new String[3];


    public UpdateCommand(Receiver receiver, String input) {
        Arrays.fill(param, null);
        this.receiver = receiver;
        String[] splitInput = input.split(" ");
        this.index = Integer.parseInt(splitInput[0]);
        for (int i = 1; i < splitInput.length; i++) {
            param[i-1] = splitInput[i];
        }
    }

    @Override
    public void execute() {
        receiver.update(index, param[0], param[1], param[2]);
    }

}
