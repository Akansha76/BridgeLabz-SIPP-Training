package Smartcity.interfaces;


@FunctionalInterface
public interface Farecalc {
    double calculateFare(double distance, double ratePerKm);
}
