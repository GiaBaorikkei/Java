package bai3;

abstract class Vehicle {
    protected String name;
    protected int speed;

    public Vehicle(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }

    abstract void displayInfo();

    void start() {
        System.out.println("Vehicle is starting...");
    }
}

