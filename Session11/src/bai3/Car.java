package bai3;

class Car extends Vehicle {

    public Car(String name, int speed) {
        super(name, speed);
    }

    @Override
    void displayInfo() {
        System.out.println("Car Name: " + name + ", Speed: " + speed + " km/h");
    }
}
