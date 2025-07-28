import java.util.*;

class Item {
    private String itemName;
    private int quantity;
    private double pricePerUnit;

    public Item(String itemName, int quantity, double pricePerUnit) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
    }

    public String getItemName() { return itemName; }
    public int getQuantity() { return quantity; }
    public double getPricePerUnit() { return pricePerUnit; }

    public double getTotalPrice() {
        return quantity * pricePerUnit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(itemName, item.itemName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemName);
    }

    @Override
    public String toString() {
        return itemName + " x " + quantity + " @ " + pricePerUnit;
    }
}

class Cart {
    private Set<Item> items = new HashSet<>();

    public void addItem(Item newItem) {
        items.remove(newItem); // remove if already exists (by name)
        items.add(newItem);
    }

    public double getTotalCost() {
        double total = 0.0;
        for (Item item : items) {
            total += item.getTotalPrice();
        }
        return total;
    }

    public void printCart() {
        for (Item item : items) {
            System.out.println(item);
        }
        System.out.println("Total: Rs. " + getTotalCost());
    }
}

public class SupermarketBillingSystem {
    public static void main(String[] args) {
        Cart cart = new Cart();

        cart.addItem(new Item("Rice", 2, 60.0));
        cart.addItem(new Item("Milk", 1, 40.0));
        cart.addItem(new Item("Rice", 3, 58.0)); // replaces old Rice

        System.out.println("Cart Summary:");
        cart.printCart();
    }
}
