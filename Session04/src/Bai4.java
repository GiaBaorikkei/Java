import java.util.Scanner;

public class Bai4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tong = 0;
        int so;

        System.out.println("Nhập các số nguyên (nhập 0 để dừng):");

        while (true) {
            so = scanner.nextInt();

            if (so == 0) {
                break;
            }
            tong += so;
        }

        System.out.println("Tổng các số đã nhập: " + tong);

        scanner.close();
    }
}
