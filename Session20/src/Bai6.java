import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Bai6 {
    public static void main(String[] args) {
        List<String> items = List.of("apple", "banana", "apple", "orange", "banana", "apple");

        LocalDateTime now = LocalDateTime.now();
        String formattedDateTime = now.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));

        Map<String, Long> frequencyMap = items.stream()
                .collect(Collectors.groupingBy(item -> item, Collectors.counting()));

        System.out.println("Thời điểm xử lý: " + formattedDateTime);
        System.out.println(frequencyMap);
    }
}
