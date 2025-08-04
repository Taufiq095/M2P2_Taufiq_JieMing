import java.util.ArrayList;

public class Receiver {

    // ! type casting of this arraylist might be wrong?
    ArrayList<String> dataStore = new ArrayList<>();

    public void Add(String firstName, String lastName, String email) {
        dataStore.add(firstName + " " + lastName + " " + email);
    }

    public void Update(int index, String newString) {


    }

    public void List() {}

    public void Delete() {}

    public void Undo() {}

}
