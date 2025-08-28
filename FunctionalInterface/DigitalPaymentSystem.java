package FunctionalInterface;

// Interface
interface Payment {
    void pay(double amount);
}

// Implementations
class UPI implements Payment {
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " via UPI.");
    }
}

class CreditCard implements Payment {
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " via Credit Card.");
    }
}

class Wallet implements Payment {
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " via Wallet.");
    }
}

public class DigitalPaymentSystem {
    public static void main(String[] args) {
        Payment upi = new UPI();
        Payment card = new CreditCard();
        Payment wallet = new Wallet();

        upi.pay(500.0);
        card.pay(1200.0);
        wallet.pay(300.0);
    }
}
