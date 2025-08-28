package FunctionalInterface;

interface PaymentProcessor {
    void processPayment(double amount);

    // Newly added method with default implementation
    default void refund(double amount) {
        System.out.println("Refund feature not supported by this provider.");
    }
}

class PayPal implements PaymentProcessor {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processed payment of $" + amount + " via PayPal.");
    }
}

class Stripe implements PaymentProcessor {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processed payment of $" + amount + " via Stripe.");
    }

    // Override refund because Stripe supports it
    @Override
    public void refund(double amount) {
        System.out.println("Refunded $" + amount + " via Stripe.");
    }
}

public class PaymentGatewayIntegration {
    public static void main(String[] args) {
        PaymentProcessor paypal = new PayPal();
        PaymentProcessor stripe = new Stripe();

        paypal.processPayment(500);
        paypal.refund(200); // uses default (not supported)

        stripe.processPayment(1000);
        stripe.refund(400); // overridden
    }
}
