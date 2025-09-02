package Smartcity.interfaces;


public interface TransportService {
    String getName();
    double getFare(double distance);

    // Default method
    default void printServiceDetails() {
        System.out.println("Service: " + getName() + " | Example fare (10 km): " + getFare(10));
    }
}
