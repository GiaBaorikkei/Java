package entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Product implements IApp {
    private static List<Product> productList = new ArrayList<>();

    private String productId;
    private String name;
    private float importPrice;
    private float exportPrice;
    private String title;
    private String description;
    private int quantity;
    private int categoryId;
    private int status; // 0: Đang hoạt động, 1: Hết hàng, 2: Không hoạt động

    public Product() {}

    public Product(String productId, String name, float importPrice, float exportPrice,
                   String title, String description, int quantity, int categoryId, int status) {
        this.productId = productId;
        this.name = name;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.title = title;
        this.description = description;
        this.quantity = quantity;
        this.categoryId = categoryId;
        this.status = status;
    }

    // ====== GETTERS & SETTERS ======
    public String getProductId() { return productId; }
    public void setProductId(String productId) { this.productId = productId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public float getImportPrice() { return importPrice; }
    public void setImportPrice(float importPrice) { this.importPrice = importPrice; }
    public float getExportPrice() { return exportPrice; }
    public void setExportPrice(float exportPrice) { this.exportPrice = exportPrice; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public int getCategoryId() { return categoryId; }
    public void setCategoryId(int categoryId) { this.categoryId = categoryId; }
    public int getStatus() { return status; }
    public void setStatus(int status) { this.status = status; }

    // ====== NHẬP DỮ LIỆU ======
    @Override
    public void inputData(Scanner scanner) {
        System.out.print("Nhập mã sản phẩm: ");
        this.productId = scanner.nextLine();
        System.out.print("Nhập tên sản phẩm: ");
        this.name = scanner.nextLine();
        System.out.print("Nhập giá nhập sản phẩm: ");
        this.importPrice = scanner.nextFloat();
        System.out.print("Nhập giá xuất sản phẩm: ");
        this.exportPrice = scanner.nextFloat();
        scanner.nextLine(); // Clear buffer
        System.out.print("Nhập tiêu đề sản phẩm: ");
        this.title = scanner.nextLine();
        System.out.print("Nhập mô tả sản phẩm: ");
        this.description = scanner.nextLine();
        System.out.print("Nhập số lượng sản phẩm: ");
        this.quantity = scanner.nextInt();
        System.out.print("Nhập mã danh mục sản phẩm: ");
        this.categoryId = scanner.nextInt();
        System.out.print("Nhập trạng thái sản phẩm (0: Đang hoạt động, 1: Hết hàng, 2: Không hoạt động): ");
        this.status = scanner.nextInt();

        productList.add(this);
        System.out.println("✅ Thêm sản phẩm thành công!");
    }

    // ====== HIỂN THỊ DỮ LIỆU ======
    @Override
    public void displayData() {
        System.out.println("Mã SP: " + productId + " - Tên: " + name + " - Giá xuất: " + exportPrice +
                " - Số lượng: " + quantity + " - Trạng thái: " + getStatusString());
    }

    private String getStatusString() {
        switch (status) {
            case 0: return "Đang hoạt động";
            case 1: return "Hết hàng";
            case 2: return "Không hoạt động";
            default: return "Không xác định";
        }
    }

    // ====== CẬP NHẬT SẢN PHẨM ======
    public void updateProduct(Scanner scanner) {
        System.out.print("Cập nhật tên sản phẩm: ");
        scanner.nextLine(); // Đọc dòng trống
        this.name = scanner.nextLine();

        System.out.print("Cập nhật giá nhập sản phẩm: ");
        this.importPrice = scanner.nextFloat();

        System.out.print("Cập nhật giá xuất sản phẩm: ");
        this.exportPrice = scanner.nextFloat();

        System.out.print("Cập nhật số lượng sản phẩm: ");
        this.quantity = scanner.nextInt();
    }

    // ====== XÓA SẢN PHẨM ======
    public static void deleteProduct(String id) {
        productList.removeIf(product -> product.getProductId().equals(id));
        System.out.println("✅ Xóa sản phẩm thành công!");
    }

    // ====== TÌM KIẾM SẢN PHẨM ======
    public static Product searchProduct(String keyword) {
        for (Product product : productList) {
            if (product.getName().toLowerCase().contains(keyword.toLowerCase())) {
                return product;
            }
        }
        return null;
    }

    // ====== TÌM KIẾM THEO GIÁ ======
    public static List<Product> searchByPriceRange(float minPrice, float maxPrice) {
        List<Product> result = new ArrayList<>();
        for (Product product : productList) {
            if (product.getExportPrice() >= minPrice && product.getExportPrice() <= maxPrice) {
                result.add(product);
            }
        }
        return result;
    }

    // ====== SẮP XẾP SẢN PHẨM THEO GIÁ ======
    public static void sortByPrice() {
        productList.sort((p1, p2) -> Float.compare(p1.getExportPrice(), p2.getExportPrice()));
        System.out.println("✅ Đã sắp xếp sản phẩm theo giá xuất!");
    }

    // ====== BÁN SẢN PHẨM ======
    public void sellProduct(int soldQuantity) {
        if (soldQuantity > 0 && soldQuantity <= quantity) {
            quantity -= soldQuantity;
            System.out.println("✅ Đã bán " + soldQuantity + " sản phẩm. Số lượng còn lại: " + quantity);
        } else {
            System.out.println("❌ Số lượng bán không hợp lệ!");
        }
    }

    // ====== THỐNG KÊ SẢN PHẨM THEO DANH MỤC ======
    public static void statisticsByCategory() {
        int[] categoryCount = new int[100];
        for (Product product : productList) {
            categoryCount[product.getCategoryId()]++;
        }

        System.out.println("📊 Thống kê sản phẩm theo danh mục:");
        for (int i = 0; i < categoryCount.length; i++) {
            if (categoryCount[i] > 0) {
                System.out.println("Danh mục " + i + ": " + categoryCount[i] + " sản phẩm");
            }
        }
    }
}
