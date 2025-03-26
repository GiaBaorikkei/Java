package bai9;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Áo phông", 1200),
                new Product("Quần ngắn", 25),
                new Product("Áo sơ mi", 50),
                new Product("Dép lê", 80),
                new Product("Giày Nike", 300),
                new Product("Áo giữ nhiệt", 20)
        );

        ProductProcessor processor = new ProductProcessorImpl();

        if (processor.hasExpensiveProduct(products)) {
            List<Product> expensiveProducts = products.stream()
                    .filter(product -> product.getPrice() > 100)
                    .collect(Collectors.toList());
            System.out.println("Sản phẩm có giá > 100:");
            ProductProcessor.printProductList(expensiveProducts);
        } else {
            System.out.println("Không có sản phẩm đắt tiền.");
        }

        double totalValue = processor.calculateTotalValue(products);
        System.out.println("Tổng giá trị sản phẩm: $" + totalValue);

        ProductProcessor.printProductList(products);
    }
}