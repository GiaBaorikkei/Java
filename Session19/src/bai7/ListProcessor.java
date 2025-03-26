package bai7;

import java.util.List;

interface ListProcessor {
    boolean containsNegative(List<Integer> list);

    static void printList(List<Integer> list) {
        System.out.println("Danh sách: " + list);
    }
}
