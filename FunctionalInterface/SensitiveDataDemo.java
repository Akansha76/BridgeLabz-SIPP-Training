package FunctionalInterface;

// File: SensitiveDataDemo.java

interface SensitiveData {}  // Marker interface

class Customer implements SensitiveData {
    private String name;
    private String creditCardNumber;

    public Customer(String name, String creditCardNumber) {
        this.name = name;
        this.creditCardNumber = creditCardNumber;
    }

    public String getName() { return name; }
    public String getCreditCardNumber() { return creditCardNumber; }
}

public class SensitiveDataDemo {
    public static void main(String[] args) {
        Customer cust = new Customer("John Doe", "1234-5678-9876-5432");

        if (cust instanceof SensitiveData) {
            System.out.println("Encrypting sensitive data for: " + cust.getName());
            System.out.println("Encrypted Credit Card: ****-****-****-" +
                    cust.getCreditCardNumber().substring(cust.getCreditCardNumber().length() - 4));
        } else {
            System.out.println("No encryption needed.");
        }
    }
}

