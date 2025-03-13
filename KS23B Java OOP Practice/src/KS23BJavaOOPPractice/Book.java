package KS23BJavaOOPPractice;

import java.util.Scanner;

public class Book {
    private String bookId;
    private String bookName;
    private double importPrice;
    private double exportPrice;
    private String title;
    private String author;
    private double interest;
    private int year;

    public Book() {
    }

    public Book(String bookId, String bookName, double importPrice, double exportPrice, String title, String author, int year) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.title = title;
        this.author = author;
        this.year = year;
        this.calInterest();
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        if (bookId.matches("^B\\w{4}$")) {
            this.bookId = bookId;
        } else {
            System.out.println("Mã sách phải bắt đầu bằng 'B' và có đúng 5 ký tự!");
        }
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        if (bookName.length() >= 6 && bookName.length() <= 100) {
            this.bookName = bookName;
        } else {
            System.out.println("Tên sách phải có từ 6 - 100 ký tự!");
        }
    }

    public double getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(double importPrice) {
        if (importPrice > 0) {
            this.importPrice = importPrice;
        } else {
            System.out.println("Giá nhập phải lớn hơn 0!");
        }
    }

    public double getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(double exportPrice) {
        if (exportPrice >= importPrice * 1.1) {
            this.exportPrice = exportPrice;
        } else {
            System.out.println("Giá bán phải lớn hơn ít nhất 10% so với giá nhập!");
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (!title.isEmpty()) {
            this.title = title;
        } else {
            System.out.println("Tiêu đề không được để trống!");
        }
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if (!author.isEmpty()) {
            this.author = author;
        } else {
            System.out.println("Tác giả không được để trống!");
        }
    }

    public double getInterest() {
        return interest;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year > 1970) {
            this.year = year;
        } else {
            System.out.println("Năm xuất bản phải sau năm 1970!");
        }
    }

    public void inputData(Scanner scanner) {
        System.out.print("Nhập mã sách (Bxxxx): ");
        setBookId(scanner.nextLine());

        System.out.print("Nhập tên sách: ");
        setBookName(scanner.nextLine());

        System.out.print("Nhập giá nhập: ");
        setImportPrice(scanner.nextDouble());

        System.out.print("Nhập giá bán: ");
        setExportPrice(scanner.nextDouble());
        scanner.nextLine(); // Clear buffer

        System.out.print("Nhập tiêu đề: ");
        setTitle(scanner.nextLine());

        System.out.print("Nhập tác giả: ");
        setAuthor(scanner.nextLine());

        System.out.print("Nhập năm xuất bản: ");
        setYear(scanner.nextInt());
        scanner.nextLine(); // Clear buffer

        calInterest();
    }

    public void calInterest() {
        this.interest = this.exportPrice - this.importPrice;
    }

    public void displayData() {
        System.out.println("Mã sách: " + bookId);
        System.out.println("Tên sách: " + bookName);
        System.out.println("Giá nhập: " + importPrice);
        System.out.println("Giá bán: " + exportPrice);
        System.out.println("Tiêu đề: " + title);
        System.out.println("Tác giả: " + author);
        System.out.println("Lợi nhuận: " + interest);
        System.out.println("Năm xuất bản: " + year);
        System.out.println("----------------------------------");
    }
}
