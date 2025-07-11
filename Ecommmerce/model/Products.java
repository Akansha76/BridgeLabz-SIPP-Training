package Ecommmerce.model;


public class Products extends Items {
    private String category;
    private double price;

    public Products(int id, String name, String category, double price) {
        super(id, name);
        this.category = category;
        this.price = price;
    }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    // Polymorphism
    @Override
    public void display() {
        System.out.println("ID: " + getId() + ", Name: " + getName() + 
                           ", Category: " + category + ", Price: $" + price);
    }
}





