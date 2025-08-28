package FunctionalInterface;
// File: CloneDemo.java

class Prototype implements Cloneable {
    private String type;

    public Prototype(String type) {
        this.type = type;
    }

    public String getType() { return type; }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

public class CloneDemo {
    public static void main(String[] args) {
        try {
            Prototype original = new Prototype("Prototype Object");
            Prototype copy = (Prototype) original.clone();

            System.out.println("Original: " + original.getType());
            System.out.println("Cloned: " + copy.getType());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
