package bai8;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(5, 7, 10, 13, 6, 3);
        List<Integer> list2 = Arrays.asList(2, 4, 6, 8);

        ListProcessor processor = new ListProcessorImpl();

        ListProcessor.printList(list1);
        if (processor.checkOdd(list1)) {
            int sumOdd = processor.sumOddNumbers(list1);
            System.out.println("Tổng các số lẻ: " + sumOdd);
        } else {
            System.out.println("Danh sách không chứa số lẻ");
        }

        ListProcessor.printList(list2);
        if (processor.checkOdd(list2)) {
            int sumOdd = processor.sumOddNumbers(list2);
            System.out.println("Tổng các số lẻ: " + sumOdd);
        } else {
            System.out.println("Danh sách không chứa số lẻ");
        }
    }
}

