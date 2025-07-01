package Inheritance;

public class Multilevel {
    public static void main(String[] args) {
        DeliveredOrder d1 = new DeliveredOrder(101, "2025-07-01", 123456, "2025-07-04");
        d1.getOrderStatus();
    }
}

class Order {
    int orderId;
    String Date = "";

    Order(int orderId, String Date) {
        this.orderId = orderId;
        this.Date = Date;
    }
}

class ShippedOrder extends Order {
    int trackingNumber;

    ShippedOrder(int orderId, String Date, int trackingNumber) {
        super(orderId, Date);
        this.trackingNumber = trackingNumber;
    }

    void shipped() {
        System.out.println("");
    }
}

class DeliveredOrder extends ShippedOrder {
    String DeliverDate = "";

    DeliveredOrder(int orderId, String Date, int trackingNumber, String DeliverDate) {
        super(orderId, Date, trackingNumber); // fixed argument order
        this.DeliverDate = DeliverDate;
    }

    void getOrderStatus() { // fixed method name
        System.out.println("orderId: " + orderId + 
                           "\nDate: " + Date + 
                           "\nTrackingNumber: " + trackingNumber + 
                           "\nDeliverDate: " + DeliverDate);
    }
}
