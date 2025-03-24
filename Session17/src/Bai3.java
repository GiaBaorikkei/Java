import java.util.HashSet;
import java.util.Iterator;

public class Bai3 {
    public static void main(String[] args) {
        HashSet<Integer> numbers = new HashSet<>();
        for (int i = 1; i <= 10; i++) {
            numbers.add(i);
        }

        Iterator<Integer> iterator = numbers.iterator();
        while (iterator.hasNext()) {
            int num = iterator.next();
            if (num % 2 == 0) {
                iterator.remove();
            }
        }

        System.out.println("HashSet sau khi xóa các số chẵn: " + numbers);
    }
}
