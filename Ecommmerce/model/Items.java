package Ecommmerce.model;



public abstract class Items {
    private int id;
    private String name;

    public Items(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Encapsulation
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public abstract void display();
}
