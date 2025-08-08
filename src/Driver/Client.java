package Driver;

import Commands.*;
import Main.Command;
import Main.Invoker;
import Main.Receiver;

import java.util.Stack;

import static Helper.EmailChecker.isValidEmail;

public class Client {
        public static void main(String[] args) {

            Stack<Command> history = new Stack<>();
            Receiver receiver = new Receiver();

            String addinput1 = "First_name Last_name Email@emial.com";
            String addinput2 = "joHn dOe simple@example.com";
            String addinput3 = "Hanna Moon tetter.tots@pota###toesarelife.com";
            String addinput4 = "Ah green-tea@teaforlife.com";
            String addinput5 = "ching uyguyg joel joelching@Hotmail.com";
            String addinput6 = "ching joel joel@ching@Hotmail.com ghjghjghj";
            String addinput7 = "valid input valid@input.com";

            AddCommand add1 = new AddCommand(receiver, addinput1);
            AddCommand add2 = new AddCommand(receiver, addinput2);
            AddCommand add3 = new AddCommand(receiver, addinput3);
            AddCommand add4 = new AddCommand(receiver, addinput4);
            AddCommand add5 = new AddCommand(receiver, addinput5);
            AddCommand add6 = new AddCommand(receiver, addinput6);
            AddCommand add7 = new AddCommand(receiver, addinput7);

            String updateinput5 = "1 Adam";
            String updateinput6 = "al bLUe bELl ice-cream@alaskaF@@ields.org ";
            String updateinput7 = "5 daniel negreanu dndn@email.commmm daniel";
            String updateinput8 = "02 daniel";
            UpdateCommand update5 = new UpdateCommand(receiver, updateinput5);
            UpdateCommand update6 = new UpdateCommand(receiver, updateinput6);
            UpdateCommand update7 = new UpdateCommand(receiver, updateinput7);
            UpdateCommand update8 = new UpdateCommand(receiver, updateinput8);

            String deleteinput7 = "666";
            String deleteinput8 = "abc";
            String deleteinput9 = "$$$";
            DeleteCommand delete7 = new DeleteCommand(receiver, deleteinput7);
            DeleteCommand delete8 = new DeleteCommand(receiver, deleteinput8);
            DeleteCommand delete9 = new DeleteCommand(receiver, deleteinput9);

            ListCommand list = new ListCommand(receiver);
            UndoCommand undo = new UndoCommand(receiver, history);

            Command[] command = {
                    add1, add2, list,
                    add3, add4, list,
                    add5, add6,
                    add7, list,
                    update5, list,
                    update6, list,
                    delete7, list,
                    update7, list,
                    update8, list,
                    undo, list,
                    delete8, list,
                    delete9, list
            };

            Invoker invoker = new Invoker();
            invoker.setCommandsForExecution(command);
            invoker.executeCommand(history);
            receiver.storeToFile();
//            testEmails();
            }


//    public static void testEmails() {
//        System.out.println("-----VALID EMAILS------");
//        isValidEmail("normalEmail@email.com");
//        isValidEmail("ALLCAPS@email.com");
//        isValidEmail("1234@email.com");
//        isValidEmail("1234.this.is.valid.56@email.com");
//        isValidEmail("test-dash@email.com");
//        isValidEmail("test.fullstop@email.com");
//        isValidEmail("test_underscore@email.com");
//        isValidEmail("test-dash@email.com");
//        isValidEmail("test.v_a-riations@email.com");
//        isValidEmail("_test.v_a-riations@email.com");
//        isValidEmail("test.v_a-riations@email.com");
//        isValidEmail("test.v_a-ria__tions@email.com");
//        isValidEmail("TEST.V_A-RIA__TIONS@email.com");
//        isValidEmail("abcde@xyz.co");
//        isValidEmail("abcde@xyz123.co");
//        isValidEmail("abcde@valid.url.ab");
//        isValidEmail("abcde@valid.url.com");
//        isValidEmail("abcde@valid.url.com");
//        isValidEmail("a1.b-2_3.xyz@some-thin-g.com");
//        isValidEmail("a1.b-2_3.xyz@some-THinGG-g.com");
//        isValidEmail("a1.b-2_3.xyz@SOME-thing.com");
//        isValidEmail("A1.B-2_3.XYZ@SOME-thing.com");
//        isValidEmail("a1.b-2_3.xyz@99-123.com");
//        isValidEmail("_@email.com");
//        isValidEmail("1@email.com");
//        isValidEmail("_1@email.com");
//
//        System.out.println("---------INVALID EMAILS----------");
//
//        isValidEmail("invalid@email.COM");
//        isValidEmail("invalid@email.cOm");
//        isValidEmail("invalid@e_email.com");
//        isValidEmail("invalid!@email.com");
//        isValidEmail("invalid#@email.com");
//        isValidEmail("inva%lid@email.com");
//        isValidEmail("inva(%)lid@email.com");
//        isValidEmail("invalid@email.comm");
//        isValidEmail("-invalid@email.com");
//        isValidEmail("invalid-@email.com");
//        isValidEmail("in valid@email.com");
//        isValidEmail("-.invalid-@email.com");
//        isValidEmail("-.invalid-@email.com");
//        isValidEmail(".invalid@email.com");
//        isValidEmail("invalid.@email.com");
//        isValidEmail(".invalid.@email.com");
//        isValidEmail("domainIssue@.email.com");
//        isValidEmail("domainIssue@email.com.");
//        isValidEmail("domainIssue@-email.com-");
//        isValidEmail("domainIssue@email..com-");
//        isValidEmail("domainIssue@ema--il..com-");
//        isValidEmail("-@email.com");
//        isValidEmail(".@email.com");
//        isValidEmail("._@email.com");
//        isValidEmail("hi");
//        isValidEmail("hi@");
//        isValidEmail("hi@.com");
//        isValidEmail("hi@emailcom");
//        isValidEmail(" ");
//    }
    }
    
    