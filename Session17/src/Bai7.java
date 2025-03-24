import java.util.*;

public class Bai7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập đoạn văn bản:");
        String text = scanner.nextLine();
        scanner.close();

        String[] words = text.toLowerCase().split("\\W+");

        Map<String, Integer> wordCountMap = new TreeMap<>();

        for (String word : words) {
            if (!word.isEmpty()) {
                wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
            }
        }

        System.out.println("Thống kê từ xuất hiện:");
        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
