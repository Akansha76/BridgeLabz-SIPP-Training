package EncaplsulationPolymorphismAbstraction;
import java.util.ArrayList;
import java.util.List;

/* ---------- 1.  ABSTRACT SUPERCLASS ---------- */
abstract class Product {
    /* Encapsulated fields (private) */
    private final String productId;
    private String name;
    private double price;

    /* Constructor */
    protected Product(String productId, String name, double price) {
        this.productId = productId;
        this.name      = name;
        this.price     = price;
    }

    /* Getters / Setters (encapsulation) */
    public String getProductId() { return productId; }
    public String getName()      { return name;     }
    public double getPrice()     { return price;    }

    public void setName(String name)   { this.name  = name; }
    public void setPrice(double price) { this.price = price; }

    /* Abstract behaviour to be specialised by every category */
    public abstract double calculateDiscount();
}

/* ---------- 2.  INTERFACE FOR EXTRA BEHAVIOUR ---------- */
interface Taxable {
    double  calculateTax();
    String  getTaxDetails();
}

/* ---------- 3a.  ELECTRONICS ---------- */
class Electronics extends Product implements Taxable {

    public Electronics(String productId, String name, double price) {
        super(productId, name, price);
    }

    /* 10 % seasonal discount */
    @Override public double calculateDiscount() { return getPrice() * 0.10; }

    /* 18 % GST */
    @Override public double calculateTax()      { return getPrice() * 0.18; }
    @Override public String  getTaxDetails()    { return "GST 18 % on electronics"; }
}

/* ---------- 3b.  CLOTHING ---------- */
class Clothing extends Product implements Taxable {

    public Clothing(String productId, String name, double price) {
        super(productId, name, price);
    }

    /* Flat ₹200 off on items over ₹1500, else 5 % discount */
    @Override
    public double calculateDiscount() {
        return getPrice() > 1500 ? 200 : getPrice() * 0.05;
    }

    /* 12 % tax */
    @Override public double calculateTax()   { return getPrice() * 0.12; }
    @Override public String  getTaxDetails() { return "GST 12% on clothing"; }
}

/* ---------- 3c.  GROCERIES ---------- */
class Groceries extends Product implements Taxable {

    public Groceries(String productId, String name, double price) {
        super(productId, name, price);
    }

    /* No discount (perishable) */
    @Override public double calculateDiscount() { return 0; }

    /* 0 % tax on essentials */
    @Override public double calculateTax()      { return 0; }
    @Override public String  getTaxDetails()    { return "Tax-exempt groceries"; }
}

/* ---------- 4.  UTILITY CLASS TO SHOW POLYMORPHISM ---------- */
class Checkout {

    /** Print final price for every product in the list:
     *  finalPrice = price + tax – discount */
    public static void printInvoice(List<Product> items) {
        System.out.println("----- Invoice -----");
        for (Product p : items) {
            double base      = p.getPrice();
            double discount  = p.calculateDiscount();           // polymorphic call
            double tax       = (p instanceof Taxable t) ? t.calculateTax() : 0;
            double finalCost = base + tax - discount;

            System.out.printf("%-12s %7.2f  (-%.2f  +%.2f)  -  %.2f%n",
                              p.getName(), base, discount, tax, finalCost);
        }
    }
}

/* ---------- 5.  DEMO / DRIVER ---------- */
public class ECommerceDemo {
    public static void main(String[] args) {
        List<Product> cart = new ArrayList<>();
        cart.add(new Electronics("E001", "Smartphone", 29999));
        cart.add(new Clothing   ("C101", "Designer Jacket", 3200));
        cart.add(new Clothing   ("C102", "T-Shirt", 799));
        cart.add(new Groceries  ("G555", "Basmati Rice 5kg", 550));

        Checkout.printInvoice(cart);
    }
}

