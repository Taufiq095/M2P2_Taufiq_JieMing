package Main;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.io.*;

public class Receiver {

    public ArrayList<String[]> dataStore = new ArrayList<>();
    private static final String FILE_PATH = "src/SavedFiles/dataStore.txt";

    public void add(String firstName, String lastName, String email) {
        System.out.println("add");
        dataStore.add(new String[]{firstName, lastName, email});
    }

    public void update(int index, String[] input) {
            String newString = "# " + index;
            for (int i = 0; i < input.length; i++) {
                // print update string
                newString = newString.concat(" ").concat(input[i]);
                dataStore.get(index - 1)[i] = input[i];
            }
            System.out.println("update " + newString);
    }

        public void storeToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_PATH))) {
            for (String [] data : dataStore) {
                writer.println(data[0] + " " + data[1] + " " + data[2]);
            }
            System.out.println("Data successfully saved to  " + FILE_PATH);
        }
        catch (IOException e) {
            System.out.println("Error saving data to " + FILE_PATH);
        }

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

}

