import java.util.ArrayList;
import java.util.Arrays;

public class Client {
        public static void main(String[] args) {
//            ArrayList<Integer> a = new ArrayList();
//            a.add(10);
//            a.add(20);
//            a.add(30);
//            for  (int i=0; i<a.size(); i++) {
//                System.out.printf("%02d. " + a.get(i) + "%n", i+1);
//            }
//            System.out.println("removing index 1 (ie s/n 2)");
//            a.remove(1);
//            for  (int i=0; i<a.size(); i++) {
//                System.out.printf("%02d. " + a.get(i) + "%n", i+1);
//           }

            ArrayList<String> b = new ArrayList<>();
            b.add("jon doe");
            b.add("silver eagle");
            b.add("gold dee roger");

            // replacing gold and dee with one and piece.
            // output should be one piece roger
            String input = "one piece";
            String[] newString = input.split(" ");
            System.out.println(b.get(2));
            for (int i = 0; i < newString.length; i++) {
                b.set(2, newString[i]);
            }
            System.out.println(b.get(2));

    }
}