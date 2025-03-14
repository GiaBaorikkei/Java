class Book {
    private String title;
    private String author;
    private double price;

    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        setPrice(price);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price >= 0) {
            this.price = price;
        } else {
            System.out.println("Lỗi: Giá sách không thể âm.");
        }
    }

    public void displayInfo() {
        System.out.println("Tên sách: " + title);
        System.out.println("Tác giả: " + author);
        System.out.println("Giá: " + price + " VND");
    }
}
public class Bai4 {
    public static void main(String[] args) {
        Book book1 = new Book("Lập trình Java", "Nguyễn Văn A", 150000);

        System.out.println("Thông tin sách ban đầu:");
        book1.displayInfo();

        System.out.println("\nCập nhật giá sách:");
        book1.setPrice(200000);
        book1.displayInfo();

        System.out.println("\nThử đặt giá trị không hợp lệ:");
        book1.setPrice(-50000);
        book1.displayInfo();
    }
}
