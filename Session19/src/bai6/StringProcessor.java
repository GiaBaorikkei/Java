package bai6;

import java.util.List;

interface StringProcessor {
    String processString(String input);

    default void printList(List<String> list) {
        list.forEach(System.out::println);
    }
}