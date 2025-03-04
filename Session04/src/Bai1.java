import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập một số nguyên dương N: ");
        int N = scanner.nextInt();

        if (N <= 0) {
            System.out.println("Số nhập vào không hợp lệ");
        } else {
            int sum = 0;

            for (int i = 1; i <= N; i++) {
                sum += i;
            }

            System.out.println("Tổng các số từ 1 đến " + N + " là: " + sum);
        }
        scanner.close();
    }
}
