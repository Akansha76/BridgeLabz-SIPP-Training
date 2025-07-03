package EncaplsulationPolymorphismAbstraction;

import java.util.*;

// Abstract Class
abstract class Product {
    private String productId;
    private String name;
    private double price;

    public Product(String productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    // Getters and Setters (Encapsulation)
    public String getProductId() { return productId; }
    public String getName() { return name; }
    public double getPrice() { return price; }

    public void setName(String name) { this.name = name; }
    public void setPrice(double price) { this.price = price; }

    // Abstract Method
    public abstract double calculateDiscount();
}

// Interface
interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

// Electronics Class
class Electronics extends Product implements Taxable {
    public Electronics(String productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.1; // 10% discount
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.18; // 18% GST
    }

    @Override
    public String getTaxDetails() {
        return "18% GST applied on Electronics.";
    }
}

// Clothing Class
class Clothing extends Product implements Taxable {
    public Clothing(String productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() > 1500 ? 200 : getPrice() * 0.05;
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.12; // 12% GST
    }

    @Override
    public String getTaxDetails() {
        return "12% GST applied on Clothing.";
    }
}

// Groceries Class
class Groceries extends Product implements Taxable {
    public Groceries(String productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return 0; // No discount on groceries
    }

    @Override
    public double calculateTax() {
        return 0; // No tax on essential groceries
    }

    @Override
    public String getTaxDetails() {
        return "Tax-exempt product.";
    }
}

// Utility Class to Show Polymorphism
class ProductUtils {
    public static void printFinalPrice(List<Product> productList) {
        System.out.println("--------- Final Invoice ---------");
        for (Product p : productList) {
            double basePrice = p.getPrice();
            double discount = p.calculateDiscount();
            double tax = (p instanceof Taxable) ? ((Taxable) p).calculateTax() : 0;
            double finalPrice = basePrice + tax - discount;

            System.out.printf("Product: %-15s | Base: %.2f | Discount: -%.2f | Tax: +%.2f | Final: %.2f\n",
                    p.getName(), basePrice, discount, tax, finalPrice);
        }
        System.out.println("---------------------------------");
    }
}

// Main Class
public class ECommercePlatform {
    public static void main(String[] args) {
        List<Product> cart = new ArrayList<>();

        cart.add(new Electronics("E101", "Smartphone", 25000));
        cart.add(new Clothing("C201", "Jeans", 1200));
        cart.add(new Clothing("C202", "Jacket", 2000));
        cart.add(new Groceries("G301", "Rice (5kg)", 600));

        ProductUtils.printFinalPrice(cart);
    }
}
