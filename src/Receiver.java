import java.util.ArrayList;
import java.util.Stack;

public class Receiver {

    ArrayList<String> dataStore = new ArrayList<>();

    // ! need to add throw exceptions for incorrect data type entry
    public void add(String firstName, String lastName, String email) {
        dataStore.add(firstName + " " + lastName + " " + email);
    }

    // ! THIS CURRENT ITERATION DOES NOT WORK, NEED TO EDIT
    // ! use regex to count spaces to replace firstName/lastName/email
    public void update(int index, String stringInput) {
        String[] newString = stringInput.split(" ");
        for (int i = 0; i < newString.length; i++) {
            dataStore.set(index - 1, newString[i]);
        }
    }

    public void list() {
        for (int i=0; i<dataStore.size(); i++) {
            System.out.printf("%02d. " + dataStore.get(i) + "%n", i+1);
        }
    }
    //method for delete
    public void delete(int index) {
        dataStore.remove(index-1);
    }

    //method to undo
    // ! implement command stack
    public void undo() {
//        dataStore.clear();

    }

}
