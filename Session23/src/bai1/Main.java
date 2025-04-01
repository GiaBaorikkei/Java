package bai1;

public class Main {
    public static void main(String[] args) {
        Run thread1 = new Run();
        Run thread2 = new Run();

        thread1.start();
        thread2.start();
    }
}