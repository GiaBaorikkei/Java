package entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Categories implements IApp {
    private static int autoId = 1;
    private int id;
    private String name;
    private int priority;
    private String description;
    private boolean status;

    public Categories() {
        this.id = autoId++;
    }

    public Categories(String name, int priority, String description, boolean status) {
        this.id = autoId++;
        this.name = name;
        this.priority = priority;
        this.description = description;
        this.status = status;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getPriority() { return priority; }
    public void setPriority(int priority) { this.priority = priority; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public boolean isStatus() { return status; }
    public void setStatus(boolean status) { this.status = status; }

    @Override
    public void inputData(Scanner scanner) {
        System.out.print("Nhập tên danh mục: ");
        this.name = scanner.nextLine();
        System.out.print("Nhập độ ưu tiên: ");
        this.priority = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nhập mô tả danh mục: ");
        this.description = scanner.nextLine();
        System.out.print("Trạng thái (true: hoạt động, false: không hoạt động): ");
        this.status = scanner.nextBoolean();
    }

    @Override
    public void displayData() {
        System.out.println("Danh mục: " + id + " - " + name + " - Ưu tiên: " + priority + " - " +
                (status ? "Hoạt động" : "Không hoạt động"));
    }

    // Cập nhật danh mục
    public void updateCategory(Scanner scanner) {
        System.out.print("Nhập tên mới: ");
        this.name = scanner.nextLine();
        System.out.print("Nhập độ ưu tiên mới: ");
        this.priority = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nhập mô tả mới: ");
        this.description = scanner.nextLine();
        System.out.print("Trạng thái mới (true: hoạt động, false: không hoạt động): ");
        this.status = scanner.nextBoolean();
    }

    // Xóa danh mục
    public static void deleteCategory(List<Categories> categoriesList, int categoryId) {
        Iterator<Categories> iterator = categoriesList.iterator();
        while (iterator.hasNext()) {
            Categories category = iterator.next();
            if (category.getId() == categoryId) {
                iterator.remove();
                System.out.println("Danh mục đã được xóa thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy danh mục để xóa!");
    }

    // Tìm kiếm danh mục theo tên
    public static Categories searchCategoryByName(List<Categories> categoriesList, String categoryName) {
        for (Categories category : categoriesList) {
            if (category.getName().equalsIgnoreCase(categoryName)) {
                return category;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Categories> categoriesList = new ArrayList<>();

        // Thêm danh mục mẫu
        categoriesList.add(new Categories("Điện tử", 1, "Các sản phẩm điện tử", true));
        categoriesList.add(new Categories("Thời trang", 2, "Quần áo, giày dép", true));

        System.out.print("Nhập tên danh mục cần tìm: ");
        String searchName = scanner.nextLine();
        Categories foundCategory = searchCategoryByName(categoriesList, searchName);
        if (foundCategory != null) {
            foundCategory.displayData();
        } else {
            System.out.println("Không tìm thấy danh mục!");
        }
    }
}
