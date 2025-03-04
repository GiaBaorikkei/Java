import java.util.Scanner;

public class Bai8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N;

        while (true) {
            System.out.print("Nhập số nguyên dương N: ");
            if (scanner.hasNextInt()) {
                N = scanner.nextInt();
                if (N > 0) break;
            } else {
                scanner.next();
            }
            System.out.println("Số nhập vào không hợp lệ. Vui lòng nhập lại.");
        }

        System.out.println("Các số Armstrong từ 1 đến " + N + " là:");
        for (int i = 1; i <= N; i++) {
            if (laSoArmstrong(i)) {
                System.out.print(i + " ");
            }
        }

        scanner.close();
    }

    public static boolean laSoArmstrong(int num) {
        int originalNum = num;
        int soChuSo = demChuSo(num);
        int tong = 0;

        while (num > 0) {
            int chuSo = num % 10;
            tong += Math.pow(chuSo, soChuSo);
            num /= 10;
        }

        return tong == originalNum;
    }

    public static int demChuSo(int num) {
        return String.valueOf(num).length();
    }
}
