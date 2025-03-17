package bai6;

abstract class Animal {
    protected String name;
    protected int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    abstract void sound();
    abstract void move();

    public void displayInfo() {
        System.out.println("Animal: " + name + ", Age: " + age);
    }
}

