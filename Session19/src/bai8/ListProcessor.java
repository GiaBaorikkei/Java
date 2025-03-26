package bai8;

import java.util.List;
import java.util.function.Predicate;

interface ListProcessor {
    int sumOddNumbers(List<Integer> list);

    static void printList(List<Integer> list) {
        System.out.println("Danh sách: " + list);
    }

    default boolean checkOdd(List<Integer> list) {
        Predicate<Integer> isOdd = num -> num % 2 != 0;
        return list.stream().anyMatch(isOdd);
    }
}
