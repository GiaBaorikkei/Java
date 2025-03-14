class Circle {
    private double radius;

    public Circle() {
        this.radius = 1.0;
    }

    public Circle(double radius) {
        setRadius(radius);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        if (radius > 0) {
            this.radius = radius;
        } else {
            System.out.println("Lỗi: Bán kính phải lớn hơn 0.");
        }
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public void displayInfo() {
        System.out.println("Hình tròn có bán kính: " + radius);
        System.out.println("Diện tích: " + getArea());
    }
}
class Cylinder extends Circle {
    private double height;

    public Cylinder() {
        super();
        this.height = 1.0;
    }

    public Cylinder(double radius, double height) {
        super(radius);
        setHeight(height);
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        if (height > 0) {
            this.height = height;
        } else {
            System.out.println("Lỗi: Chiều cao phải lớn hơn 0.");
        }
    }

    public double getVolume() {
        return getArea() * height;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Chiều cao: " + height);
        System.out.println("Thể tích: " + getVolume());
    }
}
public class Bai5 {
    public static void main(String[] args) {
        Circle circle = new Circle(5);
        System.out.println("Thông tin hình tròn:");
        circle.displayInfo();

        System.out.println("\n---------------------\n");

        Cylinder cylinder = new Cylinder(5, 10);
        System.out.println("Thông tin hình trụ:");
        cylinder.displayInfo();

        System.out.println("\n---------------------\n");

        System.out.println("Cập nhật giá trị bán kính và chiều cao:");
        cylinder.setRadius(7);
        cylinder.setHeight(15);
        cylinder.displayInfo();

        System.out.println("\n---------------------\n");

        System.out.println("Thử đặt giá trị không hợp lệ:");
        cylinder.setRadius(-3);
        cylinder.setHeight(-8);
        cylinder.displayInfo();
    }
}
