import java.util.Scanner;

class Vector2D {
    private double x, y;

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double calculateMagnitude() {
        return Math.sqrt(x * x + y * y);
    }

    public Vector2D add(Vector2D v) {
        return new Vector2D(this.x + v.x, this.y + v.y);
    }

    public Vector2D subtract(Vector2D v) {
        return new Vector2D(this.x - v.x, this.y - v.y);
    }

    public double dotProduct(Vector2D v) {
        return this.x * v.x + this.y * v.y;
    }

    public void displayVector() {
        System.out.println("(" + x + ", " + y + ")");
    }
}

public class Bai5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập tọa độ x của vector 1: ");
        double x1 = scanner.nextDouble();
        System.out.print("Nhập tọa độ y của vector 1: ");
        double y1 = scanner.nextDouble();

        System.out.print("Nhập tọa độ x của vector 2: ");
        double x2 = scanner.nextDouble();
        System.out.print("Nhập tọa độ y của vector 2: ");
        double y2 = scanner.nextDouble();

        Vector2D v1 = new Vector2D(x1, y1);
        Vector2D v2 = new Vector2D(x2, y2);

        System.out.print("\nVector 1: ");
        v1.displayVector();
        System.out.print("Vector 2: ");
        v2.displayVector();

        System.out.println("\nĐộ dài của vector 1: " + v1.calculateMagnitude());
        System.out.println("Độ dài của vector 2: " + v2.calculateMagnitude());

        Vector2D sumVector = v1.add(v2);
        System.out.print("\nTổng hai vector: ");
        sumVector.displayVector();

        Vector2D diffVector = v1.subtract(v2);
        System.out.print("Hiệu hai vector: ");
        diffVector.displayVector();

        System.out.println("\nTích vô hướng hai vector: " + v1.dotProduct(v2));

        scanner.close();
    }
}
