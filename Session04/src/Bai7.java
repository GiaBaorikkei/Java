import java.util.Scanner;
import java.util.HashSet;

public class Bai7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số nguyên dương N: ");
        int N = scanner.nextInt();

        if (N <= 0) {
            System.out.println("Số nhập vào không hợp lệ.");
        } else {
            System.out.println("Các số Happy từ 1 đến " + N + " là:");
            for (int i = 1; i <= N; i++) {
                if (laSoHappy(i)) {
                    System.out.print(i + " ");
                }
            }
        }

        scanner.close();
    }

    public static boolean laSoHappy(int num) {
        HashSet<Integer> daGap = new HashSet<>();

        while (num != 1 && !daGap.contains(num)) {
            daGap.add(num);
            num = tinhTongBinhPhuongChuSo(num);
        }

        return num == 1;
    }

    public static int tinhTongBinhPhuongChuSo(int num) {
        int tong = 0;
        while (num > 0) {
            int chuSo = num % 10;
            tong += chuSo * chuSo;
            num /= 10;
        }
        return tong;
    }
}
