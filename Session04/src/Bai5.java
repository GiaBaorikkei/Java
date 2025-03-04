import java.util.Scanner;

public class Bai5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số nguyên dương N: ");
        int N = scanner.nextInt();

        if (N <= 0) {
            System.out.println("Số nhập vào không hợp lệ.");
        } else {
            System.out.println("Các số hoàn hảo nhỏ hơn " + N + " là:");
            for (int i = 1; i < N; i++) {
                if (laSoHoanHao(i)) {
                    System.out.print(i + " ");
                }
            }
        }

        scanner.close();
    }

    public static boolean laSoHoanHao(int num) {
        int tongUoc = 0;

        for (int i = 1; i <= num / 2; i++) {
            if (num % i == 0) {
                tongUoc += i;
            }
        }

        return tongUoc == num;
    }
}
