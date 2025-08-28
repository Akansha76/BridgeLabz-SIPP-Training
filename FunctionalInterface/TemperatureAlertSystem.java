package FunctionalInterface;

import java.util.function.Predicate;

public class TemperatureAlertSystem {
    public static void main(String[] args) {
        double threshold = 40.0;

        // Predicate to check temperature
        Predicate<Double> isHighTemp = temp -> temp > threshold;

        double[] readings = {35.5, 39.9, 41.2, 45.0, 38.0};

        for (double temp : readings) {
            if (isHighTemp.test(temp)) {
                System.out.println("ALERT: Temperature " + temp + "°C exceeds threshold!");
            } else {
                System.out.println("Safe: Temperature " + temp + "°C is normal.");
            }
        }
    }
}
