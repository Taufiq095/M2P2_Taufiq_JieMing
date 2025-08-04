import java.util.ArrayList;

public class Receiver {

    ArrayList<String> dataStore = new ArrayList<>();

    // ! need to add throw exceptions for incorrect data type entry
    public void add(String firstName, String lastName, String email) {
        dataStore.add(firstName + " " + lastName + " " + email);
    }

    // ! use regex to count spaces to replace firstName/lastName/email
    public void update(int index, String newString) {
        dataStore.add(index - 1, newString);
    }

    public void list() {
        for (int i=0; i<dataStore.size(); i++) {
            System.out.printf("%02d. " + dataStore.get(i) + "%n", i+1);
        }
    }


    public void delete(int index) {
        dataStore.remove(index-1);
    }

    // ! implement command stack
    public void undo() {

    }

}
