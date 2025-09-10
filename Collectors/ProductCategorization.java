import java.util.*;
import java.util.stream.*;
class Product {
    int id;
    String name;
    String category;
    double price;

    Product(int id, String name, String category, double price) {
        this.id = id; this.name = name; this.category = category; this.price = price;
    }
}

public class ProductCategorization {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product(1, "Laptop", "Electronics", 800),
            new Product(2, "Phone", "Electronics", 600),
            new Product(3, "Shirt", "Clothing", 40),
            new Product(4, "Jeans", "Clothing", 50)
        );

        Map<String, Double> avgPrice =
            products.stream()
                    .collect(Collectors.groupingBy(
                        p -> p.category,
                        Collectors.averagingDouble(p -> p.price)
                    ));

        System.out.println(avgPrice);
    }
}
