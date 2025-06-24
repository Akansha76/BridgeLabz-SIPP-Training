package ConstructorInstanceModifiers.level1;
// Product.java
class Product {
    private String productName;
    private double price;
    private static int totalProducts = 0; // Class variable shared by all instances

    // Constructor
    public Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
        totalProducts++; // Increment count whenever a product is created
    }

    // Instance method
    public void displayProductDetails() {
        System.out.println("Product Name: " + productName);
        System.out.println("Price: ₹" + price);
    }

    // Class method
    public static void displayTotalProducts() {
        System.out.println("Total Products Created: " + totalProducts);
    }
}
public class ProductDemo {
    public static void main(String[] args) {
        Product p1 = new Product("Laptop", 55000);
        Product p2 = new Product("Smartphone", 25000);
        Product p3 = new Product("Headphones", 3000);

        p1.displayProductDetails();
        System.out.println();
        p2.displayProductDetails();
        System.out.println();
        p3.displayProductDetails();
        System.out.println();

        Product.displayTotalProducts();
    }
}
