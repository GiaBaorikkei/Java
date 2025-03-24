import java.util.HashSet;
import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        HashSet<String> languages = new HashSet<>();
        languages.add("Java");
        languages.add("Python");
        languages.add("C++");
        languages.add("JavaScript");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập ngôn ngữ cần kiểm tra: ");
        String input = scanner.nextLine();

        if (languages.contains(input)) {
            System.out.println("Phần tử \"" + input + "\" tồn tại trong HashSet.");
        } else {
            System.out.println("Phần tử \"" + input + "\" không tồn tại trong HashSet.");
        }

        scanner.close();
    }
}
