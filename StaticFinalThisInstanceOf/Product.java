

public class Product {

    // 1. STATIC MEMBERS
    private static double discount = 10.0;  // shared by all products (%)

    // 3. FINAL VARIABLE
    private final int productID;  // can't be changed after construction

    // INSTANCE VARIABLES
    private String productName;
    private double price;
    private int quantity;

    // Constructor using 'this'
    public Product(int productID, String productName, double price, int quantity) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    // 2. STATIC METHOD to update discount
    public static void updateDiscount(double newDiscount) {
        discount = newDiscount;
    }

    // Method to display product details (with instanceof check)
    public void showDetails() {
        if (this instanceof Product) {
            System.out.println("\n--- Product Details ---");
            System.out.println("Product ID  : " + productID);
            System.out.println("Name        : " + productName);
            System.out.println("Price       : ₹" + price);
            System.out.println("Quantity    : " + quantity);
            System.out.println("Discount    : " + discount + "%");
            System.out.printf("Final Price : ₹%.2f%n", calculateFinalPrice());
        }
    }

    // Method to calculate price after discount
    private double calculateFinalPrice() {
        double total = price * quantity;
        return total - (total * discount / 100);
    }

    // Main method for testing
    public static void main(String[] args) {
        Product p1 = new Product(1001, "Laptop", 50000, 1);
        Product p2 = new Product(1002, "Headphones", 2000, 2);

        p1.showDetails();
        p2.showDetails();

        // Update the global discount
        Product.updateDiscount(15.0);
        System.out.println("\nUpdated discount to 15%...");

        p1.showDetails();
        p2.showDetails();
    }
}
