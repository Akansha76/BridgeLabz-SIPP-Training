package ScenerioBased.SmartCheckout;
import java.util.*;

public class SmartCheckout {
    Queue<Customer> queue;
    Map<String, Integer> priceMap;
    Map<String, Integer> stockMap;

    public SmartCheckout() {
        queue = new LinkedList<>();
        priceMap = new HashMap<>();
        stockMap = new HashMap<>();
    }

    // Add items to inventory
    public void addItem(String item, int price, int stock) {
        priceMap.put(item, price);
        stockMap.put(item, stock);
    }

    // Add a customer to the queue
    public void addCustomer(Customer customer) {
        queue.add(customer);
        System.out.println("Added to queue: " + customer.name);
    }

    // Remove (process) the front customer
    public void processNextCustomer() {
        if (queue.isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }

        Customer customer = queue.poll();
        int total = 0;

        System.out.println("\nProcessing " + customer.name);
        for (String item : customer.cart) {
            if (!priceMap.containsKey(item)) {
                System.out.println(item + " not found in system.");
                continue;
            }
            int stock = stockMap.getOrDefault(item, 0);
            if (stock <= 0) {
                System.out.println( item + " is out of stock.");
                continue;
            }

            // Add price, reduce stock
            total += priceMap.get(item);
            stockMap.put(item, stock - 1);
            System.out.println(  item + " - Rs" + priceMap.get(item));
        }

        System.out.println(" Total Bill for " + customer.name + ": ₹" + total);
    }

    public void displayStock() {
        System.out.println("\n Current Stock:");
        for (String item : stockMap.keySet()) {
            System.out.println("- " + item + ": " + stockMap.get(item) + " units");
        }
    }

    public void displayQueue() {
        System.out.println("\n Queue:");
        for (Customer c : queue) {
            System.out.println("- " + c.name);
        }
    }
}
