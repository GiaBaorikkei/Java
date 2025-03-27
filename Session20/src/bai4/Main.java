package bai4;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("Bảo", LocalDate.of(2005, 8, 21)),
                new Person("Hùng", LocalDate.of(2003, 7, 10)),
                new Person("Thảo", LocalDate.of(2006, 4, 12))
        );

        people.forEach(Person::printInfo);
    }
}
