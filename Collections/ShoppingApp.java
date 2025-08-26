// Implement a Shopping Cart
// Description:
// Use HashMap to store product prices.
// Use LinkedHashMap to maintain the order of items added.
// Use TreeMap to display items sorted by price.

import java.util.*;

// ------------------ ShoppingCart ------------------
class ShoppingCart {
    private Map<String, Double> productCatalog = new HashMap<>(); // product -> price
    private Map<String, Integer> cart = new LinkedHashMap<>();    // product -> quantity

    // Add product to catalog
    public void addProductToCatalog(String product, double price) {
        productCatalog.put(product, price);
    }

    // Add product to cart
    public void addToCart(String product, int quantity) {
        if (productCatalog.containsKey(product)) {
            cart.put(product, cart.getOrDefault(product, 0) + quantity);
            System.out.println(" Added " + quantity + " x " + product + " to cart.");
        } else {
            System.out.println(" Product not found in catalog: " + product);
        }
    }

    // Display cart (in order of insertion)
    public void displayCart() {
        System.out.println("\n--- Shopping Cart (Insertion Order) ---");
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            String product = entry.getKey();
            int qty = entry.getValue();
            double price = productCatalog.get(product);
            System.out.println(product + " x " + qty + " = " + (price * qty));
        }
    }

    // Display items sorted by price
    public void displaySortedByPrice() {
        System.out.println("\n--- Shopping Cart Sorted by Price ---");
        TreeMap<Double, List<String>> sortedByPrice = new TreeMap<>();

        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            String product = entry.getKey();
            double price = productCatalog.get(product);
            sortedByPrice.computeIfAbsent(price, k -> new ArrayList<>()).add(product);
        }

        for (Map.Entry<Double, List<String>> entry : sortedByPrice.entrySet()) {
            for (String product : entry.getValue()) {
                int qty = cart.get(product);
                System.out.println(product + " (Price: " + entry.getKey() + ", Qty: " + qty +
                        ", Total: " + (entry.getKey() * qty) + ")");
            }
        }
    }

    // Calculate total bill
    public double calculateTotal() {
        double total = 0;
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            total += productCatalog.get(entry.getKey()) * entry.getValue();
        }
        return total;
    }
}

// ------------------ Main ------------------
public class ShoppingApp {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        // Add products to catalog (HashMap)
        cart.addProductToCatalog("Laptop", 70000);
        cart.addProductToCatalog("Headphones", 2000);
        cart.addProductToCatalog("Mouse", 500);
        cart.addProductToCatalog("Keyboard", 1500);

        // Add items to cart (LinkedHashMap preserves order)
        cart.addToCart("Mouse", 2);
        cart.addToCart("Laptop", 1);
        cart.addToCart("Headphones", 1);
        cart.addToCart("Keyboard", 1);

        // Display
        cart.displayCart();
        cart.displaySortedByPrice();

        // Show total bill
        System.out.println("\n Total Bill = " + cart.calculateTotal());
    }
}