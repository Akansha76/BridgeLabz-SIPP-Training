// Smart Warehouse Management System
// Concepts: Generic Classes, Bounded Type Parameters, Wildcards

import java.util.ArrayList;
import java.util.List;

// Abstract base class for all warehouse items
abstract class WarehouseItem {
    private String name;
    private double weight;

    public WarehouseItem(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public abstract void displayDetails();
}

// Electronics item
class Electronics extends WarehouseItem {
    private String brand;

    public Electronics(String name, double weight, String brand) {
        super(name, weight);
        this.brand = brand;
    }

    @Override
    public void displayDetails() {
        System.out.println("[Electronics] " + getName() + ", Weight: " + getWeight() + "kg, Brand: " + brand);
    }
}

// Groceries item
class Groceries extends WarehouseItem {
    private String expirationDate;

    public Groceries(String name, double weight, String expirationDate) {
        super(name, weight);
        this.expirationDate = expirationDate;
    }

    @Override
    public void displayDetails() {
        System.out.println("[Groceries] " + getName() + ", Weight: " + getWeight() + "kg, Expires on: " + expirationDate);
    }
}

// Furniture item
class Furniture extends WarehouseItem {
    private String material;

    public Furniture(String name, double weight, String material) {
        super(name, weight);
        this.material = material;
    }

    @Override
    public void displayDetails() {
        System.out.println("[Furniture] " + getName() + ", Weight: " + getWeight() + "kg, Material: " + material);
    }
}

// Generic Storage class for warehouse items
class Storage<T extends WarehouseItem> {
    private List<T> items = new ArrayList<>();

    public void addItem(T item) {
        items.add(item);
    }

    public List<T> getItems() {
        return items;
    }
}

// Utility class to display any list of warehouse items
class WarehouseUtil {
    public static void displayAllItems(List<? extends WarehouseItem> items) {
        for (WarehouseItem item : items) {
            item.displayDetails();
        }
    }
}

// Demo class with main method
class SmartWarehouseDemo {
    public static void main(String[] args) {
        Storage<Electronics> electronicsStorage = new Storage<>();
        electronicsStorage.addItem(new Electronics("Laptop", 2.5, "Dell"));

        Storage<Groceries> groceriesStorage = new Storage<>();
        groceriesStorage.addItem(new Groceries("Rice", 5.0, "2025-12-31"));

        Storage<Furniture> furnitureStorage = new Storage<>();
        furnitureStorage.addItem(new Furniture("Chair", 7.0, "Wood"));

        System.out.println("-- All Electronics --");
        WarehouseUtil.displayAllItems(electronicsStorage.getItems());

        System.out.println("-- All Groceries --");
        WarehouseUtil.displayAllItems(groceriesStorage.getItems());

        System.out.println("-- All Furniture --");
        WarehouseUtil.displayAllItems(furnitureStorage.getItems());
    }
}
