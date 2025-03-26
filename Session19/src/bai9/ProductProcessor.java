package bai9;

import java.util.List;
import java.util.function.Predicate;

interface ProductProcessor {
    double calculateTotalValue(List<Product> products);

    static void printProductList(List<Product> products) {
        System.out.println("Danh sách sản phẩm:");
        products.forEach(System.out::println);
    }

    default boolean hasExpensiveProduct(List<Product> products) {
        Predicate<Product> isExpensive = product -> product.getPrice() > 100;
        return products.stream().anyMatch(isExpensive);
    }
}
