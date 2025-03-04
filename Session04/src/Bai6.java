import java.util.Scanner;

public class Bai6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số nguyên N: ");
        int N = scanner.nextInt();
        int soDuong = Math.abs(N);
        int tong = 0;
        while (soDuong > 0) {
            tong += soDuong % 10;
            soDuong /= 10;
        }

        System.out.println("Tổng các chữ số của " + N + " là: " + tong);
        scanner.close();
    }
}
