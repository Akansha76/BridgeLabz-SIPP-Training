// Dynamic Online Marketplace
// Concepts: Type Parameters, Generic Methods, Bounded Type Parameters

import java.util.ArrayList;
import java.util.List;

// Abstract base class for all product categories
abstract class ProductCategory {
    public abstract String getCategoryName();
}

// Specific categories
class BookCategory extends ProductCategory {
    public String getCategoryName() {
        return "Books";
    }
}

class ClothingCategory extends ProductCategory {
    public String getCategoryName() {
        return "Clothing";
    }
}

class GadgetCategory extends ProductCategory {
    public String getCategoryName() {
        return "Gadgets";
    }
}

// Generic Product class
class Product<T extends ProductCategory> {
    private String name;
    private double price;
    private T category;

    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public T getCategory() {
        return category;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void displayInfo() {
        System.out.println("Product: " + name + " | Price: $" + price + " | Category: " + category.getCategoryName());
    }
}

// Utility class for marketplace functions
class MarketplaceUtil {
    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        double discountedPrice = product.getPrice() - (product.getPrice() * percentage / 100);
        product.setPrice(discountedPrice);
    }

    public static void displayAllProducts(List<? extends Product<?>> products) {
        for (Product<?> p : products) {
            p.displayInfo();
        }
    }
}

// Demo class
class OnlineMarketplaceDemo {
    public static void main(String[] args) {
        List<Product<?>> catalog = new ArrayList<>();

        Product<BookCategory> book = new Product<>("Java Programming", 499.99, new BookCategory());
        Product<ClothingCategory> tshirt = new Product<>("Graphic T-Shirt", 299.49, new ClothingCategory());
        Product<GadgetCategory> smartwatch = new Product<>("Smartwatch X1", 1999.00, new GadgetCategory());

        catalog.add(book);
        catalog.add(tshirt);
        catalog.add(smartwatch);

        System.out.println("-- Catalog Before Discount --");
        MarketplaceUtil.displayAllProducts(catalog);

        // Apply discount to gadgets
        MarketplaceUtil.applyDiscount(smartwatch, 10);

        System.out.println("\n-- Catalog After 10% Discount on Smartwatch --");
        MarketplaceUtil.displayAllProducts(catalog);
    }
}
