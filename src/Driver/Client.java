package Driver;

import Commands.*;
import Helper.InvalidInputsException;
import Main.Command;
import Main.Invoker;
import Main.Receiver;

import java.util.Stack;

public class Client {
        public static void main(String[] args) throws InvalidInputsException {

            Stack<Command> history = new Stack<>();
            Receiver receiver = new Receiver();

            String addinput1 = "First_name Last_name Email";
            String addinput2 = "joHn dOe simple@example.com";
            String addinput3 = "Hanna Moon tetter.tots@pota###toesarelife.com";
            String addinput4 = "Ah Boon green-tea@teaforlife.com";
            String addinput5 = "ching joel joelching@Hotmail.com";
            String addinput6 = "ching joel joel@ching@Hotmail.com";

            AddCommand add1 = new AddCommand(receiver, addinput1);
            AddCommand add2 = new AddCommand(receiver, addinput2);
            AddCommand add3 = new AddCommand(receiver, addinput3);
            AddCommand add4 = new AddCommand(receiver, addinput4);
            AddCommand add5 = new AddCommand(receiver, addinput5);
            AddCommand add6 = new AddCommand(receiver, addinput6);

            String updateinput5 = "500 Adam";
            String updateinput6 = "al bLUe bELl ice-cream@alaskaF@@ields.org ";
            String updateinput7 = "5 daniel negreanu dndn@email.commmm daniel";
            UpdateCommand update5 = new UpdateCommand(receiver, updateinput5);
            UpdateCommand update6 = new UpdateCommand(receiver, updateinput6);
            UpdateCommand update7 = new UpdateCommand(receiver, updateinput7);

            String deleteinput7 = "666";
            String deleteinput8 = "abc";
            String deleteinput9 = "$$$";
            DeleteCommand delete7 = new DeleteCommand(receiver, deleteinput7);
            DeleteCommand delete8 = new DeleteCommand(receiver, deleteinput8);
            DeleteCommand delete9 = new DeleteCommand(receiver, deleteinput9);

            ListCommand list = new ListCommand(receiver);
            UndoCommand undo = new UndoCommand(receiver, history);

            Command[] command = {add1, add2, add3, add4, add5, add6, list,
                    update5, list,
                    update6, list,
                    delete7, list,
                    update7, list,
                    undo, list,
                    delete8, list,
                    delete9, list
            };

            Invoker invoker = new Invoker();
            invoker.setCommandsForExecution(command);
            invoker.executeCommand(history);
            receiver.storeToFile(); //Save everything at once

        }
    }