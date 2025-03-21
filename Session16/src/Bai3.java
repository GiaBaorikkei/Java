import java.util.ArrayList;
import java.util.Collections;

public class Bai3 {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();

        numbers.add(12);
        numbers.add(45);
        numbers.add(7);
        numbers.add(89);
        numbers.add(23);
        numbers.add(56);
        numbers.add(3);
        numbers.add(98);

        System.out.println("Danh sách số nguyên: " + numbers);

        int max = Collections.max(numbers);
        int min = Collections.min(numbers);

        System.out.println("Phần tử lớn nhất: " + max);
        System.out.println("Phần tử nhỏ nhất: " + min);
    }
}

