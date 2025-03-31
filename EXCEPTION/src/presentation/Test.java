package presentation;

import java.util.Scanner;
import static util.Validator.*;

public class Test {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Validate kiểu số nguyên");
            System.out.println("2. Validate kiểu số thực");
            System.out.println("3. Validate kiểu số thực double");
            System.out.println("4. Validate kiểu Boolean với giá trị nhập vào là true/false");
            System.out.println("5. Validate kiểu String (Không empty, cắt khoảng trắng, độ dài min-max)");
            System.out.println("6. Validate kiểu email");
            System.out.println("7. Validate kiểu phone (số điện thoại Việt Nam)");
            System.out.println("8. Thoát.");
            System.out.print("Lựa chọn của bạn: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Nhập vào số nguyên: ");
                    System.out.println("Kết quả: " + isValidInteger(scanner.nextLine()));
                    break;
                case 2:
                    System.out.print("Nhập vào số thực: ");
                    System.out.println("Kết quả: " + isValidFloat(scanner.nextLine()));
                    break;
                case 3:
                    System.out.print("Nhập vào số thực double: ");
                    System.out.println("Kết quả: " + isValidDouble(scanner.nextLine()));
                    break;
                case 4:
                    System.out.print("Nhập vào giá trị boolean (true/false): ");
                    System.out.println("Kết quả: " + isValidBoolean(scanner.nextLine()));
                    break;
                case 5:
                    System.out.print("Nhập vào chuỗi: ");
                    String str = scanner.nextLine();
                    System.out.println("Kết quả: " + isValidString(str, 3, 10));
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    System.out.println("Thoát chương trình.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }
}
