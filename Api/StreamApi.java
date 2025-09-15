import java.util.*;

class Item {
    private String name;
    private double price;
    private String category;

    // constructor, getters, setters, toString
    public Item(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getCategory() { return category; }
    @Override
    public String toString() {
        return name + " ($" + price + ", " + category + ")";
    }
}

class Order {
    private Date orderDate;
    private List<Item> items;

    public Order(Date orderDate, List<Item> items) {
        this.orderDate = orderDate;
        this.items = items;
    }
    public Date getOrderDate() { return orderDate; }
    public List<Item> getItems() { return items; }
}

class Customer {
    private String name;
    // constructor, getter
    public Customer(String name) { this.name = name; }
    public String getName() { return name; }
    @Override
    public String toString() { return name; }
}

class Store {
    private Map<Customer, List<Order>> customerOrders;
    public Store(Map<Customer, List<Order>> customerOrders) {
        this.customerOrders = customerOrders;
    }
    public Map<Customer, List<Order>> getCustomerOrders() {
        return customerOrders;
    }
}

