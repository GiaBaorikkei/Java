import java.util.HashSet;
import java.util.TreeSet;

public class Bai6 {
    public static void main(String[] args) {
        HashSet<Integer> set1 = new HashSet<>();
        set1.add(10);
        set1.add(20);
        set1.add(30);
        set1.add(40);

        HashSet<Integer> set2 = new HashSet<>();
        set2.add(30);
        set2.add(40);
        set2.add(50);
        set2.add(60);

        set1.retainAll(set2);

        TreeSet<Integer> sortedSet = new TreeSet<>(set1);

        System.out.println("Giao của hai tập hợp: " + sortedSet);
    }
}
