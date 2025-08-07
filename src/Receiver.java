import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Receiver {

    ArrayList<String[]> dataStore = new ArrayList<>();

    public void add(String firstName, String lastName, String email) {
        System.out.println("add");
        dataStore.add(new String[]{firstName, lastName, email});
    }

    public void update(int index, String[] input) {
//        try {
//            String newString = "# " + index;
//            for (int i = 0; i < input.length; i++) {
//                newString = newString.concat(" ").concat(input[i]);
//                dataStore.get(index - 1)[i] = input[i];
//            }
//            System.out.println("update " + newString);
//        } catch (IndexOutOfBoundsException e) {
//            System.out.println("Please enter valid inputs");
//        }

        System.out.println(input.length);
        if (index == -1) {
            System.out.println("Please enter valid input");
        } else if (index < dataStore.size()) {
            System.out.println("Please enter valid index");
        } else if (input.length == 3) {// has email input
                if (!EmailChecker.isValidEmail(input[2])) { // email check
                    System.out.println("Please enter valid email");
                }
            }
            //inputs all valid
            String newString = "# " + index;
            for (int i = 0; i < input.length; i++) {
                // print update string
                newString = newString.concat(" ").concat(input[i]);
                dataStore.get(index - 1)[i] = input[i];
            }
            System.out.println("update " + newString);
        }



    public void list() {
        System.out.println("List");
        for (int i=0; i<dataStore.size(); i++) {
            System.out.printf("%02d. ", i+1);
            for  (int j=0; j<dataStore.get(i).length; j++) {
                System.out.print(dataStore.get(i)[j] + " ");
            }
            System.out.println();
        }
    }

    public void delete(int index) {
        System.out.println("Delete # " + index);
        dataStore.remove(index-1);
    }

//    undo logic put in UndoCommand class
//    public void undo() {
//        System.out.println("Undo");
}

