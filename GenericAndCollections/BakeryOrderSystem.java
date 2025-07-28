import java.util.*;

class Order {
    private String itemName;
    private int quantity;
    private String category;

    public Order(String itemName, int quantity, String category) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.category = category;
    }

    public String getItemName() { return itemName; }
    public int getQuantity() { return quantity; }
    public String getCategory() { return category; }

    @Override
    public String toString() {
        return itemName + " (" + category + ", Qty: " + quantity + ")";
    }
}

class OrderManager {
    private Queue<Order> orderQueue = new LinkedList<>();

    public void addOrder(Order order) {
        orderQueue.offer(order);
    }

    public Order deliverOrder() {
        return orderQueue.poll();
    }

    public List<Order> filterByCategory(String category) {
        List<Order> result = new ArrayList<>();
        for (Order order : orderQueue) {
            if (order.getCategory().equalsIgnoreCase(category)) {
                result.add(order);
            }
        }
        return result;
    }

    public void printOrders() {
        for (Order order : orderQueue) {
            System.out.println(order);
        }
    }
}

public class BakeryOrderSystem {
    public static void main(String[] args) {
        OrderManager manager = new OrderManager();
        manager.addOrder(new Order("Chocolate Cake", 2, "Cake"));
        manager.addOrder(new Order("Oatmeal Cookie", 5, "Cookie"));
        manager.addOrder(new Order("Strawberry Pastry", 3, "Pastry"));

        System.out.println("All Orders:");
        manager.printOrders();

        System.out.println("\nDelivering Order: " + manager.deliverOrder());

        System.out.println("\nCookies Only:");
        for (Order order : manager.filterByCategory("Cookie")) {
            System.out.println(order);
        }
    }
}