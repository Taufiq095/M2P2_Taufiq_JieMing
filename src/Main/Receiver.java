package Main;

import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.io.*;

public class Receiver {

    public ArrayList<String[]> dataStore = new ArrayList<>();

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
        Path filePath = Paths.get("src/dataStore.txt");

        try (BufferedWriter buff_writer = Files.newBufferedWriter(filePath, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)) {
            for(String[] line : this.dataStore) {
                buff_writer.write(line[0] + " " + line[1] + " " + line[2]);
                buff_writer.newLine();
            }

            System.out.println("Data saved successfully to: " + String.valueOf(filePath));
        } catch (IOException e) {
            e.printStackTrace();
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

