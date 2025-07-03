package EncaplsulationPolymorphismAbstraction;

import java.util.*;

// 1. Abstract Class
abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    // Encapsulation - Getters
    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    // Restrict changes
    protected void setQuantity(int quantity) {
        if (quantity > 0) {
            this.quantity = quantity;
        }
    }

    // Concrete Method
    public String getItemDetails() {
        return itemName + " x" + quantity + " @ Rs." + price + " each";
    }

    // Abstract Method
    public abstract double calculateTotalPrice();
}

// 2. Interface
interface Discountable {
    double applyDiscount();
    String getDiscountDetails();
}

// 3a. VegItem Class
class VegItem extends FoodItem implements Discountable {
    public VegItem(String name, double price, int qty) {
        super(name, price, qty);
    }

    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity();
    }

    @Override
    public double applyDiscount() {
        return calculateTotalPrice() * 0.05;
    }

    @Override
    public String getDiscountDetails() {
        return "5 percent discount on veg items";
    }
}

// 3b. NonVegItem Class
class NonVegItem extends FoodItem implements Discountable {
    private static final double NON_VEG_SURCHARGE = 20.0;

    public NonVegItem(String name, double price, int qty) {
        super(name, price, qty);
    }

    @Override
    public double calculateTotalPrice() {
        return (getPrice() + NON_VEG_SURCHARGE) * getQuantity();
    }

    @Override
    public double applyDiscount() {
        return calculateTotalPrice() * 0.03;
    }

    @Override
    public String getDiscountDetails() {
        return "3 percent discount on non veg items";
    }
}

// 4. Order Processor
class OrderProcessor {
    public static void printOrderSummary(List<FoodItem> orderList) {
        double grandTotal = 0;

        System.out.println("Order Summary");
        

        for (FoodItem item : orderList) {
            double total = item.calculateTotalPrice();
            double discount = 0;

            if (item instanceof Discountable) {
                Discountable d = (Discountable) item;
                discount = d.applyDiscount();
            }

            double finalAmount = total - discount;
            grandTotal += finalAmount;

            System.out.println(item.getItemDetails());
            System.out.println("  Total Price: Rs." + total);
            System.out.println("  Discount   : Rs." + discount);
            System.out.println("  Final Price: Rs." + finalAmount);
            System.out.println();
        }

        System.out.println("-------------------------------------------------");
        System.out.println("Total Payable Amount: Rs." + grandTotal);
    }
}

// 5. Main Class
public class OnlineFoodDeliveryDemo {
    public static void main(String[] args) {
        List<FoodItem> cart = new ArrayList<>();

        cart.add(new VegItem("Paneer Butter Masala", 180, 2));
        cart.add(new NonVegItem("Chicken Biryani", 220, 1));
        cart.add(new NonVegItem("Fish Curry", 250, 2));
        cart.add(new VegItem("Veg Pulao", 150, 1));

        OrderProcessor.printOrderSummary(cart);
    }
}
