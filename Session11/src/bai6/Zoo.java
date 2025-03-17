package bai6;

import java.util.ArrayList;
import java.util.List;

class Zoo {
    private List<Animal> animals;

    public Zoo() {
        animals = new ArrayList<>();
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public void showAnimals() {
        for (Animal animal : animals) {
            animal.displayInfo();
            animal.sound();
            animal.move();
            System.out.println("-------------------");
        }
    }
}
