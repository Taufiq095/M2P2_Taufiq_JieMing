import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList();
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