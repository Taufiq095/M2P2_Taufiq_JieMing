package Main;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.io.*;

public class Receiver {

    /**
     * A String arraylist to store first name, last name, and email.
     */
    public ArrayList<String[]> dataStore = new ArrayList<>();

    /**
     * Adds a new string array to the data store.
     *
     * @param firstName The first name
     * @param lastName  The last name
     * @param email     The email address
     */
    public void add(String firstName, String lastName, String email) {
        dataStore.add(new String[]{firstName, lastName, email});
    }

    /**
     * Updates an existing string in the data store at the specified index.
     * The `input` array should contain the new values for first name, last name, and email
     * in that order, but not necessarily having all the data types.
     *
     * Only specified data types will be updated. Un-updated data points will
     * remain unchanged.
     *
     * @param index The 1-based index of the entry to update.
     * @param input A `String` array containing the new first name, last name, and email.
     */
    public void update(int index, String[] input) {
            String newString = "# " + index;
            for (int i = 0; i < input.length; i++) {
                // print update string
                newString = newString.concat(" ").concat(input[i]);
                dataStore.get(index - 1)[i] = input[i];
            }
            System.out.println("update " + newString);
    }

    /**
     * Stores the current Arraylist to a file named "dataStore.txt"
     * located in the "src" file. The file will be created if it does not exist,
     *  Each contact entry consist of first name, last name, and email.
     */
    public void storeToFile() {
        Path filePath = Paths.get("src/dataStore.txt");

        try (BufferedWriter buff_writer = Files.newBufferedWriter(filePath, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)) {
            for(String[] line : this.dataStore) {
                buff_writer.write(line[0] + " " + line[1] + " " + line[2]);
                buff_writer.newLine();
            }
//            System.out.println("Data saved successfully to: " + String.valueOf(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Lists all String currently in the datastore.
     * Each entry is indexed and displays the first name, last name, and email.
     */
    public void list() {
        for (int i=0; i<dataStore.size(); i++) {
            System.out.printf("%02d. ", i+1);
            for  (int j=0; j<dataStore.get(i).length; j++) {
                System.out.print(dataStore.get(i)[j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Deletes a String from the data store at the specified index.
     *
     * @param index The index of the entry to delete (counting from 1).
     */
    public void delete(int index) {
        dataStore.remove(index-1);
    }
}

