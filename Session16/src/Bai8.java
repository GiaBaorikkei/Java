import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Bai8 {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();

        strings.add("banana");
        strings.add("apple");
        strings.add("kiwi");
        strings.add("strawberry");
        strings.add("cherry");
        strings.add("blueberry");
        strings.add("pear");

        System.out.println("Danh sách ban đầu: " + strings);

        Collections.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (s1.length() != s2.length()) {
                    return Integer.compare(s1.length(), s2.length());
                }
                return s1.compareTo(s2);
            }
        });

        System.out.println("Danh sách sau khi sắp xếp: " + strings);
    }
}
