import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Receiver {

    ArrayList<String[]> dataStore = new ArrayList<>();

    public void add(String firstName, String lastName, String email) {
        System.out.println("add");
        dataStore.add(new String[]{firstName, lastName, email});
    }

    public void update(int index, String firstName, String lastName, String email) {
        String[] newData = {firstName, lastName, email};
        System.out.println("update");
        dataStore.set(index-1, newData);
        for (int i = 0; i < newData.length; i++) {
            if (newData[i] == null) {
            } else {
//                dataStore.get(index)[i] = (newData[i]);
                String[i] =
            }
        }
    }

    public void list() {
        System.out.println("List");
        for (int i=0; i<dataStore.size(); i++) {
            for  (int j=0; j<dataStore.get(i).length; j++) {
                System.out.print(dataStore.get(i)[j] + " ");
            }
            System.out.println();
        }
    }
    //method for delete
    public void delete(int index) {
        System.out.println("Delete");
        dataStore.remove(index-1);
    }

    public void undo() {
        System.out.println("Undo");

    }
}

