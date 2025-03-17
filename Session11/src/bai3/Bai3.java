package bai3;

public class Bai3 {
    public static void main(String[] args) {
        Vehicle car = new Car("Toyota", 120);
        Vehicle bike = new Bike("Yamaha", 80);

        car.start();
        car.displayInfo();

        System.out.println();

        bike.start();
        bike.displayInfo();
    }
}
