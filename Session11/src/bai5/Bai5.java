package bai5;

public class Bai5 {
    public static void main(String[] args) {
        Circle circle = new Circle(5.0);
        Rectangle rectangle = new Rectangle(10.0, 4.0);
        Square square = new Square(6.0);

        circle.setColor("Red");
        rectangle.setColor("Blue");
        square.setColor("Green");

        circle.displayInfo();
        rectangle.displayInfo();
        square.displayInfo();
    }
}

