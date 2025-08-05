import java.util.Stack;

public class Client {
        public static void main(String[] args) {

            Stack<Command> history = new Stack<>();
            Receiver receiver = new Receiver();

            String addinput1 = "First_name Last_name Email";
            String addinput2 = "John Doe simple@example.com";
            String addinput3 = "Hanna Moon tetter.tots@potatoesarelife.com";
            String addinput4 = "Ah Boon green-tea@teaforlife.com";
            String updateinput5 = "3 Adam abc abc@email.com";
            String updateinput6 = "1 blue bell ice-cream@alaskaFields.org";
            String deleteinput7 = "1";

            AddCommand add1 = new AddCommand(receiver, addinput1);
            AddCommand add2 = new AddCommand(receiver, addinput2);
            AddCommand add3 = new AddCommand(receiver, addinput3);
            AddCommand add4 = new AddCommand(receiver, addinput4);

            UpdateCommand update5 = new UpdateCommand(receiver, updateinput5);
            UpdateCommand update6 = new UpdateCommand(receiver, updateinput6);

            DeleteCommand delete7 = new DeleteCommand(receiver, deleteinput7);

            ListCommand list = new ListCommand(receiver);
            UndoCommand undo = new UndoCommand(receiver);

            Command[] command1 = {add1, add2, add3, add4, list};
            Command[] command2 = {add1, add2, add3, add4, list, update5, list};
            Command[] command3 = {update6, list};
            Command[] command4 = {delete7, list};
            Command[] command5 = {undo, list};

            Invoker invoker = new Invoker();
//            invoker.setCommandsForExecution(command1);
            invoker.setCommandsForExecution(command2);
//            invoker.setCommandsForExecution(command3);
//            invoker.setCommandsForExecution(command4);
//            invoker.setCommandsForExecution(command5);
            invoker.executeCommand(history);

        }
    }