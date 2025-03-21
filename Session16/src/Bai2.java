import java.util.ArrayList;
import java.util.Iterator;

public class Bai2 {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();

        numbers.add(10);
        numbers.add(15);
        numbers.add(22);
        numbers.add(30);
        numbers.add(45);
        numbers.add(51);
        numbers.add(67);
        numbers.add(72);
        numbers.add(89);
        numbers.add(90);

        System.out.println("Danh sách ban đầu: " + numbers);

        Iterator<Integer> iterator = numbers.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() % 3 == 0) {
                iterator.remove();
            }
        }

        System.out.println("Danh sách sau khi xóa các số chia hết cho 3: " + numbers);
    }
}
