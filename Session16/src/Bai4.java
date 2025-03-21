import java.util.ArrayList;

public class Bai4 {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();

        numbers.add(10);
        numbers.add(25);
        numbers.add(15);
        numbers.add(40);
        numbers.add(30);

        System.out.println("Danh sách số nguyên: " + numbers);

        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }

        System.out.println("Tổng các phần tử trong danh sách: " + sum);
    }
}
