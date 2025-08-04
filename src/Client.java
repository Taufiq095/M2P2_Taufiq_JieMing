import java.util.ArrayList;
//driver class to test


public class Client {
        public static void main(String[] args) {
            ArrayList<Integer> a = new ArrayList();
            AddCommand add = new AddCommand(receiver, "Taufiq Rahmat emailaddress@gmail.com");

            a.add(10);
            a.add(20);
            a.add(30);
            for  (int i=0; i<a.size(); i++) {
                System.out.printf("%02d. " + a.get(i) + "%n", i+1);
            }
            System.out.println("removing index 1 (ie s/n 2)");
            a.remove(1);
            for  (int i=0; i<a.size(); i++) {
                System.out.printf("%02d. " + a.get(i) + "%n", i+1);
           }
    }
}