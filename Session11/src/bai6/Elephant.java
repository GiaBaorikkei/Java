package bai6;

class Elephant extends Animal {
    public Elephant(String name, int age) {
        super(name, age);
    }

    @Override
    void sound() {
        System.out.println(name + " says: Trumpet!");
    }

    @Override
    void move() {
        System.out.println(name + " is walking.");
    }
}

