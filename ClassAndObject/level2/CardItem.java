class CartItem {
    String itemName;
    double price;
    int quantity;

    // Constructor
    CartItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    // Method to display item info
    void displayItem() {
        System.out.println(itemName + " - ₹" + price + " x " + quantity);
    }

    // Calculate total cost for this item
    double getTotalCost() {
        return price * quantity;
    }

    public static void main(String[] args) {
        CartItem item1 = new CartItem("Laptop", 50000, 1);
        CartItem item2 = new CartItem("Mouse", 500, 2);

        item1.displayItem();
        item2.displayItem();

        double total = item1.getTotalCost() + item2.getTotalCost();
        System.out.println("Total Cart Value: ₹" + total);
    }
}
