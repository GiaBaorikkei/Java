package bai6;

class Lion extends Animal {
    public Lion(String name, int age) {
        super(name, age);
    }

    @Override
    void sound() {
        System.out.println(name + " says: Roar!");
    }

    @Override
    void move() {
        System.out.println(name + " is running.");
    }
}

