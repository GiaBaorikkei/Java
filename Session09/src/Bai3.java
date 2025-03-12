class Rectangle {
    private double length;
    private double width;

    public Rectangle() {
        this.length = 1;
        this.width = 1;
    }

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double getArea() {
        return length * width;
    }

    public double getPerimeter() {
        return 2 * (length + width);
    }

    public void display() {
        System.out.println("Chiều dài: " + length);
        System.out.println("Chiều rộng: " + width);
        System.out.println("Diện tích: " + getArea());
        System.out.println("Chu vi: " + getPerimeter());
    }
}

public class Bai3 {
    public static void main(String[] args) {
        Rectangle rect1 = new Rectangle();
        System.out.println("Thông tin hình chữ nhật mặc định:");
        rect1.display();

        System.out.println();

        Rectangle rect2 = new Rectangle(8, 4);
        System.out.println("Thông tin hình chữ nhật với kích thước tùy chỉnh:");
        rect2.display();
    }
}
