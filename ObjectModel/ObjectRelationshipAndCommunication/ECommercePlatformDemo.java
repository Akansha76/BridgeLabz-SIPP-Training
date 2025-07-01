import java.util.ArrayList;

public class ECommercePlatformDemo {

    static class Product {
        private final String name;
        private final double price;

        public Product(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String getName() { return name; }

        public double getPrice() { return price; }
    }

    static class Order {
        private static int nextId = 1;
        private final int orderId;
        private final ArrayList<Product> products = new ArrayList<>();

        public Order() {
            this.orderId = nextId++;
        }

        public void addProduct(Product p) {
            products.add(p);
        }

        public void showOrder() {
            System.out.println("\n Order ID: " + orderId);
            double total = 0;
            for (Product p : products) {
                System.out.println( p.getName() + " — ₹" + p.getPrice());
                total += p.getPrice();
            }
            System.out.println("Total: ₹" + total);
        }
    }

    static class Customer {
        private final String name;

        public Customer(String name) {
            this.name = name;
        }

        public Order placeOrder(Product... items) {
            Order order = new Order();
            for (Product p : items) {
                order.addProduct(p);
            }
            System.out.println( name + " placed an order.");
            return order;
        }
    }

    public static void main(String[] args) {
        Customer c1 = new Customer("Akanksha");
        Product p1 = new Product("Phone", 15000);
        Product p2 = new Product("Charger", 1000);
        Product p3 = new Product("Headphones", 2500);

        Order order1 = c1.placeOrder(p1, p2);
        Order order2 = c1.placeOrder(p3);

        order1.showOrder();
        order2.showOrder();
    }
}
