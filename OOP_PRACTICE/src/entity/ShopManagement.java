package entity;

import java.util.ArrayList;
import java.util.Scanner;

public class ShopManagement {
    private ArrayList<Categories> categoryList = new ArrayList<>();
    private ArrayList<Product> productList = new ArrayList<>();

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("********** SHOP MENU **********");
            System.out.println("1. Quản lý danh mục");
            System.out.println("2. Quản lý sản phẩm");
            System.out.println("3. Thoát");
            System.out.print("Chọn: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    manageCategories(scanner);
                    break;
                case 2:
                    manageProducts(scanner);
                    break;
                case 3:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 3);
    }

    private void manageCategories(Scanner scanner) {
        int choice;
        do {
            System.out.println("********** CATEGORIE MANAGEMENT **********");
            System.out.println("1. Danh sách danh mục");
            System.out.println("2. Thêm mới danh mục");
            System.out.println("3. Thoát");
            System.out.print("Chọn: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    for (Categories category : categoryList) {
                        category.displayData();
                    }
                    break;
                case 2:
                    Categories newCategory = new Categories();
                    newCategory.inputData(scanner);
                    categoryList.add(newCategory);
                    System.out.println("Thêm danh mục thành công!");
                    break;
                case 3:
                    System.out.println("Quay lại menu chính.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 3);
    }

    private void manageProducts(Scanner scanner) {
        int choice;
        do {
            System.out.println("********** PRODUCT MANAGEMENT **********");
            System.out.println("1. Danh sách sản phẩm");
            System.out.println("2. Thêm mới sản phẩm");
            System.out.println("3. Thoát");
            System.out.print("Chọn: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    for (Product product : productList) {
                        product.displayData();
                    }
                    break;
                case 2:
                    Product newProduct = new Product();
                    newProduct.inputData(scanner);
                    productList.add(newProduct);
                    System.out.println("Thêm sản phẩm thành công!");
                    break;
                case 3:
                    System.out.println("Quay lại menu chính.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 3);
    }
}
