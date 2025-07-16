package ScenerioBased.SmartCheckout;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        SmartCheckout checkout = new SmartCheckout();

        // Setup inventory
        checkout.addItem("Milk", 50, 10);
        checkout.addItem("Bread", 30, 5);
        checkout.addItem("Eggs", 6, 20);

        // Add customers
        checkout.addCustomer(new Customer("Alice", Arrays.asList("Milk", "Eggs", "Eggs")));
        checkout.addCustomer(new Customer("Bob", Arrays.asList("Bread", "Milk", "Butter")));

        // Display before processing
        checkout.displayQueue();
        checkout.displayStock();

        // Process customers
        checkout.processNextCustomer();
        checkout.processNextCustomer();

        // Display after processing
        checkout.displayStock();
    }
}

