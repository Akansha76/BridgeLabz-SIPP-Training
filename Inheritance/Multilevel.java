//package Inheritance;

public class Multilevel {
    public static void main(String[] args) {
        DeliveredOrder d1 =
            new DeliveredOrder(101, "2025-07-01", 123456, "2025-07-04");
        d1.getOrderStatus();
    }
}

class Order {
    int orderId;
    String date;

    Order(int orderId, String date) {
        this.orderId = orderId;
        this.date    = date;
    }
}

class ShippedOrder extends Order {
    int trackingNumber;

    ShippedOrder(int orderId, String date, int trackingNumber) {
        super(orderId, date);
        this.trackingNumber = trackingNumber;
    }
}

class DeliveredOrder extends ShippedOrder {
    String deliveryDate;

    DeliveredOrder(int orderId, String date,
                   int trackingNumber, String deliveryDate) {
        super(orderId, date, trackingNumber);
        this.deliveryDate = deliveryDate;
    }
    
    
    void getOrderStatus() {
        System.out.println(
            "orderId: "        + orderId      + "\n" +
            "orderDate: "      + date         + "\n" +
            "trackingNumber: " + trackingNumber + "\n" +
            "deliveryDate: "   + deliveryDate
        );
    }
}
