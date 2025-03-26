package bai7;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(5, -2, 10, 0, -7, 3);
        List<Integer> list2 = Arrays.asList(5, 6, 7);

        ListProcessor processor = new ListProcessorImpl();

        ListProcessor.printList(list1);
        if (processor.containsNegative(list1)) {
            System.out.println("Danh sách chứa số âm");
        } else {
            System.out.println("Danh sách không chứa số âm");
        }

        ListProcessor.printList(list2);
        if (processor.containsNegative(list2)) {
            System.out.println("Danh sách chứa số âm");
        } else {
            System.out.println("Danh sách không chứa số âm");
        }
    }
}
