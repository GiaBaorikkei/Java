import java.util.List;
import java.util.Optional;

public class Bai5 {
    public static Optional<Integer> findSecondLargest(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .sorted((a, b) -> Integer.compare(b, a))
                .skip(1)
                .findFirst();
    }

    public static void main(String[] args) {
        List<Integer> normalList = List.of(10, 5, 8, 20, 7);
        List<Integer> singleElementList = List.of(10);
        List<Integer> allSameList = List.of(10, 10, 10);

        printResult(normalList);
        printResult(singleElementList);
        printResult(allSameList);
    }

    private static void printResult(List<Integer> numbers) {
        Optional<Integer> secondLargest = findSecondLargest(numbers);
        System.out.println("Danh sách: " + numbers);
        if (secondLargest.isPresent()) {
            System.out.println("Số lớn thứ 2 là: " + secondLargest.get());
        } else {
            System.out.println("Không tìm thấy số lớn thứ hai");
        }
    }
}
