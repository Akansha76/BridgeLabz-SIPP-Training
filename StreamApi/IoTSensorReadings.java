package StreamApi;

import java.util.*;

public class IoTSensorReadings {
    public static void main(String[] args) {
        List<Integer> sensorReadings = Arrays.asList(45, 78, 30, 90, 55, 20);
        int threshold = 50;

        System.out.println("Sensor Readings Above " + threshold + ":");
        sensorReadings.stream()
                .filter(reading -> reading > threshold)
                .forEach(r -> System.out.println("Reading: " + r));
    }
}
