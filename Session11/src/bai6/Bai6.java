package bai6;

public class Bai6 {
    public static void main(String[] args) {
        // Tạo một sở thú
        Zoo myZoo = new Zoo();

        Animal lion = new Lion("Simba", 5);
        Animal elephant = new Elephant("Dumbo", 8);

        myZoo.addAnimal(lion);
        myZoo.addAnimal(elephant);

        myZoo.showAnimals();
    }
}
