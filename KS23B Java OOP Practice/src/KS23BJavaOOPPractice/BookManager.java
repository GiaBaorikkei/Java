package KS23BJavaOOPPractice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookManager {
    private List<Book> books;
    private Scanner scanner;

    public BookManager() {
        books = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void addBook() {
        Book book = new Book();
        book.inputData(scanner);
        books.add(book);
        System.out.println("Thêm sách thành công!\n");
    }

    public void showBooks() {
        if (books.isEmpty()) {
            System.out.println("Không có sách trong danh sách!");
        } else {
            for (Book book : books) {
                book.displayData();
            }
        }
    }

    public void calculateProfit() {
        for (Book book : books) {
            book.calInterest();
        }
        System.out.println("Lợi nhuận đã được cập nhật!\n");
    }

    public void sortBooksByProfit() {
        books.sort((b1, b2) -> Double.compare(b1.getInterest(), b2.getInterest()));
        System.out.println("Sách đã được sắp xếp theo lợi nhuận tăng dần!\n");
    }

    public void searchByAuthor() {
        System.out.print("Nhập tên tác giả cần tìm: ");
        String author = scanner.nextLine();
        books.stream()
                .filter(book -> book.getAuthor().equalsIgnoreCase(author))
                .forEach(Book::displayData);
    }

    public void searchByPriceRange() {
        System.out.print("Nhập giá bán tối thiểu: ");
        double minPrice = scanner.nextDouble();
        System.out.print("Nhập giá bán tối đa: ");
        double maxPrice = scanner.nextDouble();
        scanner.nextLine();

        books.stream()
                .filter(book -> book.getExportPrice() >= minPrice && book.getExportPrice() <= maxPrice)
                .forEach(Book::displayData);
    }

    public void showMenu() {
        while (true) {
            System.out.println("\n*************** MENU ***************");
            System.out.println("1. Danh sách sách");
            System.out.println("2. Thêm mới sách");
            System.out.println("3. Tính lợi nhuận");
            System.out.println("4. Sắp xếp sách theo lợi nhuận tăng dần");
            System.out.println("5. Tìm kiếm sách theo tác giả");
            System.out.println("6. Tìm kiếm sách theo khoảng giá bán");
            System.out.println("7. Thoát");
            System.out.print("Chọn chức năng: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (choice) {
                case 1 -> showBooks();
                case 2 -> addBook();
                case 3 -> calculateProfit();
                case 4 -> sortBooksByProfit();
                case 5 -> searchByAuthor();
                case 6 -> searchByPriceRange();
                case 7 -> {
                    System.out.println("Thoát chương trình!");
                    return;
                }
                default -> System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    public static void main(String[] args) {
        new BookManager().showMenu();
    }
}
