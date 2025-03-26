package bai3;

import java.util.Scanner;
import java.util.function.BiFunction;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số a: ");
        int a = scanner.nextInt();
        System.out.print("Nhập số b: ");
        int b = scanner.nextInt();

        BiFunction<Integer, Integer, Integer> add = MathOperations::add;
        BiFunction<Integer, Integer, Integer> subtract = MathOperations::subtract;
        BiFunction<Integer, Integer, Integer> multiply = MathOperations::multiply;
        BiFunction<Integer, Integer, Integer> divide = MathOperations::divide;

        System.out.println("Kết quả cộng: " + add.apply(a, b));
        System.out.println("Kết quả trừ: " + subtract.apply(a, b));
        System.out.println("Kết quả nhân: " + multiply.apply(a, b));

        try {
            System.out.println("Kết quả chia: " + divide.apply(a, b));
        } catch (ArithmeticException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }

        scanner.close();
    }
}