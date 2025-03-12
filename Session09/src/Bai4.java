import java.util.Scanner;

class Circle {
    private double radius;

    public Circle() {
        this.radius = 1.0;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    public double getCircumference() {
        return 2 * Math.PI * radius;
    }

    public void display() {
        System.out.println("Bán kính: " + radius);
        System.out.println("Diện tích: " + getArea());
        System.out.println("Chu vi: " + getCircumference());
    }
}

public class Bai4 {
    public static void main(String[] args) {
        Circle circle1 = new Circle();
        System.out.println("Thông tin hình tròn mặc định:");
        circle1.display();

        System.out.println();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập bán kính của hình tròn: ");
        double userRadius = scanner.nextDouble();

        Circle circle2 = new Circle(userRadius);
        System.out.println("\nThông tin hình tròn với bán kính do người dùng nhập:");
        circle2.display();

        scanner.close();
    }
}
